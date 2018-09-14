/*
 * Created by Hoang Hiep on 9/12/18 11:01 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 11:01 AM
 */

package com.design.dribble.di

import android.app.Application
import com.design.dribble.DribbleApplication
import com.design.dribble.di.modules.ActivityBindingModule
import com.design.dribble.di.modules.ApplicationModule
import com.design.dribble.di.modules.DataManagerModule
import com.fpt.core.api.EnvironmentSettings
import com.fpt.core.di.modules.ApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ApplicationModule::class, ActivityBindingModule::class, ApiModule::class, DataManagerModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(dribbleApplication: DribbleApplication)
    fun inject(environmentSettings: EnvironmentSettings)
}