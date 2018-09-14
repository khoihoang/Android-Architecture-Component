/*
 * Created by Hoang Hiep on 9/14/18 9:00 AM
 * Copyright (c) 2018 INVOVN SOLUTIONS. All rights reserved.
 * Last modified 9/14/18 8:56 AM
 */

@file:JvmName("RxCompositeExtensions")

package com.fpt.core.ktextensions

import com.fpt.core.viewmodel.BaseViewModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

/**
 * Adds the subscription to the upstream [Observable] to the [CompositeDisposable]
 * supplied by a class extending [BasePresenter]. This allows the subscription to be
 * cancelled automatically by the Presenter on Android lifecycle events.
 *
 * @param presenter A class extending [BasePresenter]
 * @param <T>       The type of the upstream [Observable]
 */
fun <T> Observable<T>.addToCompositeDisposable(viewModel: BaseViewModel): Observable<T> =
    this.doOnSubscribe { viewModel.compositeDisposable.add(it) }

/**
 * Adds the subscription to the upstream [Completable] to the [CompositeDisposable] supplied by a
 * class extending [BasePresenter]. This allows the subscription to be cancelled automatically by
 * the Presenter on Android lifecycle events.
 *
 * @param presenter A class extending [BasePresenter]
 */
fun Completable.addToCompositeDisposable(viewModel: BaseViewModel): Completable =
    this.doOnSubscribe { viewModel.compositeDisposable.add(it) }

/**
 * Adds the subscription to the upstream [Single] to the [CompositeDisposable]
 * supplied by a class extending [BasePresenter]. This allows the subscription to be
 * cancelled automatically by the Presenter on Android lifecycle events.
 *
 * @param presenter A class extending [BasePresenter]
 * @param <T>       The type of the upstream [Single]
 */
fun <T> Single<T>.addToCompositeDisposable(viewModel: BaseViewModel): Single<T> =
    this.doOnSubscribe { viewModel.compositeDisposable.add(it) }

/**
 * Adds the subscription to the upstream [Observable] to the [CompositeDisposable]
 * supplied by a class implementing [MemorySafeSubscription]. This allows the subscription to be
 * cancelled automatically by the Presenter on Android lifecycle events.
 *
 * @param presenter A class implementing [MemorySafeSubscription]
 * @param <T>       The type of the upstream [Observable]
 */
fun <T> Observable<T>.addToCompositeDisposable(presenter: MemorySafeSubscription): Observable<T> =
        this.doOnSubscribe { presenter.compositeDisposable.add(it) }

/**
 * Adds the subscription to the upstream [Completable] to the [CompositeDisposable] supplied by a
 * class implementing [MemorySafeSubscription]. This allows the subscription to be cancelled automatically by
 * the Presenter on Android lifecycle events.
 *
 * @param presenter A class implementing [MemorySafeSubscription]
 */
fun Completable.addToCompositeDisposable(presenter: MemorySafeSubscription): Completable =
        this.doOnSubscribe { presenter.compositeDisposable.add(it) }

/**
 * Adds the subscription to the upstream [Single] to the [CompositeDisposable]
 * supplied by a class implementing [MemorySafeSubscription]. This allows the subscription to be
 * cancelled automatically by the Presenter on Android lifecycle events.
 *
 * @param presenter A class implementing [MemorySafeSubscription]
 * @param <T>       The type of the upstream [Single]
 */
fun <T> Single<T>.addToCompositeDisposable(presenter: MemorySafeSubscription): Single<T> =
        this.doOnSubscribe { presenter.compositeDisposable.add(it) }

interface MemorySafeSubscription {

    val compositeDisposable: CompositeDisposable
}