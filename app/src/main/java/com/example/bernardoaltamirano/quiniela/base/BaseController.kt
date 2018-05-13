package com.example.bernardoaltamirano.quiniela.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.di.Injector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by icaboalo on 01/02/18.
 */
abstract class BaseController(args: Bundle? = null) : Controller(args) {

    private var injected: Boolean = false
    private val disposables: CompositeDisposable = CompositeDisposable()
    private var unbinder: Unbinder? = null

    override fun onContextAvailable(context: Context) {
        // Controller instances are retained across config changes, so this method can be called more than once. this makes
        // sure we don't waste any time injecting more than once, though technically it wouldn't change functionality.
        if (!injected) {
            Injector.inject(this)
            injected = true
        }
        super.onContextAvailable(context)
    }

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(layoutRes(), container, false)
        unbinder = ButterKnife.bind(this, view)
        onViewBound(view)
        for (subscription in subscriptions()) {
            disposables.add(subscription)
        }
        return view
    }

    override fun onDestroyView(view: View) {
        disposables.clear()
        if (unbinder != null) {
            unbinder!!.unbind()
            unbinder = null
        }
    }

    protected open fun onViewBound(view: View) {

    }

    protected open fun subscriptions(): Array<Disposable> {
        return arrayOf()
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int
}