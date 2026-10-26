package com.example.appcursosequipo2.Presentador

import com.example.appcursosequipo2.Modelo.clsCarrerasModelo
import com.example.appcursosequipo2.Modelo.clsCursosModelo
import com.example.appcursosequipo2.Modelo.dataCarreras
import com.example.appcursosequipo2.Modelo.dataCursos
import com.example.appcursosequipo2.Vista.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsCatalogoPresentador(val vista: MainActivity) {
    private val modeloCarreras = clsCarrerasModelo()
    private val modeloCursos = clsCursosModelo()
    private var listaCarreras: List<dataCarreras> = emptyList()

    fun iniciar() {
        // Se usa un Scope simple para no bloquear la interfaz
        CoroutineScope(Dispatchers.Main).launch {
            try {
                // 1. Cargar la lista de carreras en el Spinner
                listaCarreras = modeloCarreras.obtenerCarreras()
                vista.mostrarCarreras(listaCarreras)

                // 2. Cargar TODOS los cursos por defecto (carrera_id = 0)
                cargarCursos(0)

            } catch (e: Exception) {
                vista.mostrarError("Error: " + e.localizedMessage)
            }
        }
    }

    fun seleccionarCarrera(posicion: Int) {
        if (posicion >= 0 && posicion < listaCarreras.size) {
            val carrera = listaCarreras[posicion]
            // Si es id 0 ("Todas"), enviamos null para que la API traiga todo
            val carreraId = if (carrera.id == 0) null else carrera.id
            cargarCursos(carreraId)
        }
    }

    private fun cargarCursos(carreraId: Int?) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                // Pasar null o el id según corresponda
                val cursos = modeloCursos.obtenerCursosPorCarrera(carreraId ?: 0)
                vista.mostrarCursos(cursos)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar cursos: " + e.localizedMessage)
            }
        }
    }
    // Botón "Ver detalle" de la tarjeta
    /*fun seleccionarCurso(curso: dataCursos) {
        vista.abrirDetalleCurso(curso.id)
    }

    // Botón "Registrarse" de la tarjeta
    fun registrarseCurso(curso: dataCursos) {
        vista.abrirRegistro(curso.id, curso.nombre, curso.urlImagenPrincipal)
    }*/
}