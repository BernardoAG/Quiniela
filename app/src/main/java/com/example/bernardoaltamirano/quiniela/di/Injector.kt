package com.example.bernardoaltamirano.quiniela.di

import android.app.Activity
import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.di.ActivityInjector

/**
 * Created by icaboalo on 01/02/18.
 */

class Injector internal constructor(){

    companion object  {
        fun inject(activity: Activity) {
            ActivityInjector.get(activity).inject(activity)
        }

        fun clearComponent(activity: Activity) {
            ActivityInjector.get(activity).clear(activity)
        }

        fun inject(controller: Controller) {
            ScreenInjector.get(controller.activity!!).inject(controller)
        }

        fun clearComponent(controller: Controller) {
            ScreenInjector.get(controller.activity!!).clear(controller)
        }
    }
}
