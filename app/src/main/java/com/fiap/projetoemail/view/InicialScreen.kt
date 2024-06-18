package com.fiap.projetoemail.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.R
import com.fiap.projetoemail.ui.theme.Poppins
import com.fiap.projetoemail.ui.theme.Poppinsbold
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme

@Composable
fun InicialScreen(navControler: NavController) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFB3D9FF))
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.logoemail),
            contentDescription = "logo",
            modifier = Modifier
                .size(width = 450.dp, height = 340.dp)
                .padding(bottom = 16.dp),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(55.dp))
            Text(
                text = "Bem vindo a NovaInbox!",
                fontFamily = Poppins,
                fontWeight = FontWeight.W600,
                fontSize = 25.sp,
                color = Color(0xff26557E),
            )
        Spacer(modifier = Modifier.height(15.dp))
         Text(
            text = "Sua nova plataforma de email inteligente e \n segura. Junte-se a nós e transforme sua \n experiência com emails!",
            fontFamily = Poppins,
            fontSize = 14.sp,
            color = Color(0xff26557E),
            textAlign = TextAlign.Center
         )

        Spacer(modifier = Modifier.height(80.dp))
        Row(modifier = Modifier.padding(16.dp),horizontalArrangement = Arrangement.Center) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .zIndex(1f) // Elevar o botão para a frente
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff205982)),
                    modifier = Modifier
                        .width(170.dp)
                        .height(60.dp)
                        .offset(x = (30).dp),

                    onClick = { navControler.navigate("LoginScreen")  }
                ) {
                    Text(
                        text = "Login",
                        fontFamily = Poppinsbold,
                        fontSize = 14.sp,
                        color = Color.White,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .offset(x = (-30).dp) // Deslocar o botão para a esquerda
            ) {
                Button(
                    modifier = Modifier
                        .width(210.dp)
                        .height(60.dp),
                    onClick = { navControler.navigate("CadastroScreen")  },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    border = BorderStroke(2.dp, Color(0xff3FA9C1))
                ) {
                    Text(
                        text = "Sign-up",
                        fontFamily = Poppinsbold,
                        fontSize = 14.sp,
                        color = Color(0xff26557F),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val navController1 = rememberNavController()
    ProjetoEmailTheme {
        InicialScreen(navController1)
    }
}