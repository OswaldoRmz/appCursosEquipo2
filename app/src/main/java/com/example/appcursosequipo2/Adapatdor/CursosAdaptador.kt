package com.example.appcursosequipo2.Adapatdor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.appcursosequipo2.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcursosequipo2.Modelo.dataCursos
import com.example.appcursosequipo2.Vista.MainActivity


class CursosAdaptador(
    private val activity: MainActivity,
    private var listaCursos: List<dataCursos>
): RecyclerView.Adapter<CursosAdaptador.CursoViewHolder>(){

    class CursoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNombre: TextView = itemView.findViewById(R.id.txtNombreCursos)
        val tvEspacio: TextView = itemView.findViewById(R.id.txtEspacio)
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCurso)
        val btnInscribirse: Button = itemView.findViewById(R.id.btnInscribirse)
        val btnDetalle: Button = itemView.findViewById(R.id.btnDetalle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cursos, parent, false)
        return CursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = listaCursos[position]
        holder.tvNombre.text = curso.nombre
        holder.tvEspacio.text = curso.espacio ?: "Espacio no disponible"

        //aqui cargamos la imagen del curso
        val baseUrl = "http://192.168.0.103/cursos_api/"
        val imagen = curso.imagenurl?.trim().orEmpty()
        val urlImagenCompleta = when{
            imagen.isEmpty() -> null
            imagen.startsWith("http://") || imagen.startsWith("http://")-> imagen else -> baseUrl + imagen.trimStart('/')
        }

        Glide.with(holder.itemView.context)
            .load(urlImagenCompleta)
            .placeholder(android.R.drawable.ic_menu_gallery)//imagen por defecto mientras carga
            .error(android.R.drawable.stat_notify_error)//imagen si falla la carga
            .into(holder.imgCurso)

        //boton para inscribirse en el curso
        holder.btnInscribirse.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v : View?){
                    //falta codificar el inscribirse para que funcione
                    //activity.inscribirseCurso(curso)
                }
            }
        )

        //boton para ver el detalle del curso
        holder.btnDetalle.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v : View?){
                    //falta configurar el detalle
                    //activity.verDetalle(curso)
                }
            }
        )
    }

    override fun getItemCount(): Int {
        return listaCursos.size
    }

    fun actualizarLista(nuevaLista: List<dataCursos>){
        listaCursos = nuevaLista
        notifyDataSetChanged()
    }
}