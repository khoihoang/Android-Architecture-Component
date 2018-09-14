/*
 * Created by Hoang Hiep on 9/12/18 11:05 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 10:35 AM
 */

package com.design.dribble.ui.activitys

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.design.dribble.R
import com.design.dribble.base.activitys.BaseActivity
import com.design.dribble.models.TokenResponse
import com.design.dribble.models.users.User
import com.design.dribble.utils.Constrants
import com.design.dribble.viewmodels.MainViewModel
import com.fpt.core.GlideApp
import com.fpt.core.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun initLayout() =
            R.layout.activity_main

    override fun configureLogic(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar)
        initLogin()
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        val navController = Navigation.findNavController(this, R.id.nav_fragment)
        navController.run {
            NavigationUI.setupActionBarWithNavController(this@MainActivity, this, drawer_layout)
            nav_view.setupWithNavController(this)
        }
    }

    fun initLogin() {
        sharedPreferences.apply {
            val token = getString(Constrants.KEY_OAUTH_TOKEN, null)
            if (TextUtils.isEmpty(token)) {
                startActivityForResult(Intent(this@MainActivity, LoginActivity::class.java), LOGIN)
            } else {
                viewModel.getMyAccount(token)
            }
        }
    }

    override fun setEvents() {
        val name = nav_view.getHeaderView(0).findViewById<TextView>(R.id.name)
        val location = nav_view.getHeaderView(0).findViewById<TextView>(R.id.location)
        val profile = nav_view.getHeaderView(0).findViewById<ImageView>(R.id.imageView)
        viewModel.accountData.observe(this, Observer<User> { it ->
            it?.let {
                name.text = it.name
                location.text = it.location
                GlideApp.with(profile)
                        .load(it.avatarUrl)
                        .into(profile)
            }
        })
        viewModel.observerError.observe(this, Observer<Throwable> {
            it?.printStackTrace()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            LOGIN -> {
                initLogin()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(drawer_layout,
                Navigation.findNavController(this, R.id.nav_fragment))
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_search -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val LOGIN = 101
    }
}
