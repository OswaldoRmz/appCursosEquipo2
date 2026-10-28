package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName

data class dataDetalleCursos(
    @SerialName("id_cursos") val id: Int = 0,
    @SerialName("id_carrera") val carreraId: Int? = null,
    @SerialName("nombre") val nombre: String = "",
    @SerialName("descripcion") val descripcion: String = "Sin descripción",
    @SerialName("espacio") val espacio: String = "Por asignar",
    @SerialName("horas") val totalHoras: Int = 0,
    @SerialName("dias") val diasAtencion: String = "",
    @SerialName("cupo") val cupoTotal: Int = 0,
    @SerialName("imagen_url") val urlImagenDetalle: String = ""
)
