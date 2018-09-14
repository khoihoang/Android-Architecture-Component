/*
 * Created by Hoang Hiep on 9/14/18 9:02 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 9:39 AM
 */

package com.fpt.core.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class CoreActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (initLayout() != 0) {
            setContentView(initLayout())
        }
        configureLogic(savedInstanceState)
        setEvents()
    }

    abstract fun initLayout(): Int

    abstract fun configureLogic(savedInstanceState: Bundle?)

    abstract fun setEvents()
}