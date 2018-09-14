package com.design.dribble.ui.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.design.dribble.R
import com.design.dribble.base.fragments.BaseFragment
import com.design.dribble.viewmodels.MainViewModel

class MainFragment : BaseFragment() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onError(throwable: Throwable?) {
    }

    override fun initLayout() =
            R.layout.fragment_main

    override fun initView(view: View) {
    }

    override fun configureLogic() {
    }

    override fun configureViewModel() {
    }

    override fun onDestroyViews() {
    }
}