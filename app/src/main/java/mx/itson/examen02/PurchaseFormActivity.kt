package mx.itson.examen02

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.itson.examen02.entities.Purchase

class PurchaseFormActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_purchase_form)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSave = findViewById<View>(R.id.btn_save) as Button
        btnSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_save -> {
                val productName = findViewById<EditText>(R.id.txt_product_name).text.toString()
                val price = findViewById<EditText>(R.id.txt_price).text.toString()
                val storeName = findViewById<EditText>(R.id.txt_store_name).text.toString()
                val purchaseDate = findViewById<EditText>(R.id.txt_purchase_date).text.toString()

                if (productName.isEmpty() || price.isEmpty() || storeName.isEmpty() || purchaseDate.isEmpty()) {
                    Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
                } else {
                    val price = price.toDouble()
                    if (Purchase().save(this, productName, price, storeName, purchaseDate)) {
                        Toast.makeText(this, "Compra registrada", Toast.LENGTH_LONG).show()
                        finish()
                    } else {
                        Toast.makeText(this, "No se pudo registrar", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}