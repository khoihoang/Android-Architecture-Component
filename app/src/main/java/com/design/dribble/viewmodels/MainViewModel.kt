/*
 * Created by Hoang Hiep on 9/12/18 11:08 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 11:08 AM
 */

package com.design.dribble.viewmodels

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.design.dribble.models.TokenResponse
import com.design.dribble.models.users.User
import com.design.dribble.repository.MainRepository
import com.fpt.core.ktextensions.addToCompositeDisposable
import com.fpt.core.ktextensions.applySchedulers
import com.fpt.core.viewmodel.BaseViewModel
import io.reactivex.Flowable
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : BaseViewModel() {
    var accountData = MutableLiveData<User>()

    @SuppressLint("CheckResult")
            /**
             * @method get my account
             */
    fun getMyAccount(accessToken: String) {
        mainRepository.getMyUser(accessToken)
                .applySchedulers()
                .addToCompositeDisposable(this)
                .subscribe(
                        {
                            accountData.postValue(it)
                        },
                        {
                            observerError.postValue(it)
                        }
                )
    }
}