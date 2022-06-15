package com.example.myapplication

import Model.User
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityDetailProfilBinding

class DetailProfil : AppCompatActivity() {

    private lateinit var viewBind: ActivityDetailProfilBinding
    private lateinit var user: User
    var indexSekarang = arrayListUser.indexUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityDetailProfilBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        back()
        batal()
        ubahClick()
        viewBind.showPassword.text = arrayListUser.users.get(indexSekarang).password
    }

    private fun ubahClick() {
        var isCompleted=true
        viewBind.simpanDTP.setOnClickListener {
            var lama = viewBind.sandiLama.editText?.text!!.toString().trim()
            var baru = viewBind.sandiBaru.editText?.text!!.toString().trim()

            //lama
            if (lama?.isEmpty() == true) {
                viewBind.sandiLama.error = "Kolom Belum Terisi"
            } else {
                viewBind.sandiLama.error = ""
            }

            //Password
            if (baru?.isEmpty() == true) {
                viewBind.sandiBaru.error="Kolom Password Belum Terisi"
                isCompleted=false
            } else {
                if (baru!!.length < 8) {
                    viewBind.sandiBaru.error="Jumlah password min 8 karakter"
                    isCompleted=false
                } else if (!user.password!!.matches(".*[a-z].*".toRegex())) {
                    viewBind.sandiBaru.error="Password tidak memiliki huruf kecil"
                    isCompleted=false
                } else if (!user.password!!.matches(".*[A-Z].*".toRegex())) {
                    viewBind.sandiBaru.error=
                        "Password tidak memiliki huruf kapital"
                    isCompleted=false
                } else {
                    viewBind.sandiBaru.error=""
                }
            }

            if (isCompleted) {

             
            }

        }
    }


    fun back() {
        viewBind.backDTP.setOnClickListener() {
            finish()
        }
    }

    fun batal() {
        viewBind.batalDTP.setOnClickListener() {
            finish()
        }
    }


}