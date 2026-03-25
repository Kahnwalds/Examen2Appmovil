package mx.itson.examen02

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import adapters.PurchaseAdapter
import mx.itson.examen02.entities.Purchase
import androidx.appcompat.app.AppCompatActivity


class PurchaseListActivity : AppCompatActivity(){
    var listPurchases : ListView? = null

    var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_purchase_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listPurchases = findViewById(R.id.list_purchases)
        loadPurchases()

    }

    fun loadPurchases(){

        val purchases = Purchase().getAll(this)
        listPurchases?.adapter = PurchaseAdapter(context, purchases)

    }
}