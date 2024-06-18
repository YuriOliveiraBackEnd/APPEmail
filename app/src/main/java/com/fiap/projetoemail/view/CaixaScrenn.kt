package com.fiap.projetoemail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.R
import com.fiap.projetoemail.ui.theme.Poppins
import com.fiap.projetoemail.ui.theme.Poppinsbold
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme
import com.fiap.projetoemail.utilidade.IconButtonWithBottomBorder
import com.fiap.projetoemail.utilidade.header


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaScreen(navControler: NavController) {

     var tela = "CaixaScreen";

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFB3D9FF))
    ) {
       header(tela,navControler)
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier.width(370.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Filtros:",
                fontFamily = Poppinsbold, // Substitua pelo seu Poppinsbold
                fontWeight = FontWeight.W600,
                fontSize = 30.sp,
                color = Color(0xff205982),
            )
         }
        Spacer(modifier = Modifier.height(30.dp))
        Spacer(modifier = Modifier.width(50.dp))
        Row(modifier = Modifier.fillMaxWidth()){
            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                painter = painterResource(R.drawable.favorite),
                contentDescription = "favorito",
                tint = Color(0xffFBBC05),
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Favoritos",
                    fontSize = 20.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.W400,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            Spacer(modifier = Modifier.width(170.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.height(50.dp)) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "15 e-mails",
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    color = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth()){

            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                painter = painterResource(R.drawable.history),
                contentDescription = "Ler mais tarde",
                tint = Color(0xffD27C2C),
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Ler mais tarde",
                fontSize = 20.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.W400,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(112.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.height(50.dp)) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "20 e-mails",
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    color = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth()){

            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                painter = painterResource(R.drawable.send),
                contentDescription = "Enviado",
                tint = Color(0xff4285F4),
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Enviados",
                fontSize = 20.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.W400,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(170.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.height(50.dp)) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "15 e-mails",
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    color = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth()){

            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                painter = painterResource(R.drawable.danger),
                contentDescription = "Spam",
                tint = Color.Unspecified,
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Spam",
                fontSize = 20.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.W400,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(202.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.height(50.dp)) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "18 e-mails",
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    color = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth()){

            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                painter = painterResource(R.drawable.trash),
                contentDescription = "favorito",
                tint = Color(0xffB20A0A),
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Lixeira",
                fontSize = 20.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.W400,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(199.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.height(50.dp)) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "19 e-mails",
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    color = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth()){

            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                painter = painterResource(R.drawable.heart),
                contentDescription = "favorito",
                tint = Color.Unspecified,
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Curtidas",
                fontSize = 20.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.W400,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(175.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.height(50.dp)) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "12 e-mails",
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    color = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth()){

            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                painter = painterResource(R.drawable.letter),
                contentDescription = "favorito",
                tint = Color.Unspecified,
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Rascunho",
                fontSize = 20.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.W400,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(158.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.height(50.dp)) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "20 e-mails",
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    color = Color.Black,
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { navControler.navigate("EnviarEmailScreen") },
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
                .shadow(4.dp, shape = RoundedCornerShape(100.dp)), // Adiciona sombra ao botão
            shape = RoundedCornerShape(30.dp), // Metade da altura do botão
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff205982) // Cor do botão
            )
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
    Spacer(modifier = Modifier.height(158.dp))

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    val navController1 = rememberNavController()
    ProjetoEmailTheme {
        CaixaScreen(navController1)
    }
}