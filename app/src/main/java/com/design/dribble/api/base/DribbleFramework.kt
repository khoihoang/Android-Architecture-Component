/*
 * Created by Hoang Hiep on 9/12/18 10:47 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:47 AM
 */

package com.design.dribble.api.base

import retrofit2.Retrofit

object DribbleFramework {
    private lateinit var retrofitInterface: IOFrameworkInterface

    val retrofitApiInstance: Retrofit
        get() = retrofitInterface.getRetrofitApiInstance()


    fun init(frameworkInterface: IOFrameworkInterface) {
        retrofitInterface = frameworkInterface
    }
}