/*
 * Created by Hoang Hiep on 9/12/18 1:39 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 1:39 PM
 */

package com.design.dribble.ui.activitys

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsClient
import android.support.customtabs.CustomTabsIntent
import android.support.customtabs.CustomTabsServiceConnection
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.TextView
import androidx.core.content.edit
import com.design.dribble.R
import com.design.dribble.base.activitys.BaseActivity
import com.design.dribble.models.TokenResponse
import com.design.dribble.utils.Constrants.KEY_OAUTH_TOKEN
import com.design.dribble.utils.Constrants.URL_ACCESS_TOKEN
import com.design.dribble.utils.LoginUtils
import com.design.dribble.utils.LoginUtils.CALLBACK_URI
import com.design.dribble.utils.LoginUtils.CLIENT_ID
import com.design.dribble.utils.LoginUtils.CLIENT_SECRET
import com.design.dribble.utils.LoginUtils.isRedirectUriFound
import com.design.dribble.viewmodels.LoginViewModel
import com.fpt.core.ktextensions.gone
import com.fpt.core.ktextensions.visible
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() {
    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }
    private var connection: CustomTabsServiceConnection? = null

    override fun initLayout(): Int {
        return R.layout.activity_login
    }

    override fun configureLogic(savedInstanceState: Bundle?) {
        imgClose.setOnClickListener {
            finish()
        }
        btnBasic.setOnClickListener {
            // Use a CustomTabsIntent.Builder to configure CustomTabsIntent.
            val url = LoginUtils.getLoginUrl()
            connection = object : CustomTabsServiceConnection() {
                override fun onCustomTabsServiceConnected(componentName: ComponentName, client: CustomTabsClient) {
                    val builder = CustomTabsIntent.Builder()
                    val intent = builder.build()
                    client.warmup(0L) // This prevents backgrounding after redirection
                    intent.launchUrl(this@LoginActivity, Uri.parse(url))//pass the url you need to open
                }

                override fun onServiceDisconnected(name: ComponentName) {

                }
            }
            CustomTabsClient.bindCustomTabsService(this, "com.android.chrome", connection)

        }
    }

    override fun setEvents() {
        viewModel.tokenLiveData.observe(this, Observer<TokenResponse> { it ->
            it?.let {
                sharedPreferences.edit {
                    putString(KEY_OAUTH_TOKEN, it.accessToken)
                }
                progressBar.gone()
                setResult(MainActivity.LOGIN)
                finish()
            }
        })
        viewModel.observerError.observe(this, Observer<Throwable> {
            progressBar.gone()
            it?.printStackTrace()
        })
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val action = intent?.getAction()
        val data = intent?.getDataString()//parse this to get the data
        if (Intent.ACTION_VIEW.equals(action) && data != null) {
            if (isRedirectUriFound(data, CALLBACK_URI)) {
                if (!TextUtils.isEmpty(Uri.parse(data).getQueryParameter("error_description"))) {
                    Snackbar.make(container, Uri.parse(data).getQueryParameter("error_description")?.replace("+", " ")
                            ?: "Error",
                            Snackbar.LENGTH_LONG).apply {
                        view.setBackgroundColor(ContextCompat.getColor(this@LoginActivity, android.R.color.white))
                        val textView = view.findViewById(android.support.design.R.id.snackbar_text) as TextView
                        textView.setTextColor(ContextCompat.getColor(this@LoginActivity, R.color.colorPrimary))
                        show()
                    }
                    return
                }
                getAccessToken(Uri.parse(data).getQueryParameter("code"))
            }
        }
    }

    fun getAccessToken(code: String?) {
        progressBar.visible()
        code?.let {
            viewModel.getAccessToken(
                    url = URL_ACCESS_TOKEN,
                    clientID = CLIENT_ID,
                    clientSecret = CLIENT_SECRET,
                    redirectUri = CALLBACK_URI,
                    code = it
            )
        }
    }

    override fun onDestroy() {
        connection?.let {
            this.unbindService(it)
            connection = null
        }
        super.onDestroy()
    }
}