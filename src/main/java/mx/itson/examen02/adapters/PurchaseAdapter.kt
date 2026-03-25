package mx.itson.examen02.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.examen02.entities.Purchase
import mx.itson.examen02.R


class PurchaseAdapter(context: Context, purchases: List<Purchase>) : BaseAdapter(){

    var context : Context = context
    var purchaseList :  List<Purchase> = purchases

    override fun getCount(): Int {
        return purchaseList.size
    }

    override fun getItem(position: Int): Any {
        return purchaseList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val element = LayoutInflater.from(context).inflate(R.layout.purchase_item, null)

        try{

            val purchase = getItem(position) as Purchase

            val txtProduct: TextView = element.findViewById(R.id.purchase_product_name)
            txtProduct.text = purchase.product_name
            val txtPrice: TextView = element.findViewById(R.id.purchase_price)
            txtPrice.text = "$${purchase.price}"
            val txtStore: TextView = element.findViewById(R.id.purchase_store_name)
            txtStore.text = purchase.store_name
            val txtDate: TextView = element.findViewById(R.id.purchase_date)
            txtDate.text = purchase.purchase_date



        } catch (ex : Exception){
            Log.e("Error showing purchases", ex.message.toString())
        }
        return element
    }






}