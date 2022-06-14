package com.example.myapplication

import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewBind: FragmentHomeBinding
    @RequiresApi(Build.VERSION_CODES.N)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBind=FragmentHomeBinding.inflate(layoutInflater, container, false)

        welcome()

        tryMove()

        return viewBind.root
    }
    //    kondisi pagi siang malam
    @RequiresApi(Build.VERSION_CODES.N)
    private fun welcome() {
        var indexUserHome = arrayListUser.indexUser
        var user = arrayListUser.users.get(indexUserHome).nama
        val currentHour = Calendar.getInstance().get(Calendar.HOUR)
        viewBind.homeWelcomeUserTextView.text = if (currentHour > 20 && currentHour < 4) {("Malam " + user)}
        else if (currentHour > 12 && currentHour < 15) {("Siang " + user)}
        else {("Pagi " + user)}
    }

    private fun tryMove() {
        viewBind.pemasukanHomeCardView.setOnClickListener {
            val myIntent=Intent(this@HomeFragment.requireContext(), homeActivity::class.java)

            startActivity(myIntent)
        }
    }
}