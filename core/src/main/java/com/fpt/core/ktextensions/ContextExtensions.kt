/*
 * Created by Hoang Hiep on 9/14/18 9:00 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/12/18 9:39 AM
 */

package com.fpt.core.ktextensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import java.util.*

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, tag: String?) {
    supportFragmentManager.inTransaction {
        tag?.let {
            addToBackStack(it)
        }
        add(frameId, fragment)
    }
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag: String?) {
    supportFragmentManager.inTransaction {
        tag?.let {
            addToBackStack(it)
        }
        replace(frameId, fragment)
    }
}

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) + start

inline fun <reified T : Activity> Context.newIntent(obj: Parcelable?): Intent {
    val intent = Intent(this, T::class.java)
    val name = getExtraName(T::class.java)
    intent.putExtra(name, obj)
    return intent
}

fun getExtraName(target: Class<out Activity>): String {
    return "${target.canonicalName}.ExtraName"
}

inline fun <reified T : Activity> Activity.startActivityEx(obj: Parcelable?) {
    val intent = newIntent<T>(obj)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        this.startActivity(intent)
    } else {
        this.startActivity(intent)
    }
}

inline fun <reified T : Parcelable> Activity.getParameter(): T {
    val name = getExtraName(this.javaClass)
    val obj = intent.getParcelableExtra<T>(name)
    return obj
}

inline fun <reified T : Parcelable> Activity.getParcelableArrayListExtra(): ArrayList<T> {
    val name = getExtraName(this.javaClass)
    val obj = intent.getParcelableArrayListExtra<T>(name)
    return obj
}