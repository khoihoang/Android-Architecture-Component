/*
 * Created by Hoang Hiep on 9/12/18 10:54 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:54 AM
 */

package com.design.dribble.api

import com.design.dribble.api.base.DribbleFramework
import com.design.dribble.api.endpoint.DribbleEndpoint
import com.design.dribble.models.TokenResponse
import com.design.dribble.models.users.User
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

class DribbleApi {
    /**
     * Lazily evaluates an instance of [DribbleEndpoint].
     */
    private val endpoints: DribbleEndpoint by lazy {
        DribbleFramework.retrofitApiInstance
                .create(DribbleEndpoint::class.java)
    }

    fun onSample(): Single<List<String>> {
        return endpoints.onTrending("swift")
    }

    /**
     * @method get access token
     * @param url https://dribbble.com/oauth/token
     * @param clientID The client ID you received from Dribbble
     * @param clientSecret The client secret you received from Dribbble
     * @param code The code you received as a response login
     * @param redirectUri The URL in your application where users will be sent after authorization
     * @see [DribbleEndpoint.getAccessToken]
     */
    fun getAccessToken(url: String,
                       clientID: String,
                       clientSecret: String,
                       code: String,
                       redirectUri: String): Observable<TokenResponse> {
        return endpoints.getAccessToken(url, clientID, clientSecret, code, redirectUri)
    }

    /**
     * @method get my acccount
     * @see [DribbleEndpoint.getMyAccount]
     */
    fun getMyAccount(accessToken: String): Observable<User> {
        return endpoints.getMyAccount(accessToken)
    }
}