package com.example.bernardoaltamirano.quiniela.ui

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.example.bernardoaltamirano.quiniela.di.ActivityScope
import com.example.bernardoaltamirano.quiniela.login.register.RegisterController
import com.example.bernardoaltamirano.quiniela.main.quiniela.add.AddQuinielaController
import com.example.bernardoaltamirano.quiniela.main.quiniela.add.AddQuinielaPresenter
import com.example.bernardoaltamirano.quiniela.main.quiniela.answer.SendAnswerController
import com.example.bernardoaltamirano.quiniela.main.quiniela.detail.QuinielaDetailsController
import com.example.bernardoaltamirano.quiniela.profile.change_password.ChangePasswordController
import javax.inject.Inject

/**
 * Created by icaboalo on 02/02/18.
 */
@ActivityScope
class ScreenNavigatorImpl @Inject constructor() : ScreenNavigator {

    private var router: Router? = null

    override fun initWithRouter(router: Router, rootScreen: Controller) {
        this.router = router
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(rootScreen))
        }
    }

    override fun pop(): Boolean {
        return router != null && router!!.handleBack()
    }

    override fun goToQuinielaDetails(quinielaId: String) {
        if (router != null) {
            router!!.pushController(RouterTransaction.with(QuinielaDetailsController.newInstance(quinielaId))
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(FadeChangeHandler()))
        }
    }

    override fun goToRegister() {
        if (router != null) {
            router!!.pushController(RouterTransaction.with(RegisterController())
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(FadeChangeHandler()))
        }
    }

    override fun goToAddQuiniela() {
        if (router != null) {
            router!!.pushController(RouterTransaction.with(AddQuinielaController())
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(FadeChangeHandler()))
        }
    }

    override fun goToChangePassword() {
        if (router != null) {
            router!!.pushController(RouterTransaction.with(ChangePasswordController())
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(FadeChangeHandler()))
        }
    }

    override fun gotoSendAnswer(quinielaId: String) {
        if (router != null) {
            router!!.pushController(RouterTransaction.with(SendAnswerController.newInstance(quinielaId))
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(FadeChangeHandler()))
        }
    }

    override fun clear() {
        router = null
    }
}