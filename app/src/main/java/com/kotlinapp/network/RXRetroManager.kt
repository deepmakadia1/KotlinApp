package com.kotlinapp.network

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class RXRetroManager<T> {

    protected abstract fun onSuccess(Response: T)

    protected abstract fun onFailure(msg: String)

    @SuppressLint("CheckResult")
    fun rxSingleCall(observable: Observable<T>) {
        Observable.just(
            observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<T>() {
                    override fun onNext(t: T) {
                        onSuccess(t)
                    }

                    override fun onError(e: Throwable) {
                        e.message?.let { onFailure(it) }
                    }

                    override fun onComplete() {

                    }
                })
        )
    }


}
