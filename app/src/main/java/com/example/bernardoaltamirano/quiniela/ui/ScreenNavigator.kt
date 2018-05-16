package com.example.bernardoaltamirano.quiniela.ui

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router

/**
 * Created by icaboalo on 02/02/18.
 */
interface ScreenNavigator {

    fun initWithRouter(router: Router, rootScreen: Controller)

    fun pop(): Boolean

    fun goToQuinielaDetails(quinielaId: String)

    fun goToRegister()

    fun goToAddQuiniela()

    fun goToChangePassword()

    fun clear()

}