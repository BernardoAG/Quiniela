package com.example.bernardoaltamirano.quiniela.di

import android.app.Activity
import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.base.BaseActivity
import com.example.bernardoaltamirano.quiniela.base.BaseController
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by icaboalo on 01/02/18.
 */
@ActivityScope
class ScreenInjector @Inject constructor(private val screenInjectors: Map<Class<out Controller>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Controller>>>) {

    private val cache: HashMap<String, AndroidInjector<Controller>> = HashMap()

    fun inject(controller: Controller) {
        if (controller !is BaseController) {
            throw IllegalArgumentException("Controller must extend BaseController")
        }

        val instanceId: String = controller.instanceId
        if (cache.containsKey(instanceId)) {
            cache[instanceId]!!.inject(controller)
            return
        }

        @Suppress("UNCHECKED_CAST")
        val injectorFactory: AndroidInjector.Factory<Controller> =
                screenInjectors[controller.javaClass]!!.get() as AndroidInjector.Factory<Controller>
        val injector: AndroidInjector<Controller> = injectorFactory.create(controller)
        cache[instanceId] = injector
        injector.inject(controller)
    }

    fun clear(controller: Controller) {
        cache.remove(controller.instanceId)
    }

    companion object {
        fun get(activity: Activity): ScreenInjector {
            if (activity !is BaseActivity) {
                throw IllegalArgumentException("Controller must be hosted by BaseActivity")
            }

            return activity.screenInjector
        }
    }
}