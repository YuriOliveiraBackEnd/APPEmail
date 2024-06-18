package com.fiap.projetoemail.viewOffline

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.R
import com.fiap.projetoemail.ui.theme.Poppinsbold
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme
import com.fiap.projetoemail.utilidade.MyApp
import com.fiap.projetoemail.utilidade.MyCalendarScreen
import com.fiap.projetoemail.utilidade.StyledButton
import com.fiap.projetoemail.utilidade.header
import com.fiap.projetoemail.utilidade.headeroff


@Composable
fun AgendaScreenoff(navControler: NavController) {
    var tela = "AgendaScreenOFF";
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFB3D9FF))
    ) {
        headeroff(tela,navControler)
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.logoemail),
            contentDescription = "logo",
            modifier = Modifier
                .size(width = 200.dp, height = 240.dp)
                .padding(bottom = 16.dp),
            alignment = Alignment.Center
        )
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botão "Marcar Evento"
            StyledButton(
                text = "Marcar Evento",
                onClick = { navControler.navigate("MarcarEventosScreenOFF") },
                backgroundColor = Color(0xff205982),
                startColor = Color(0xff007991),
                endColor = Color(0xff205982),
                textColor = Color.Black,
                borderColor = Color(0xff205982)
            )

            // Botão "Eventos Marcados"
            StyledButton(
                text = "Eventos Marcados",
                onClick = { navControler.navigate("EventosMarcadosScreenOFF") },
                backgroundColor = Color.Transparent,
                startColor = Color(0xff3FA9C1),
                endColor = Color(0xff26557F),
                textColor = Color.Black,
                borderColor = Color(0xff3FA9C1)
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview14() {
    val navController1 = rememberNavController()
    ProjetoEmailTheme {
        AgendaScreenoff(navController1)
    }
}