package com.example.appcursosequipo2.Modelo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataAlumno(
    @SerialName("matricula") val matricula: Int = 0,
    @SerialName("nombre") val nombre: String = "",
    @SerialName("correo") val correo: String? = ""
)
