package mx.itson.examen02

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNewPurchase = findViewById<Button>(R.id.btn_new_purchase)
        btnNewPurchase.setOnClickListener(this)

        val btnListPurchase = findViewById<Button>(R.id.btn_list_purchase)
        btnListPurchase.setOnClickListener(this)
    }

    fun vibrate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = applicationContext.getSystemService(VIBRATOR_MANAGER_SERVICE) as VibratorManager
            val vibrator = vibratorManager.defaultVibrator
            vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            val vibrator = applicationContext.getSystemService(VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(100)
        }
    }

    override fun onClick(v: View) {
        vibrate()

        when (v.id) {
            R.id.btn_new_purchase -> {
                val intent = Intent(this, PurchaseFormActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_list_purchase -> {
                val intent = Intent(this, PurchaseListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}