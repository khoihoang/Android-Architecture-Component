/*
 * Created by Hoang Hiep on 9/12/18 8:58 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 8:58 PM
 */

package com.design.dribble.repository

import com.design.dribble.api.DribbleApi
import com.design.dribble.models.TokenResponse
import io.reactivex.Observable
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: DribbleApi) {

    /**
     * @method get access token
     * @param url https://dribbble.com/oauth/token
     * @param clientID The client ID you received from Dribbble
     * @param clientSecret The client secret you received from Dribbble
     * @param code The code you received as a response login
     * @param redirectUri The URL in your application where users will be sent after authorization
     * @see [DribbleApi.getAccessToken]
     */
    fun getAccessToken(url: String,
                       clientID: String,
                       clientSecret: String,
                       code: String,
                       redirectUri: String): Observable<TokenResponse> {
        return api.getAccessToken(url, clientID, clientSecret, code, redirectUri)
    }
}