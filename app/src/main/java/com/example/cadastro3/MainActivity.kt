// MainActivity.kt


package com.example.cadastro3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastrotela)

        val confirmar = findViewById<Button>(R.id.Confirmar)
        val nome = findViewById<EditText>(R.id.insirirNome)
        val email = findViewById<EditText>(R.id.InsirirEmail)
        val sexoGroup = findViewById<RadioGroup>(R.id.Sexo)
        val escolaridade = findViewById<Spinner>(R.id.insirirEscolaridade)

        confirmar.setOnClickListener {
            val nomeTexto = nome.text.toString()
            val emailTexto = email.text.toString()

            val selectedSexoId = sexoGroup.checkedRadioButtonId
            val sexoSelecionado = if (selectedSexoId != -1) {
                findViewById<RadioButton>(selectedSexoId).text.toString()
            } else {
                "Não selecionado"
            }

            val escolaridadeSelecionada = escolaridade.selectedItem.toString()

            val mensagem = """
                DADOS INFORMADOS:

                Nome: $nomeTexto
                Email: $emailTexto
                Sexo: $sexoSelecionado
                Escolaridade: $escolaridadeSelecionada

                Parabens pelo cadastro.
            """.trimIndent()

            // Mostra a mensagem longa em um AlertDialog
            AlertDialog.Builder(this)
                .setTitle("Confirmação de Cadastro")
                .setMessage(mensagem)
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }
}






