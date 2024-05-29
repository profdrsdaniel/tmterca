package com.example.recyclerview_menucontexto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        val recycler = view.findViewById<RecyclerView>(R.id.rcListOfProducts)
        val items = productViewModel.getProducts()

        val adapter = ProductAdapter(items, ::goToDetail)
        recycler.adapter = adapter

    }

    private fun goToDetail(product: Product) {
        val productBundle = bundleOf("produto" to product)
        findNavController().navigate(R.id.action_home_to_detalheProductActivity, productBundle)
    }
}