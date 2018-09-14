/*
 * Created by Hoang Hiep on 9/13/18 4:41 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/13/18 4:41 PM
 */

package com.design.dribble.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.design.dribble.db.dao.UserDao
import com.design.dribble.models.users.User

/**
 * Main database description.
 */
@Database(
        entities = [
            User::class],
        version = 1,
        exportSchema = false
)
abstract class DribbbleDb: RoomDatabase() {
    abstract fun userDao(): UserDao
}