package com.example.bernardoaltamirano.quiniela.data

import com.example.bernardoaltamirano.quiniela.model.Quiniela

/**
 * Clase modelo de respuesta de servidor
 */
data class QuinielasServerResponse(val success: Boolean = false, val result: List<Quiniela>? = null, val message: String = "") {
}