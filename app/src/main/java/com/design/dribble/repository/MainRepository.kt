/*
 * Created by Hoang Hiep on 9/12/18 11:08 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 11:08 AM
 */

package com.design.dribble.repository

import android.annotation.SuppressLint
import android.arch.persistence.room.EmptyResultSetException
import com.design.dribble.api.DribbleApi
import com.design.dribble.db.dao.UserDao
import com.design.dribble.models.users.User
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: DribbleApi,
                                         private val userDao: UserDao) {
    /**
     * @method get my account
     */
    fun getMyUser(accessToken: String): Observable<User> {
        return Observable.concatArray(
                getMyAccountFromDb(),
                getUsersFromApi(accessToken)
        ).onErrorResumeNext(Function {
            if (it is EmptyResultSetException) {
                return@Function getUsersFromApi(accessToken)
            }
            return@Function Observable.error(it)
        })
    }

    private fun getUsersFromApi(accessToken: String): Observable<User> {
        return api.getMyAccount(accessToken)
                .doOnNext {
                    Timber.d("Dispatching ${it.name} users from API...")
                    storeUsersInDb(it)
                }
    }

    private fun getMyAccountFromDb(): Observable<User> {
        return userDao.getAccount()
                .toObservable()
                .doOnNext {
                    Timber.d("Dispatching ${it.name} users from DB...")
                }
    }

    @SuppressLint("CheckResult")
    private fun storeUsersInDb(users: User) {
        Observable.fromCallable { userDao.insert(users) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                    Timber.d("Inserted ${users.name} users from API in DB...")
                }
    }
}