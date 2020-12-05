package br.com.guedes.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculadora.*
import java.math.RoundingMode
import java.text.DecimalFormat

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        //Escutando o clique do botão Calcular
        bntCalculadoraCalcular.setOnClickListener{

            //capturando os dados digitados
           var peso = edtCalculadoraPeso.text.toString()


           var altura = edtCalculadoraAltura.text.toString()

            //validação de dados
            if(peso.isEmpty()){
                edtCalculadoraPeso.error = "Digite seu peso!"
                edtCalculadoraPeso.requestFocus()

            }else if(altura.isEmpty()){
                edtCalculadoraAltura.error = "Digite sua altura!"
                edtCalculadoraAltura.requestFocus()
            }else{
                //Abrir a MainActivity
                val mIntent = Intent(this, MainActivity::class.java)
                mIntent.putExtra("INTENT_PESO",peso)
                mIntent.putExtra("INTENT_ALTURA",altura)
                startActivity(mIntent)

           }
       }
    }
}




