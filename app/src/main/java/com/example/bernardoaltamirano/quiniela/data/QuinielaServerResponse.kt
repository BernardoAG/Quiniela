package com.example.bernardoaltamirano.quiniela.data

import com.example.bernardoaltamirano.quiniela.model.Quiniela

data class QuinielaServerResponse(val success: Boolean = false, val result: Quiniela? = null, val message: String = "") {
}