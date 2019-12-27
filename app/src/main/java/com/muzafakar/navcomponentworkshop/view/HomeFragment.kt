package com.muzafakar.navcomponentworkshop.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import com.muzafakar.navcomponentworkshop.R
import com.muzafakar.navcomponentworkshop.util.DataDummy
import com.muzafakar.navcomponentworkshop.view.adapter.AdpProduct
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private val adpProduct = AdpProduct { product, imageView ->
        val direction = HomeFragmentDirections.actionHomeFragmentToProdukDetailFragment(product)
        val extras = FragmentNavigatorExtras(
                imageView to "imgProductTransitionName"
        )
        findNavController().navigate(direction, extras)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context!!).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(context!!).inflateTransition(android.R.transition.move)
        adpProduct.setData(DataDummy.generateProduct())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvProduct.layoutManager = LinearLayoutManager(context!!)
        rvProduct.adapter = adpProduct
    }


}
