/*
 * Created by Hoang Hiep on 9/14/18 8:45 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/14/18 8:45 AM
 */

package com.fpt.core.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SharedViewModel<T> : ViewModel() {
    private val selected = MutableLiveData<T>()

    fun select(item: T) {
        selected.value = item
    }

    fun getSelected(): LiveData<T> {
        return selected
    }
}
