
/*
 * Created by Hoang Hiep on 9/12/18 11:03 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/10/18 1:22 PM
 */

package com.design.dribble.base.activitys

import android.arch.lifecycle.ViewModelProvider
import android.content.SharedPreferences
import android.support.v4.app.Fragment
import com.fpt.core.base.CoreActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity: CoreActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}