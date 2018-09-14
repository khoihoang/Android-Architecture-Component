/*
 * Created by Hoang Hiep on 9/12/18 3:43 PM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 3:43 PM
 */

package com.design.dribble.utils

import android.net.Uri
import android.text.TextUtils
import java.util.*


object LoginUtils {
    val CLIENT_ID = GlobalVars.CLIENT_ID//"eb1166dff4971bc7e30eb49bbda3579da144c3f2169c15a0d63f8c02acd483f6"
    val CLIENT_SECRET = GlobalVars.CLIENT_SECRET//"a2af24ac9ee77e2617cd066231758ed48d20dce779f7e78b0dada7b0d8d3a5bd"
    val LOGIN_CALLBACK = "dribbble-login-callback"
    val CALLBACK_URI = "rippple://" + LOGIN_CALLBACK
    fun getLoginUrl(): String {
        return ("https://dribbble.com/oauth/authorize?client_id="
                + CLIENT_ID
                + "&redirect_uri=rippple%3A%2F%2F" + LOGIN_CALLBACK
                + "&scope=public+write+comment+upload")
    }

    fun isRedirectUriFound(uri: String, redirectUri: String): Boolean {
        val mUri: Uri
        val mRedirectUri: Uri
        try {
            mUri = Uri.parse(uri)
            mRedirectUri = Uri.parse(redirectUri)
        } catch (e: NullPointerException) {
            return false
        }

        if (mUri == null || mRedirectUri == null) {
            return false
        }
        val rOpaque = mRedirectUri.isOpaque()
        val uOpaque = mUri.isOpaque()
        if (rOpaque != uOpaque) {
            return false
        }
        if (rOpaque) {
            return TextUtils.equals(uri, redirectUri)
        }
        if (!TextUtils.equals(mRedirectUri.getScheme(), mUri.getScheme())) {
            return false
        }
        if (!TextUtils.equals(mRedirectUri.getAuthority(), mUri.getAuthority())) {
            return false
        }
        if (mRedirectUri.getPort() != mUri.getPort()) {
            return false
        }
        if (!TextUtils.isEmpty(mRedirectUri.getPath()) && !TextUtils.equals(mRedirectUri.getPath(), mUri.getPath())) {
            return false
        }
        val paramKeys = getQueryParameterNames(mRedirectUri)
        for (key in paramKeys) {
            if (!TextUtils.equals(mRedirectUri.getQueryParameter(key), mUri.getQueryParameter(key))) {
                return false
            }
        }
        val frag = mRedirectUri.getFragment()
        return if (!TextUtils.isEmpty(frag) && !TextUtils.equals(frag, mUri.getFragment())) {
            false
        } else true
    }

    private val NOT_HIERARCHICAL = "This isn't a hierarchical URI."

    fun getQueryParameterNames(uri: Uri): Set<String> {
        if (uri.isOpaque) {
            throw UnsupportedOperationException(NOT_HIERARCHICAL)
        }

        val query = uri.encodedQuery ?: return Collections.emptySet()

        val names = LinkedHashSet<String>()
        var start = 0
        do {
            val next = query.indexOf('&', start)
            val end = if (next == -1) query.length else next

            var separator = query.indexOf('=', start)
            if (separator > end || separator == -1) {
                separator = end
            }

            val name = query.substring(start, separator)
            names.add(Uri.decode(name))

            // Move start to end of name
            start = end + 1
        } while (start < query.length)

        return Collections.unmodifiableSet(names)
    }
}