package com.example.bernardoaltamirano.quiniela.di

import android.app.Activity
import android.content.Context
import com.example.bernardoaltamirano.quiniela.base.BaseActivity
import com.example.bernardoaltamirano.quiniela.base.MyApplication

import java.util.HashMap

import javax.inject.Inject
import javax.inject.Provider

import dagger.android.AndroidInjector

/**
 * Created by icaboalo on 01/02/18.
 *
 * Clase encargada de manejar la inección para cada activity, igual que hacer el clear de las activities
 */
class ActivityInjector @Inject constructor(private var activityInjectors: Map<Class<out Activity>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Activity>>>) {

    private val cache = HashMap<String, AndroidInjector<out Activity>>()

    internal fun inject(activity: Activity) {
        if (activity !is BaseActivity) {
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }

        val instanceId = activity.instanceId
        if (cache.containsKey(instanceId)) {

            @Suppress("UNCHECKED_CAST")
            (cache[instanceId] as AndroidInjector<Activity>).inject(activity)
            return
        }


        @Suppress("UNCHECKED_CAST")
        val injectorFactory = activityInjectors[activity.javaClass]!!.get() as AndroidInjector.Factory<Activity>
        val injector = injectorFactory.create(activity)
        cache[instanceId!!] = injector
        injector.inject(activity)
    }

    internal fun clear(activity: Activity) {
        if (activity !is BaseActivity) {
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }
        cache.remove(activity.instanceId)
    }

    companion object {
        fun get(context: Context): ActivityInjector {
            return (context.applicationContext as MyApplication).activityInjector
        }
    }
}
