package mx.itson.examen02

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mx.itson.examen02.entities.Purchase
import mx.itson.examen02.R

class PurchaseFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etProductName: EditText
    private lateinit var etPrice: EditText
    private lateinit var etStoreName: EditText
    private lateinit var etPurchaseDate: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_form)

        // Inicializar variables
        etProductName = findViewById(R.id.et_product_name)
        etPrice = findViewById(R.id.et_price)
        etStoreName = findViewById(R.id.et_store_name)
        etPurchaseDate = findViewById(R.id.et_purchase_date)

        val btnSave = findViewById<Button>(R.id.btn_save)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_save) {
            val name = etProductName.text.toString()
            val priceStr = etPrice.text.toString()
            val store = etStoreName.text.toString()
            val date = etPurchaseDate.text.toString()

            if (name.isEmpty() || priceStr.isEmpty() || store.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val price = priceStr.toDouble()
                // Llamamos al metodo save de clase Purchase
                val success = Purchase().save(this, name, price, store, date)

                if (success) {
                    Toast.makeText(this, "Guardado exitosamente", Toast.LENGTH_SHORT).show()
                    finish() // Cerramos la pantalla y regresamos al Main
                } else {
                    Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}