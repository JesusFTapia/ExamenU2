package mx.edu.itson.potros.examenu2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Regalos : AppCompatActivity() {
    var adapter: DetalleAdapter? = null
    var detalles=ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)
        val bundle = intent.extras
        val tvTitulo: TextView =findViewById(R.id.tvTitulo)
        if (bundle != null) {
            var tipo = bundle.getString("tipo")
            if (tipo=="detalles"){
                cargarDetalles()
                adapter=DetalleAdapter(this,detalles,"Detalles")
                var gridDetalles: GridView = findViewById(R.id.detalles_catalogo)
                gridDetalles.adapter=adapter
                tvTitulo.setText("Detalles")

            }else if (tipo=="globos"){
                cargarGlobos()
                adapter=DetalleAdapter(this,detalles,"Globos")
                var gridDetalles: GridView = findViewById(R.id.detalles_catalogo)
                gridDetalles.adapter=adapter
                tvTitulo.setText("Globos")

            }else if (tipo=="peluches"){
                cargarPeluches()
                adapter=DetalleAdapter(this,detalles,"Peluches")
                var gridDetalles: GridView = findViewById(R.id.detalles_catalogo)
                gridDetalles.adapter=adapter
                tvTitulo.setText("Peluches")

            }else if (tipo=="regalos"){
                cargarRegalos()
                adapter=DetalleAdapter(this,detalles,"regalos")
                var gridDetalles: GridView = findViewById(R.id.detalles_catalogo)
                gridDetalles.adapter=adapter
                tvTitulo.setText("Regalos")

            }else if (tipo=="tazas"){
                cargarTazas()
                adapter=DetalleAdapter(this,detalles,"Peluches")
                var gridDetalles: GridView = findViewById(R.id.detalles_catalogo)
                gridDetalles.adapter=adapter
                tvTitulo.setText("Tazas")

            }
        }


    }
    fun cargarDetalles() {
        detalles.add(Detalles(R.drawable.cumplebotanas, "$280"))
        detalles.add(Detalles(R.drawable.cumplecheve, "$320"))
        detalles.add(Detalles(R.drawable.cumpleescolar, "$330"))
        detalles.add(Detalles(R.drawable.cumplepaletas, "$190"))
        detalles.add(Detalles(R.drawable.cumplesnack, "$150"))
        detalles.add(Detalles(R.drawable.cumplevinos, "$370"))
    }
    fun cargarGlobos(){
        detalles.add(Detalles(R.drawable.globoamor, "$240"))
        detalles.add(Detalles(R.drawable.globocumple, "$820"))
        detalles.add(Detalles(R.drawable.globofestejo, "$260"))
        detalles.add(Detalles(R.drawable.globonum, "$760"))
        detalles.add(Detalles(R.drawable.globoregalo, "$450"))
        detalles.add(Detalles(R.drawable.globos, "$240"))
    }

    fun cargarPeluches(){
        detalles.add(Detalles(R.drawable.peluchemario, "$320"))
        detalles.add(Detalles(R.drawable.pelucheminecraft, "$320"))
        detalles.add(Detalles(R.drawable.peluchepeppa, "$290"))
        detalles.add(Detalles(R.drawable.peluches, "$"))
        detalles.add(Detalles(R.drawable.peluchesony, "$330"))
        detalles.add(Detalles(R.drawable.peluchestich, "$280"))
        detalles.add(Detalles(R.drawable.peluchevarios, "$195"))
    }
    fun cargarRegalos() {
        detalles.add(Detalles(R.drawable.regaloazul, "$80"))
        detalles.add(Detalles(R.drawable.regalobebe, "$290"))
        detalles.add(Detalles(R.drawable.regalocajas, "$140"))
        detalles.add(Detalles(R.drawable.regalocolores, "$85"))
        detalles.add(Detalles(R.drawable.regalos, "$"))
        detalles.add(Detalles(R.drawable.regalovarios, "$75"))
    }
    fun cargarTazas(){
        detalles.add(Detalles(R.drawable.tazaabuela, "$120"))
        detalles.add(Detalles(R.drawable.tazalove, "$120"))
        detalles.add(Detalles(R.drawable.tazaquiero, "$260"))
        detalles.add(Detalles(R.drawable.tazas, "$280"))
    }
}
class DetalleAdapter: BaseAdapter {
    var detalles = ArrayList<Detalles>()
    var context: Context? = null
    var tipoDetalle: String

    constructor(context: Context, detalles: ArrayList<Detalles>,tipoDetalle:String) : super() {
        this.detalles = detalles
        this.context = context
        this.tipoDetalle=tipoDetalle
    }

    override fun getCount(): Int {
        return detalles.size
    }

    override fun getItem(p0: Int): Any {
        return detalles[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var detalle = detalles[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.detalle, null)
        var image: ImageView = vista.findViewById(R.id.iv_detalle)
        var price: TextView = vista.findViewById(R.id.tv_detalle)

        image.setImageResource(detalle.image)
        price.setText(detalle.precio)

        image.setOnClickListener() {
            val intent = Intent(context, DetalleRegalos::class.java)
            intent.putExtra("titulo", tipoDetalle)
            intent.putExtra("imagen", detalle.image)
            intent.putExtra("precio", detalle.precio)
            context!!.startActivity(intent)
        }

        return vista
    }
}