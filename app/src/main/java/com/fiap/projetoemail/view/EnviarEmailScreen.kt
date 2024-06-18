package com.fiap.projetoemail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.R
import com.fiap.projetoemail.ui.theme.Poppinsbold
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme
import com.fiap.projetoemail.utilidade.MyForm
import com.fiap.projetoemail.utilidade.MyTextArea
import com.fiap.projetoemail.utilidade.StyledButton
import com.fiap.projetoemail.utilidade.header

@Composable
fun EnviarEmailScreen(navControler: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFB3D9FF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.White),

            )
        {
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth()) {

                // Espaçamento entre o ícone e o texto
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                ) {

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Escrever Email",
                        fontSize = 20.sp,
                        fontFamily = Poppinsbold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }


            }

        }
       MyForm(navControler)


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview8() {
    val navController1 = rememberNavController()
    ProjetoEmailTheme {
        EnviarEmailScreen(navController1)
    }
}