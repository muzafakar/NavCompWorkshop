package com.muzafakar.navcomponentworkshop.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muzafakar.navcomponentworkshop.R
import com.muzafakar.navcomponentworkshop.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class AdpProduct(private val function: (Product, ImageView) -> Unit) :
        RecyclerView.Adapter<AdpProduct.ViewHolder>() {
    private val productList = mutableListOf<Product>()

    fun setData(productList: List<Product>) {
        this.productList.clear()
        this.productList.addAll(productList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
            )

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(productList[position], function)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(product: Product, function: (Product, ImageView) -> Unit) {
            with(itemView) {
                setOnClickListener { function(product, imgProduct) }
                tvProductName.text = product.name
                tvProductPrice.text = "Rp. ${product.price}"
                Glide.with(this).load(product.imgUrl).centerCrop().into(imgProduct)
            }
        }
    }
}