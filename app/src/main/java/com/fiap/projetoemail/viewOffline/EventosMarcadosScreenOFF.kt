package com.fiap.projetoemail.viewOffline

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme
import com.fiap.projetoemail.utilidade.MyApp
import com.fiap.projetoemail.utilidade.header
import com.fiap.projetoemail.utilidade.headeroff

@Composable
fun EventosMarcadosScreenoff(navControler: NavController) {
    var tela = "AgendaScreenOFF";
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFB3D9FF))
    ) {
        headeroff(tela,navControler)
        MyApp()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview11() {
    val navController1 = rememberNavController()
    ProjetoEmailTheme {
        EventosMarcadosScreenoff(navController1)
    }
}