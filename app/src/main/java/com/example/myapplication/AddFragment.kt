package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.ActivityDetailProfilBinding
import com.example.myapplication.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var viewBind: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBind=FragmentAddBinding.inflate(layoutInflater, container, false)

        moveAutoManage()

        return viewBind.root
    }

    private fun moveAutoManage() {
        viewBind.automaticAddCardView.setOnClickListener {
            val myIntent= Intent(this@AddFragment.requireContext(), TambahAutoMaticManageActivity::class.java)

            startActivity(myIntent)
        }
    }
}