package com.example.bernardoaltamirano.quiniela.profile

import com.bluelinelabs.conductor.Controller
import com.example.bernardoaltamirano.quiniela.R
import com.example.bernardoaltamirano.quiniela.base.BaseActivity
import com.example.bernardoaltamirano.quiniela.profile.info.ProfileController

class ProfileActivity: BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_profile
    }

    override fun initialScreen(): Controller {
        return ProfileController()
    }
}