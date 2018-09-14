/*
 * Created by Hoang Hiep on 9/12/18 10:42 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:41 AM
 */

package com.design.dribble

import android.app.Activity
import android.app.Application
import com.design.dribble.api.base.DribbleFramework
import com.design.dribble.api.base.IOFrameworkInterface
import com.design.dribble.di.AppInjector
import dagger.Lazy
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class DribbleApplication : Application(), HasActivityInjector, IOFrameworkInterface {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @field:[Inject Named("api")]
    lateinit var retrofitApi: Lazy<Retrofit>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        // Inject into Application
        AppInjector.init(this)
        // Pass objects API
        DribbleFramework.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

    override fun getRetrofitApiInstance() = retrofitApi.get()
}