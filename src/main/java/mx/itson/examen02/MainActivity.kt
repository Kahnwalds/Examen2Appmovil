package mx.itson.examen02

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Agregamos el OnClickListener para manejar los clics como en el ejemplo
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- Configuración de tus botones ---
        // Asegúrate de que estos IDs (btn_new_purchase y btn_list_purchase)
        // existan en tu archivo activity_main.xml
        val btnNewPurchase = findViewById<Button>(R.id.btn_new_purchase)
        btnNewPurchase.setOnClickListener(this)

        val btnListPurchase = findViewById<Button>(R.id.btn_list_purchase)
        btnListPurchase.setOnClickListener(this)
    }

    // Función de vibración (Requisito técnico del examen)
    @RequiresPermission(Manifest.permission.VIBRATE)
    fun vibrate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = getSystemService(VIBRATOR_MANAGER_SERVICE) as VibratorManager
            val vibrator = vibratorManager.defaultVibrator
            vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(100)
        }
    }

    @RequiresPermission(Manifest.permission.VIBRATE)
    override fun onClick(v: View) {
        vibrate() // Vibra al presionar cualquier botón

        when (v.id) {
            R.id.btn_new_purchase -> {
                // Cambiar a la pantalla de formulario
                val intent = Intent(this, PurchaseFormActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_list_purchase -> {
                // Cambiar a la pantalla de lista
                val intent = Intent(this, PurchaseListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}