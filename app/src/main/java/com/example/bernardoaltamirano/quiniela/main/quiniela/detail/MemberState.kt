package com.example.bernardoaltamirano.quiniela.main.quiniela.detail

import com.example.bernardoaltamirano.quiniela.model.User

data class MemberState(val loading: Boolean = false, val members: List<User>? = null,
                       val error: String? = null) {

    fun isSuccess(): Boolean {
        return error == null || error.isEmpty()
    }
}