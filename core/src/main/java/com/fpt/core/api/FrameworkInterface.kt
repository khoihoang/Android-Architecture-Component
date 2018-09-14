/*
 * Created by Hoang Hiep on 9/12/18 10:46 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:46 AM
 */

package com.fpt.core.api

import retrofit2.Retrofit

interface FrameworkInterface {
    /**
     * Provides an instance of Retrofit with it's base URL
     */
    abstract fun getRetrofitApiInstance(): Retrofit
}