package com.example.appcursosequipo2.Presentador

import com.example.appcursosequipo2.Modelo.clsCarrerasModelo
import com.example.appcursosequipo2.Modelo.clsEstadoModelo
import com.example.appcursosequipo2.Modelo.dataCarreras
import com.example.appcursosequipo2.Vista.estadoInscripcionesActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsEstadoPresentador(private val vista: estadoInscripcionesActivity) {
    private val modeloCarreras = clsCarrerasModelo()
    private val modeloEstado = clsEstadoModelo()
    private var listaCarreras: List<dataCarreras> = emptyList()

    fun iniciar() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val carreras = modeloCarreras.obtenerCarreras()
                if (carreras.isNotEmpty()) {
                    listaCarreras = carreras
                    vista.mostrarCarreras(listaCarreras)
                    // Cargar el estado para la primera carrera por defecto
                    cargarEstado(listaCarreras[0].id)
                } else {
                    vista.mostrarError("No hay carreras registradas")
                }
            } catch (e: Exception) {
                vista.mostrarError("Error de conexión al cargar carreras")
            }
        }
    }

    fun seleccionarCarrera(posicion: Int) {
        if (posicion >= 0 && posicion < listaCarreras.size) {
            val carreraId = listaCarreras[posicion].id
            cargarEstado(carreraId)
        }
    }

    private fun cargarEstado(carreraId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val listaEstado = modeloEstado.obtenerEstadoInscripciones(carreraId)
                vista.mostrarListaEstado(listaEstado)
                vista.actualizarTotal(listaEstado.size)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar las inscripciones")
            }
        }
    }
}