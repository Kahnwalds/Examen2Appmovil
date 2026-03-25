package mx.itson.examen02

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import mx.itson.examen02.adapters.PurchaseAdapter
import mx.itson.examen02.entities.Purchase

class PurchaseListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_list)

        // 1. Obtener la lista de la base de datos
        val purchases = Purchase().getAll(this)

        // 2. Buscar el ListView en el layout
        val listView = findViewById<ListView>(R.id.list_purchases)

        // 3. Crear el adaptador y asignarlo
        val adapter = PurchaseAdapter(this, purchases)
        listView.adapter = adapter
    }
}