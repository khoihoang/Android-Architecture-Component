/*
 * Created by Hoang Hiep on 9/12/18 10:58 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:58 AM
 */

package com.design.dribble.di.modules

import com.design.dribble.ui.fragments.ExploreFragment
import com.design.dribble.ui.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeExploreFragment(): ExploreFragment
}