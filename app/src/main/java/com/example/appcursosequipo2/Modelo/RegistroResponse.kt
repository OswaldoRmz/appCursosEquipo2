package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistroResponse(
    @SerialName("ok") val ok: Boolean = false,
    @SerialName("mensaje") val mensaje: String = ""
)
