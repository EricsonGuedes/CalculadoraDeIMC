package br.com.guedes.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_videos.*

class VideosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)

        //Habilitando a execução de códigos javascript
        wbvVideo.settings.javaScriptEnabled = true

        //Carregando um Endereço Web
        wbvVideo.loadUrl("https://www.youtube.com/watch?v=Vvgy5yeuhTE&list=PLM3nxG4E7RBOKFcupgaLobYTQuZzi3mQK")

        //Definindo o WebView como cliente web padrão
        wbvVideo.webViewClient = WebViewClient()


    }
}