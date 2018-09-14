/*
 * Created by Hoang Hiep on 9/14/18 9:02 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 9:39 AM
 */

package com.fpt.core.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class CoreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(initLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.configureLogic()
        this.configureViewModel()
    }

    override fun onDestroyView() {
        onDestroyViews()
        super.onDestroyView()
    }

    /**
     * @method add id layout to view
     * @return [Int] id layout
     */
    abstract fun initLayout(): Int

    /**
     * @method init view
     * @param view
     */
    abstract fun initView(view: View)

    /**
     * @method config dagger
     */
    abstract fun configureLogic()

    /**
     * @method config view model
     */
    abstract fun configureViewModel()

    abstract fun onDestroyViews()
}