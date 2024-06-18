package com.fiap.projetoemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.ui.theme.ProjetoEmailTheme
import com.fiap.projetoemail.view.AgendaScreen
import com.fiap.projetoemail.view.CadastroScreen
import com.fiap.projetoemail.view.CaixaScreen
import com.fiap.projetoemail.view.EmailScreen
import com.fiap.projetoemail.view.EnviarEmailScreen
import com.fiap.projetoemail.view.EventosMarcadosScreen
import com.fiap.projetoemail.view.InicialScreen
import com.fiap.projetoemail.view.LoginScreen
import com.fiap.projetoemail.view.MarcarEventosScreen
import com.fiap.projetoemail.viewOffline.AgendaScreenoff
import com.fiap.projetoemail.viewOffline.CaixaScreenoff
import com.fiap.projetoemail.viewOffline.EmailScreenoff
import com.fiap.projetoemail.viewOffline.EventosMarcadosScreenoff
import com.fiap.projetoemail.viewOffline.MarcarEventosScreenoff


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoEmailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "InicialScreen") {
                        composable(route = "LoginScreen") {
                            LoginScreen(navController)
                        }
                        composable(route = "InicialScreen") {
                            InicialScreen(navController)
                        }
                        composable(route = "CadastroScreen") {
                            CadastroScreen(navController)
                        }
                        composable(route = "CaixaScreen") {
                            CaixaScreen(navController)
                        }
                        composable(route = "AgendaScreen") {
                            AgendaScreen(navController)
                        }
                        composable(route = "MarcarEventosScreen") {
                            MarcarEventosScreen(navController)
                        }
                        composable(route = "EventosMarcadosScreen") {
                            EventosMarcadosScreen(navController)
                        }
                        composable(route = "EnviarEmailScreen") {
                            EnviarEmailScreen(navController)
                        }
                        composable(route = "EmailScreen") {
                            EmailScreen(navController)
                        }
                        composable(route = "EmailScreenOFF") {
                            EmailScreenoff(navController)
                        }
                        composable(route = "EventosMarcadosScreenoff") {
                            EventosMarcadosScreenoff(navController)
                        }
                        composable(route = "MarcarEventosScreenoff") {
                            MarcarEventosScreenoff(navController)
                        }
                        composable(route = "AgendaScreenoff") {
                            AgendaScreenoff(navController)
                        }
                        composable(route = "CaixaScreenoff") {
                            CaixaScreenoff(navController)
                        }

                    }
                }
            }
        }
    }
}