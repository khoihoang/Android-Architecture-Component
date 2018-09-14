/*
 * Created by Hoang Hiep on 9/13/18 4:45 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/13/18 4:45 PM
 */

package com.design.dribble.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.design.dribble.models.users.User
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Interface for database access on User related operations.
 */
@Dao
abstract class UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg user: User)

    @Query("SELECT * FROM user")
    abstract fun getAccount(): Single<User>
}