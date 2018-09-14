/*
 * Created by Hoang Hiep on 9/12/18 10:59 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:59 AM
 */

package com.design.dribble.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.design.dribble.viewmodels.LoginViewModel
import com.design.dribble.viewmodels.MainViewModel
import com.fpt.core.di.ViewModelKey
import com.fpt.core.viewmodel.CoreViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: CoreViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun binLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}