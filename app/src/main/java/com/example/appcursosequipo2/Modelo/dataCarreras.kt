package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataCarreras(
    @SerialName(value = "id_carrera") val id: Int = 0,
    @SerialName(value = "nombre") val carrera: String = ""


)
