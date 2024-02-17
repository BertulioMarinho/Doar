package com.bobby.doar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bobby.doar.ui.theme.DoarTheme
import androidx.compose.foundation.layout.Arrangement


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoarTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainActivityContent()
                }
            }
        }
    }

    @Composable
    fun MainActivityContent() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val cpf = androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("") }
            val senha = androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("") }

            TextField(
                value = cpf.value,
                onValueChange = { cpf.value = it },
                label = { Text("CPF") }
            )
            TextField(
                value = senha.value,
                onValueChange = { senha.value = it },
                label = { Text("Senha") }
            )
            Button(
                onClick = {
                    SendsenhadByEmail(cpf.value, senha.value)
                }
            ) {
                Text("Entrar")
            }
        }
    }

    private fun SendsenhadByEmail(value: String, value1: String) {

    }

    private fun sendPasswordByEmail(cpf: String, senha: String) {

        println("E-mail de confirmação enviado para $cpf com a senha: $senha")
    }

    @Preview(showBackground = true)
    @Composable
    fun LoginPreview() {
        DoarTheme {
            MainActivityContent()
        }
    }
}
