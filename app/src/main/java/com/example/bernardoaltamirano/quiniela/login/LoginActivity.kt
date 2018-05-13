package com.example.bernardoaltamirano.quiniela.login

import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseActivity
import com.example.bernardoaltamirano.quiniela.login.login.LoginController

class LoginActivity : BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_login
    }

    override fun initialScreen(): Controller {
        return LoginController()
    }
}
