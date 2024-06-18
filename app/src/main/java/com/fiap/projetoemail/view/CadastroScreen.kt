package com.fiap.projetoemail.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.R
import com.fiap.projetoemail.ui.theme.Poppins
import com.fiap.projetoemail.ui.theme.Poppinsbold
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(navControler: NavController) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value
    var textemail by remember {
        mutableStateOf("")
    }
    var textsenha by remember {
        mutableStateOf("")
    }
    var texttel by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFB3D9FF))
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            modifier = Modifier.width(370.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Cadastra-se",
                fontFamily = Poppinsbold, // Substitua pelo seu Poppinsbold
                fontWeight = FontWeight.W600,
                fontSize = 38.sp,
                color = Color(0xff205982),
            )
        }

        Spacer(modifier = Modifier.height(60.dp))
        OutlinedTextField(
            value = textemail,
            onValueChange = {letra->
            textemail = letra
            },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.width(380.dp),
            placeholder = { Text(text = "Insira seu Email", color = Color(0xff205982), fontFamily = Poppins) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "",
                    tint = Color(0xff205982)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xff205982),
                unfocusedBorderColor = Color(0xff205982)
            ),
            textStyle = TextStyle(color = Color.Black)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = texttel,
            onValueChange = {letra ->
             texttel = letra
            },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.width(380.dp),
            placeholder = { Text(text = "Insira seu Telefone", color = Color(0xff205982), fontFamily = Poppins) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "",
                    tint = Color(0xff205982)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xff205982),
                unfocusedBorderColor = Color(0xff205982)
            ),
            textStyle = TextStyle(color = Color.Black)
        )
        Spacer(modifier = Modifier.height(20.dp))
        val painter: Painter = painterResource(id = R.drawable.redeyes)
        OutlinedTextField(
            value = textsenha,
            onValueChange = {letra ->
             textsenha = letra
            },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.width(380.dp),
            placeholder = { Text(text = "Insira sua Senha", color = Color(0xff205982), fontFamily = Poppins) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "",
                    tint = Color(0xff205982)
                )
            },
            trailingIcon = {
                Icon(
                    painter = painter,
                    contentDescription = "Ver senha",
                    tint = Color(0xff205982)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xff205982),
                unfocusedBorderColor = Color(0xff205982)
            ),
            textStyle = TextStyle(color = Color.Black)
        )
        Spacer(modifier = Modifier.height(70.dp))
        Button(onClick = { navControler.navigate("LoginScreen") },
            modifier = Modifier
                .width(380.dp)
                .height(60.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff205982))) {
            Text(text = "Cadastrar",
                fontSize = 17.sp,
                fontFamily = Poppinsbold,
                color = Color.White)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "ou continue com",
            fontFamily = Poppins,
            fontSize = 14.sp,
            color = Color(0xff205982),
        )
        Spacer(modifier = Modifier.height(30.dp))
        val context = LocalContext.current
        Button(onClick = {   navControler.navigate("EmailScreen")   },
            modifier = Modifier
                .width(380.dp)
                .height(60.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Row {
                // Ícone
                Icon(
                    painter = painterResource(R.drawable.google),
                    contentDescription = "Descrição do ícone",
                    tint = Color.Unspecified
                )

                // Espaçamento entre o ícone e o texto
                Spacer(modifier = Modifier.width(8.dp))

                // Texto
                Text(
                    text = "Google",
                    fontSize = 17.sp,
                    fontFamily = Poppinsbold,
                    color = Color.Black
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Já tem uma conta ?",
                fontFamily = Poppins,
                fontSize = 14.sp,
                color = Color(0xff205982),
            )
            Spacer(modifier = Modifier.width(10.dp))
            ClickableText(
                text = AnnotatedString(
                    text = "Faça o login",
                    spanStyle = SpanStyle(
                        color = if (isPressed) Color.Red else Color(0xff205982),
                        fontSize = 14.sp,
                        fontFamily = Poppinsbold, // Substitua pelo seu Poppinsbold
                        textDecoration = TextDecoration.Underline // Adiciona sublinhado para enfatizar o link
                    )
                ),
                modifier = Modifier
                    .clickable(interactionSource = interactionSource, indication = null) {
                        println("Link clicado!")
                        // Navegue para a tela de recuperação de senha, por exemplo
                    },
                onClick = {
                    navControler.navigate("LoginScreen")   }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    val navController1 = rememberNavController()
    ProjetoEmailTheme {
        CadastroScreen(navController1)
    }
}
