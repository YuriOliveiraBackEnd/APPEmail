package com.fiap.projetoemail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme
import com.fiap.projetoemail.utilidade.MyApp
import com.fiap.projetoemail.utilidade.MyCalendarScreen
import com.fiap.projetoemail.utilidade.header

@Composable
fun EventosMarcadosScreen(navControler: NavController) {
    var tela = "AgendaScreen";
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFB3D9FF))
    ) {
        header(tela,navControler)
        MyApp()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview7() {
    val navController1 = rememberNavController()
    ProjetoEmailTheme {
        EventosMarcadosScreen(navController1)
    }
}