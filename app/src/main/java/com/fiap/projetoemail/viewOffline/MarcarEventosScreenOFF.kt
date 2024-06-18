package com.fiap.projetoemail.viewOffline

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.ui.theme.Poppinsbold
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme
import com.fiap.projetoemail.utilidade.MyCalendarScreen
import com.fiap.projetoemail.utilidade.MyFormCalendar
import com.fiap.projetoemail.utilidade.header
import com.fiap.projetoemail.utilidade.headeroff

@Composable
fun MarcarEventosScreenoff(navControler: NavController) {
    var tela = "AgendaScreenOFF";

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFB3D9FF))
    ) {
        headeroff(tela,navControler)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Marcar Evento",
                fontFamily = Poppinsbold, // Substitua pelo seu Poppinsbold
                fontWeight = FontWeight.W600,
                fontSize = 25.sp,
                color = Color(0xff205982),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        MyCalendarScreen()
        MyFormCalendar()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview12() {
    val navController1 = rememberNavController()
    ProjetoEmailTheme {
        MarcarEventosScreenoff(navController1)
    }
}