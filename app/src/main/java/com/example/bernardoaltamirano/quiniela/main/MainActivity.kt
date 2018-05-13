package com.example.bernardoaltamirano.quiniela.main

import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseActivity
import com.example.bernardoaltamirano.quiniela.main.quiniela.list.QuinielasController

class MainActivity : BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initialScreen(): Controller {
        return QuinielasController()
    }
}
