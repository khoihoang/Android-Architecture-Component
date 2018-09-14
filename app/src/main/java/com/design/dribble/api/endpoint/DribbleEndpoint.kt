/*
 * Created by Hoang Hiep on 9/12/18 10:54 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:54 AM
 */

package com.design.dribble.api.endpoint

import com.design.dribble.models.TokenResponse
import com.design.dribble.models.users.User
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface DribbleEndpoint {
    @GET("/repositories")
    fun onTrending(@Query("language") language: String): Single<List<String>>

    /**
     * @method get access token
     * @param url https://dribbble.com/oauth/token
     * @param clientID The client ID you received from Dribbble
     * @param clientSecret The client secret you received from Dribbble
     * @param code The code you received as a response login
     * @param redirectUri The URL in your application where users will be sent after authorization
     */
    @FormUrlEncoded
    @POST
    fun getAccessToken(@Url url: String,
                       @Field("client_id") clientID: String,
                       @Field("client_secret") clientSecret: String,
                       @Field("code") code: String,
                       @Field("redirect_uri") redirectUri: String): Observable<TokenResponse>

    /**
     * @method get my account
     */
    @GET("user")
    fun getMyAccount(@Query("access_token") accessToken: String): Observable<User>

    /**
     * @method get list shots
     * @param accessToken [GlobalVars.CLIENT_ACCESS_TOKEN]
     * @param sort The sort field with the following possible values
     *          comments
     *          recent
     *          views
     *          Default: Results are sorted by popularity.
     * @param list Limit the results to a specific type with the following possible values:
     *          animated
                attachments
                debuts
                playoffs
                rebounds
                teams
                Default: Results of any type.
     * @param timeFrame A period of time to limit the results to with the following possible values:
     *          week
     *          month
     *          year
     *          ever
     *          Note that the value is ignored when sorting with recent.
     *          Default: Results from now.
     * @param page
     * @param parPage
     * */
    @GET("shots")
    fun getShots(@Query("access_token") accessToken: String,
                 @Query("sort") sort: String,
                 @Query("list") list: String,
                 @Query("timeframe") timeFrame: String,
                 @Query("page") page: Int,
                 @Query("per_page") parPage: Int)
}