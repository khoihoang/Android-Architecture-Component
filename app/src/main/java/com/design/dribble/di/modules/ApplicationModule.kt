/*
 * Created by Hoang Hiep on 9/12/18 10:58 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:58 AM
 */

package com.design.dribble.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import com.design.dribble.db.DribbbleDb
import com.design.dribble.db.dao.UserDao
import com.fpt.core.di.modules.CoreApplicationModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule : CoreApplicationModule() {

    @Singleton
    @Provides
    fun provideDb(app: Application): DribbbleDb {
        return Room
                .databaseBuilder(app, DribbbleDb::class.java, "dribbble.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: DribbbleDb): UserDao {
        return db.userDao()
    }
}