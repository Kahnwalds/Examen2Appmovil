package mx.itson.examen02.entities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.examen02.persistence.PurchaseDB

class Purchase {

    var id = 0
    var product_name: String = ""
    var price: Double = 0.0
    var store_name: String = ""
    var purchase_date: String = ""

    constructor()

    constructor(id: Int, product_name: String, price: Double, store_name: String, purchase_date: String){
        this.id = id
        this.product_name = product_name
        this.price = price
        this.store_name = store_name
        this.purchase_date = purchase_date
    }

    fun save(context: Context, product_name: String, price: Double, store_name: String, purchase_date: String): Boolean {
        try {
            val purchaseDB = PurchaseDB(context, "PurchaseDB", null, 1)
            val dataBase : SQLiteDatabase = purchaseDB.writableDatabase

            val values = ContentValues()
            values.put("product_name", product_name)
            values.put("price", price)
            values.put("store_name", store_name)
            values.put("purchase_date", purchase_date)

            dataBase.insert("Purchase", null, values)
            return true  // Retorna true si se guardó correctamente



        }catch (ex: Exception) {
            Log.e("Error saving Purchase", ex.message.toString())
            return false  // Retorna false si hubo un error
        }
    }



    fun getAll(context: Context) : List<Purchase>{
        var purchases: MutableList<Purchase> = ArrayList()

        try {
            val purchaseDB = PurchaseDB(context, "PurchaseDB", null, 1)
            val database : SQLiteDatabase = purchaseDB.readableDatabase
            val resultSet = database.rawQuery("SELECT id, product_name, price, store_name, purchase_date FROM Purchase", null)

            while (resultSet.moveToNext()) {
                val purchase = Purchase(resultSet.getInt(0), resultSet.getString(1), resultSet.getDouble(2), resultSet.getString(3), resultSet.getString(4))
                purchases.add(purchase)
            }
        }catch (ex: Exception) {
            Log.e("Error getting Purchase", ex.message.toString())
        }

        return purchases

    }






}