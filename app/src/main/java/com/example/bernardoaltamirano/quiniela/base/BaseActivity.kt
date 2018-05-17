package com.example.bernardoaltamirano.quiniela.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.di.Injector
import com.example.bernardoaltamirano.quiniela.di.ScreenInjector
import com.example.bernardoaltamirano.quiniela.ui.ScreenNavigator

import java.util.UUID
import javax.inject.Inject

/**
 * Created by icaboalo on 01/02/18.
 *
 * Activity base con todos los métodos de injección y navegación entre pantallas.
 * Toda activity debe extender de esta para poder tener el funcionamiento pleno.
 */

abstract class BaseActivity : AppCompatActivity() {
    var instanceId: String? = null
        private set
    private var router: Router? = null

    @Inject
    lateinit var screenInjector: ScreenInjector

    @Inject
    lateinit var screenNavigator: ScreenNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY)
        } else {
            instanceId = UUID.randomUUID().toString()
        }
        Injector.inject(this)
        setContentView(layoutRes())

        val screenContainer: ViewGroup = findViewById(R.id.screen_container) ?: throw NullPointerException("Activity must have a view with id: screen_container")

        router = Conductor.attachRouter(this, screenContainer, savedInstanceState)
        screenNavigator.initWithRouter(router!!, initialScreen())
        monitorBackStack()
        super.onCreate(savedInstanceState)
    }

    override fun onBackPressed() {
        if (!screenNavigator.pop()) {
            super.onBackPressed()
        }
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun initialScreen(): Controller

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putString(INSTANCE_ID_KEY, instanceId)
    }

    companion object {

        private const val INSTANCE_ID_KEY = "instance_id"
    }

    override fun onDestroy() {
        super.onDestroy()
        screenNavigator.clear()
        if (isFinishing) {
            Injector.clearComponent(this)
        }
    }

    private fun monitorBackStack() {
        router!!.addChangeListener(object: ControllerChangeHandler.ControllerChangeListener {
            override fun onChangeStarted(to: Controller?, from: Controller?, isPush: Boolean,
                                         container: ViewGroup, handler: ControllerChangeHandler) {

            }

            override fun onChangeCompleted(to: Controller?, from: Controller?, isPush: Boolean,
                                           container: ViewGroup, handler: ControllerChangeHandler) {
                if (!isPush && from != null) {
                    Injector.clearComponent(from)
                }
            }
        })
    }
}
