/*
 * Created by Hoang Hiep on 9/14/18 8:18 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 9:39 AM
 */

package com.fpt.core.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    var observerError = MutableLiveData<Throwable>()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}