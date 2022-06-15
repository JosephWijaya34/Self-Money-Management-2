package com.example.myapplication

import ModelUang.Pengeluaran
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityViewBinding
import kotlin.properties.Delegates

class ViewActivity : AppCompatActivity() {

    private lateinit var viewBind: ActivityViewBinding
    private lateinit var fromActivity: String
    private var indexUangList by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind=ActivityViewBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        //terima data
        fromActivity = intent.getStringExtra("from") ?: ""
        indexUangList = intent.getIntExtra("position", 0)

        //function
        showData()
        editData()
        delete()
    }

    private fun showData() {
        var indexUser=arrayListUser.indexUser
        var data=arrayListUser.users.get(indexUser).uanglist.get(indexUangList)
        if (data is Pengeluaran) {

        } else {

        }
    }

    private fun editData(){
        viewBind.editRVButton.setOnClickListener{
            if (fromActivity.equals("Pengeluaran")){
                val myIntent = Intent(this, TambahPengeluaranActivity::class.java).apply {
                    putExtra("position", indexUangList)
                }
                startActivity(myIntent)

            }else{
                val myIntent = Intent(this, TambahPemasukanActivity::class.java).apply {
                    putExtra("position", indexUangList)
                }
                startActivity(myIntent)

            }
        }
    }

    private fun delete() {
        viewBind.deleteButton.setOnClickListener {
            var indexUser=arrayListUser.indexUser
            finish()
            arrayListUser.users.get(indexUser).uanglist.removeAt(indexUangList)
        }
    }

}