/*
 * Created by Hoang Hiep on 9/12/18 11:03 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/11/18 1:28 PM
 */

package com.design.dribble.base.fragments

import android.arch.lifecycle.ViewModelProvider
import com.design.dribble.base.activitys.BaseActivity
import com.fpt.core.base.CoreFragment
import com.fpt.core.di.Injectable
import javax.inject.Inject

abstract class BaseFragment : CoreFragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun onError(throwable: Throwable?)

    fun baseActivity(): BaseActivity {
        return activity as BaseActivity
    }
}