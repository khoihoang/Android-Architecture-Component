/*
 * Created by Hoang Hiep on 9/12/18 9:01 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 9:01 PM
 */

package com.design.dribble.viewmodels

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.design.dribble.models.TokenResponse
import com.design.dribble.repository.LoginRepository
import com.fpt.core.ktextensions.addToCompositeDisposable
import com.fpt.core.ktextensions.applySchedulers
import com.fpt.core.viewmodel.BaseViewModel
import timber.log.Timber
import javax.inject.Inject


open class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : BaseViewModel() {
    var tokenLiveData = MutableLiveData<TokenResponse>()
    @SuppressLint("CheckResult")
            /**
             * @method get access token
             * @param url https://dribbble.com/oauth/token
             * @param clientID The client ID you received from Dribbble
             * @param clientSecret The client secret you received from Dribbble
             * @param code The code you received as a response login
             * @param redirectUri The URL in your application where users will be sent after authorization
             * @see [LoginRepository.getAccessToken]
             */
    fun getAccessToken(url: String,
                       clientID: String,
                       clientSecret: String,
                       code: String,
                       redirectUri: String) {
        loginRepository.getAccessToken(url, clientID, clientSecret, code, redirectUri)
                .applySchedulers()
                .addToCompositeDisposable(this)
                .subscribe(
                        {
                            tokenLiveData.postValue(it)
                        },
                        {
                            observerError.postValue(it)
                            Timber.d(it)
                        }
                )
    }
}