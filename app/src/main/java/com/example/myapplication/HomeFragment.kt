package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewBind: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBind=FragmentHomeBinding.inflate(layoutInflater, container, false)

        tryMove()

        return viewBind.root
    }

    private fun tryMove() {
        viewBind.pemasukanHomeCardView.setOnClickListener {
            val myIntent=Intent(this@HomeFragment.requireContext(), homeActivity::class.java)

            startActivity(myIntent)
        }
    }
}