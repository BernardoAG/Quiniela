package com.example.bernardoaltamirano.quiniela.data

import com.example.bernardoaltamirano.quiniela.model.Quiniela
import com.example.bernardoaltamirano.quiniela.model.User

class UserServerResponse(val success: Boolean = false, val result: User? = null, val message: String = "") {
}