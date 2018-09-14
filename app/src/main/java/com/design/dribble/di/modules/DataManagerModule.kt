/*
 * Created by Hoang Hiep on 9/12/18 10:59 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:59 AM
 */

package com.design.dribble.di.modules

import com.design.dribble.api.DribbleApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataManagerModule {
    @Provides
    @Singleton
    fun provideDribbleApiFactory(): DribbleApi {
        return DribbleApi()
    }
}