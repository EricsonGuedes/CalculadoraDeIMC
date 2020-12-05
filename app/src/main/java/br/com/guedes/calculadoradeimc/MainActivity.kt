package br.com.guedes.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperando o IMC passado por meio da Intent
        var altura = intent.getStringExtra("INTENT_ALTURA")
        var alturaCalcula: Double? = altura?.toDouble()
        var peso = intent.getStringExtra("INTENT_PESO")
        var pesoCalcula: Double? = peso?.toDouble()

        //calculo IMC
        var alturaQuadrado = alturaCalcula?.times(alturaCalcula)
        var x = pesoCalcula?.div(alturaQuadrado!!)
        x?.toBigDecimal()?.setScale(1, RoundingMode.UP)?.toDouble()
        val dec = DecimalFormat("##.00")
        val imc = dec.format(x)
        val imc1 = x.toString()

        var valor =  imc?.toDouble()


        //Exibindo os dados recuperados na tela
        txtMainIMC.text = imc.toString()

        //Condições do IMC
        if (valor!! <= 16.9){
            txtMainTipo.text = "Muito abaixo do peso"
            txtMainDescricao.text = "Queda de cabelo, infertilidade, ausência menstrual"
        } else if (valor >= 17 && valor <= 18.4){
            txtMainTipo.text = "Abaixo do peso"
            txtMainDescricao.text = "Fadiga, stress, ansiedade"
        }else if (valor >= 18.5 && valor <= 24.9){
            txtMainTipo.text = "Peso Normal"
            txtMainDescricao.text = "Menor risco de doenças cardíacas e vasculares"
        } else if (valor >= 25 && valor <= 29.9){
        txtMainTipo.text = "Acima do peso"
        txtMainDescricao.text = "Fadiga, má circulação, varizes "
        }else if (valor >= 30 && valor <= 34.9){
            txtMainTipo.text = "Obesidade Grau 1"
            txtMainDescricao.text = "Diabetes, angina, infarto, aterosclerose "
        }else if (valor >= 35 && valor <= 40){
            txtMainTipo.text = "Obesidade Grau 2"
            txtMainDescricao.text = "Apneia do sono, falta de ar"
        }else if (valor > 40){
            txtMainTipo.text = "Obesidade Grau 3"
            txtMainDescricao.text = "Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC"
        }

        bntMainDicas.setOnClickListener{
            val mIntent = Intent(this, DicasActivity::class.java)
            startActivity(mIntent)
        }

       bntMainVoltar.setOnClickListener {
            val mIntent = Intent(this, CalculadoraActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}