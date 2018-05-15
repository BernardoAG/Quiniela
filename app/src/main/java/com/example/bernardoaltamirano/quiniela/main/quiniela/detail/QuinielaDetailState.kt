package com.example.bernardoaltamirano.quiniela.main.quiniela.detail

data class QuinielaDetailState(val loading: Boolean = false, val id: String? = null,
                               val price: Double? = null, val name: String? = null,
                               val members: Int? = null, val error: String? = null) {

    fun isSuccess(): Boolean {
        return error == null || error.isEmpty()
    }
}