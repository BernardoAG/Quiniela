package com.example.bernardoaltamirano.quiniela.data

import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User

/**
 * Clase modelo de respuesta de servidor
 */
class UserServerResponse(val success: Boolean = false, val result: User? = null, val message: String = "") {
}