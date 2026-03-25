package mx.itson.examen02.persistence

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class PurchaseDB(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(sqliteDatabase: SQLiteDatabase) {
        try {
            sqliteDatabase.execSQL("CREATE TABLE Purchase (id INTEGER PRIMARY KEY AUTOINCREMENT, name_product TEXT, price REAL, store_name TEXT, purchase_date TEXT)")

        }catch (ex: Exception){
            Log.e("Error al crear la base de datos", ex.message.toString())
        }
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }


}