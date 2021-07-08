package com.baiana.imcapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.baiana.imcapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListeners()
    }

    public fun setListeners(){
        binding.alturaEdit.doAfterTextChanged{
            text -> Toast.makeText(this,text.toString(),  Toast.LENGTH_LONG).show()
        }

        binding.calcularBtn.setOnClickListener{
            calcularIMC(binding.pesoEdit.text.toString(), binding.alturaEdit.text.toString())
        }

        binding.limparBTN.setOnClickListener {
            binding.alturaEdit.text.clear()
            binding.pesoEdit.text.clear()
            binding.resultTXT.text = ""
        }
    }

    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso != null && altura != null){
            val imc = peso / (altura * altura)
            binding.resultTXT.text = "Seu IMC é: \n %.2f".format(imc)
        }
    }
   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecycle", "entrei no CREATE - estou criando a tela")
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "entrei no START- deixei a tela visível para você")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "entre no RESUME - agora você pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle", "PAUSE - a tela perdeu o foco, você não pode mais interagir")
    }

    override fun onStop() {
        Log.w("lifecycle", "STOP - a tela não está mais visível mas ainda existe")
        super.onStop()

    }

    override fun onDestroy() {
        Log.w("lifecycle", "\nentrei no DESTROY - oh não a tela foi destruída")
        super.onDestroy()
    }*/
}