package br.com.guedes.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dicas.*

class DicasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dicas)

        bntDicasPlayList.setOnClickListener{
            val mIntent = Intent(this, VideosActivity::class.java)
            startActivity(mIntent)
        }


    }

}