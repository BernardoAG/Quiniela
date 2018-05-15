package com.example.bernardoaltamirano.quiniela.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by icaboalo on 07/02/18.
 */

data class User(@PrimaryKey var id: String? = null, var name: String? = null, var username: String? = null, var points: Int = 0) {

}
