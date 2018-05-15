package com.example.bernardoaltamirano.quiniela.data

import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User

data class UsersServerResponse(val success: Boolean = false, val result: List<User>? = null, val message: String = "") {
}