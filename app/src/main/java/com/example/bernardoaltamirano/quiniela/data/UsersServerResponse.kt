package com.example.bernardoaltamirano.quiniela.data

import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User

/**
 * Clase modelo de respuesta de servidor
 */
data class UsersServerResponse(val success: Boolean = false, val result: List<User>? = null, val message: String = "") {
}