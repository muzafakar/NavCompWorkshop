package com.muzafakar.navcomponentworkshop.view


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.muzafakar.navcomponentworkshop.R
import kotlinx.android.synthetic.main.fragment_produk_detail.*

/**
 * A simple [Fragment] subclass.
 */
class ProductDetailFragment : Fragment() {
    private val navArgs by navArgs<ProductDetailFragmentArgs>()

    // use the product object to bind the view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context!!).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(context!!).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_produk_detail, container, false)

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(navArgs.product.imgUrl).centerCrop().into(imgProduct)
        tvProductName.text = navArgs.product.name
        tvProductPrice.text = "Rp. ${navArgs.product.price}"
    }

}


