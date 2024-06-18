package com.fiap.projetoemail.utilidade

import android.widget.CalendarView
import androidx.compose.ui.viewinterop.AndroidView
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.provider.CalendarContract
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiap.projetoemail.R
import com.fiap.projetoemail.SQLiteHelper
import com.fiap.projetoemail.ui.theme.Poppins
import com.fiap.projetoemail.ui.theme.Poppinsbold
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

@Composable
fun IconButtonWithBottomBorder(
    icon: Painter,
    contentDescription: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .drawBehind {
                if (isSelected) {
                    val strokeWidth = 6f // Largura da borda
                    val y = size.height - strokeWidth / 2
                    val padding = 25f // Ajuste este valor para aumentar o comprimento da borda
                    drawLine(
                        color = Color(0xff205982),
                        start = Offset(-padding, y),
                        end = Offset(size.width + padding, y),
                        strokeWidth = strokeWidth
                    )
                }
            }
    )  {
        IconButton(onClick = onClick) {
            Icon(
                painter = icon,
                contentDescription = contentDescription,
                tint = Color(0xff205982)
            )
        }
    }
}
@Composable
fun header(tela: String,navControler: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(Color.White),

        )
    {
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {

            Spacer(modifier = Modifier.width(20.dp))
            androidx.compose.material3.Icon(
                painter = painterResource(R.drawable.user),
                contentDescription = "Descrição do ícone",
                tint = Color.Unspecified,
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(50.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Ricardo Altori",
                    fontSize = 17.sp,
                    fontFamily = Poppinsbold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(110.dp))
            androidx.compose.material3.Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = "Descrição do ícone",
                tint = Color(0xff205982),
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                painter = painterResource(R.drawable.setting),
                contentDescription = "Descrição do ícone",
                tint = Color(0xff205982),
                modifier = Modifier
                    .size(40.dp)
                    .clickable(onClick = {navControler.navigate("EmailScreenOFF")})
            )

        }
        Spacer(modifier = Modifier.height(15.dp))
        navitens(tela,navControler)


    }
}
@Composable
fun headeroff(tela: String,navControler: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(Color.White),

        )
    {
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {

            Spacer(modifier = Modifier.width(20.dp))
            androidx.compose.material3.Icon(
                painter = painterResource(R.drawable.user),
                contentDescription = "Descrição do ícone",
                tint = Color.Unspecified,
            )
            // Espaçamento entre o ícone e o texto
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(57.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Ricardo Altori",
                    fontSize = 17.sp,
                    fontFamily = Poppinsbold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Offline",
                    fontSize = 10.sp,
                    fontFamily = Poppinsbold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

            }
            Spacer(modifier = Modifier.width(110.dp))
            androidx.compose.material3.Icon(
                painter = painterResource(R.drawable.off),
                contentDescription = "Descrição do ícone",
                tint = Color(0xff205982),
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                painter = painterResource(R.drawable.setting),
                contentDescription = "Descrição do ícone",
                tint = Color(0xff205982),
                modifier = Modifier
                    .size(40.dp)
                    .clickable(onClick = {navControler.navigate("EmailScreen")})
            )

        }
        Spacer(modifier = Modifier.height(15.dp))
        navitensoff(tela,navControler)


    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navitens(tela: String,navControler: NavController)
{
    var selectedIcon by remember { mutableStateOf(tela) }
    TopAppBar(
        modifier = Modifier.background(Color.White),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            scrolledContainerColor = Color.White,
            navigationIconContentColor = Color.Black,
            titleContentColor = Color.Black,
            actionIconContentColor = Color.Black
        ),
        title = {},
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButtonWithBottomBorder(
                    icon = painterResource(R.drawable.emailaberto),
                    contentDescription = "email",
                    isSelected = selectedIcon == "CaixaScreen",
                    onClick = {
                        selectedIcon = tela
                        navControler.navigate("CaixaScreen")
                    }
                )
                IconButtonWithBottomBorder(
                    icon = painterResource(R.drawable.inbox),
                    contentDescription = "Email",
                    isSelected = selectedIcon == "EmailScreen",
                    onClick = {
                        selectedIcon = tela
                        navControler.navigate("EmailScreen")
                    }
                )

                IconButtonWithBottomBorder(
                    icon = painterResource(R.drawable.available),
                    contentDescription = "Agenda",
                    isSelected = selectedIcon == "AgendaScreen",
                    onClick = {
                        selectedIcon = tela
                        navControler.navigate("AgendaScreen")
                    }
                )
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navitensoff(tela: String,navControler: NavController)
{
    var selectedIcon by remember { mutableStateOf(tela) }
    TopAppBar(
        modifier = Modifier.background(Color.White),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            scrolledContainerColor = Color.White,
            navigationIconContentColor = Color.Black,
            titleContentColor = Color.Black,
            actionIconContentColor = Color.Black
        ),
        title = {},
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButtonWithBottomBorder(
                    icon = painterResource(R.drawable.emailaberto),
                    contentDescription = "email",
                    isSelected = selectedIcon == "CaixaScreenOFF",
                    onClick = {
                        selectedIcon = tela
                        navControler.navigate("CaixaScreenOFF")
                    }
                )
                IconButtonWithBottomBorder(
                    icon = painterResource(R.drawable.inbox),
                    contentDescription = "Email",
                    isSelected = selectedIcon == "EmailScreenOFF",
                    onClick = {
                        selectedIcon = tela
                        navControler.navigate("EmailScreenOFF")
                    }
                )

                IconButtonWithBottomBorder(
                    icon = painterResource(R.drawable.available),
                    contentDescription = "Agenda",
                    isSelected = selectedIcon == "AgendaScreenOFF",
                    onClick = {
                        selectedIcon = tela
                        navControler.navigate("AgendaScreenOFF")
                    }
                )
            }
        }
    )
}
@Composable
fun MyApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFB3D9FF)),
            color = MaterialTheme.colorScheme.background,
            border = null
        ) {
            CalendarScreen()
        }
    }
}

@Composable
fun CalendarScreen() {
    val context = LocalContext.current
    var events by remember { mutableStateOf<List<CalendarEvent>>(emptyList()) }
    var hasReadPermission by remember { mutableStateOf(false) }
    var hasWritePermission by remember { mutableStateOf(false) }

    val readPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        hasReadPermission = isGranted
    }

    val writePermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        hasWritePermission = isGranted
    }

    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
            hasReadPermission = true
        } else {
            readPermissionLauncher.launch(Manifest.permission.READ_CALENDAR)
        }

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
            hasWritePermission = true
        } else {
            writePermissionLauncher.launch(Manifest.permission.WRITE_CALENDAR)
        }
    }

    if (hasReadPermission && hasWritePermission) {
        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO) {
                val eventList = readCalendarEvents(context)
                withContext(Dispatchers.Main) {
                    events = eventList
                }
            }
        }
    }
    LazyColumn(modifier = Modifier
        .background(Color(0xFFB3D9FF))
        .fillMaxSize()) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Eventos na Agenda",
                    fontFamily = Poppinsbold, // Substitua pelo seu Poppinsbold
                    fontWeight = FontWeight.W600,
                    fontSize = 17.sp,
                    color = Color(0xff205982),
                    modifier = Modifier.padding(bottom = 16.dp, top = 30.dp)

                )
            }
        }
        items(events) { event ->
            EventItem(event)
        }
    }
}

@Composable
fun EventItem(event: CalendarEvent) {
    Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp)) {
        Text(text = "Evento: ${event.title}", color = Color.Black)
        Text(text = "Começo: ${SimpleDateFormat("dd/MM/yyyy HH:mm").format(Date(event.startDate))}", color = Color.Black)
        Text(text = "Fim: ${SimpleDateFormat("dd/MM/yyyy HH:mm").format(Date(event.endDate))}", color = Color.Black)
    }
}

data class CalendarEvent(val title: String, val startDate: Long, val endDate: Long)

fun readCalendarEvents(context: Context): List<CalendarEvent> {
    val events = mutableListOf<CalendarEvent>()

    val projection = arrayOf(
        CalendarContract.Events.TITLE,
        CalendarContract.Events.DTSTART,
        CalendarContract.Events.DTEND
    )

    val cursor = context.contentResolver.query(
        CalendarContract.Events.CONTENT_URI,
        projection,
        null,
        null,
        null
    )

    cursor?.use {
        val titleIndex = it.getColumnIndexOrThrow(CalendarContract.Events.TITLE)
        val startDateIndex = it.getColumnIndexOrThrow(CalendarContract.Events.DTSTART)
        val endDateIndex = it.getColumnIndexOrThrow(CalendarContract.Events.DTEND)

        while (it.moveToNext()) {
            val title = it.getString(titleIndex)
            val startDate = it.getLong(startDateIndex)
            val endDate = it.getLong(endDateIndex)
            events.add(CalendarEvent(title, startDate, endDate))
        }
    }

    return events
}
@Composable
fun CalendarComponent(
    initialDate: Long? = null, // Data inicial opcional em milissegundos
    onDateSelected: (Long) -> Unit // Callback para lidar com a data selecionada
) {
    AndroidView(factory = { context ->
        CalendarView(context).apply {
            // Configura o listener para quando a data é alterada
            setOnDateChangeListener { _, year, month, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)
                onDateSelected(calendar.timeInMillis)
            }

            // Define a data inicial se fornecida
            initialDate?.let { dateInMillis ->
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = dateInMillis
                // Define a data inicial diretamente nos campos do CalendarView
                setDate(calendar.timeInMillis) // Este método configura a data diretamente
            }
        }
    })
}
@Composable
fun MyCalendarScreen() {
    // Data inicial desejada (por exemplo, 1 de janeiro de 2024)
    val initialDate = Calendar.getInstance().apply {
        set(Calendar.YEAR, 2024)
        set(Calendar.MONTH, Calendar.JANUARY)
        set(Calendar.DAY_OF_MONTH, 1)
    }.timeInMillis

    CalendarComponent(
        initialDate = initialDate,
        onDateSelected = { dateInMillis ->
            // Lógica para lidar com a data selecionada
        }
    )
}
@Composable
fun StyledButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    startColor: Color,
    endColor: Color,
    textColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
            }
            .background(
                Brush.horizontalGradient(
                    colors = listOf(startColor, endColor)
                ),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick),
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, borderColor)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
@Composable
fun StyledButton2(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    startColor: Color,
    endColor: Color,
    textColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
            }
            .background(
                Brush.horizontalGradient(
                    colors = listOf(startColor, endColor)
                ),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick),
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, borderColor)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 14.dp)
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
@Composable
fun MyForm(navControler: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var text1 by remember { mutableStateOf(TextFieldValue("")) }
        var text2 by remember { mutableStateOf(TextFieldValue("")) }
        var text3 by remember { mutableStateOf(TextFieldValue("")) }


            CustomOutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            placeholder = "De:"
        )
        CustomOutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            placeholder = "Para:"
        )
        CustomOutlinedTextField(
            value = text3,
            onValueChange = { text3 = it },
            placeholder = "Assunto:"
        )
        MyTextArea()
        Spacer(modifier = Modifier.height(300.dp))
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botão "Marcar Evento"
            StyledButton2(
                text = "Adicionar Arquivo",
                onClick = {},
                backgroundColor = Color(0xff205982),
                startColor = Color(0xff205982),
                endColor = Color(0xff205982),
                textColor = Color.Black,
                borderColor = Color(0xff205982)
            )
            val context = LocalContext.current
            val dbHelper = SQLiteHelper(context)
            // Botão "Eventos Marcados"
            StyledButton2(
                text = "Enviar email",
                onClick = {
                    val db = dbHelper.writableDatabase
                    val values = ContentValues().apply {
                        put(SQLiteHelper.EmailEntry.COLUMN_FROM, text1.text)
                        put(SQLiteHelper.EmailEntry.COLUMN_TO, text2.text)
                        put(SQLiteHelper.EmailEntry.COLUMN_SUBJECT, text3.text)
                    }
                    val newRowId = db?.insert(SQLiteHelper.EmailEntry.TABLE_NAME, null, values)
                    db.close()
                    navControler.navigate("EmailScreen")
                },
                backgroundColor = Color(0xff205982),
                startColor = Color(0xff205982),
                endColor = Color(0xff205982),
                textColor = Color.Black,
                borderColor = Color(0xff3FA9C1)
            )

        }
    }
}

@Composable
fun CustomOutlinedTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .drawBottomOnlyOutline()
    ) {
        if (value.text.isEmpty()) {
            Text(
                text = placeholder,
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = Poppins,
                modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
            )
        }
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, top = 8.dp) // Ajuste aqui para garantir que o texto não se sobreponha ao placeholder
        )
    }
}

@Composable
fun Modifier.drawBottomOnlyOutline(): Modifier = this.then(
    Modifier.drawBehind {
        val strokeWidth = 1.dp.toPx()
        val y = size.height - strokeWidth / 2
        drawLine(
            color = Color.Gray,
            start = Offset(0f, y),
            end = Offset(size.width, y),
            strokeWidth = strokeWidth
        )
    }
)
@Composable
fun TextBoxArea(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    placeholderColor: Color = Color.Gray,
    placeholderFontSize: Float = 14f,
    textStyle: TextStyle = TextStyle.Default
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        if (value.isEmpty()) {
            Text(
                text = placeholder,
                color = placeholderColor,
                fontSize = placeholderFontSize.sp,
                style = textStyle,
                modifier = Modifier.align(Alignment.TopStart)
            )
        }
    }
}
@Composable
fun MyTextArea() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var text4 by remember { mutableStateOf("") }

        TextBoxArea(
            value = text4,
            onValueChange = { text4 = it },
            placeholder = "Escreva o email",
            placeholderColor = Color.Gray,
            placeholderFontSize = 14f,
            textStyle = TextStyle(fontFamily = Poppins, fontSize = 16.sp)
        )
    }
}
@Composable
fun MyFormCalendar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var text1 by remember { mutableStateOf(TextFieldValue("")) }
        var text2 by remember { mutableStateOf(TextFieldValue("")) }
        var text3 by remember { mutableStateOf(TextFieldValue("")) }

        CustomOutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            placeholder = "Evento:"
        )
        CustomOutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            placeholder = "Começo:"
        )
        CustomOutlinedTextField(
            value = text3,
            onValueChange = { text3 = it },
            placeholder = "Fim:"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botão "Marcar Evento"
            StyledButton2(
                text = "Marcar",
                onClick = {},
                backgroundColor = Color.Transparent,
                startColor = Color(0xff007991),
                endColor = Color(0xff205982),
                textColor = Color.Black,
                borderColor = Color(0xff205982)
            )
        }
    }
}

data class Email(val sender: String, val subject: String, val body: String)
@Composable
fun EmailsScreen(navControler: NavController) {
    val emails = remember {
        listOf(
            Email("João Silva", "Atualização da Reunião", "Olá, só lembrando sobre a reunião de amanhã."),
            Email("Maria Oliveira", "Status do Projeto", "O projeto está dentro do cronograma e será concluído até o prazo."),
            Email("Pedro Souza", "Planos para o Almoço", "Vamos almoçar amanhã no novo restaurante?"),
            Email("Ana Santos", "Convite", "Você está convidado para o evento de gala no próximo mês."),
            Email("Carlos Pereira", "Fatura", "Segue em anexo a fatura dos serviços prestados."),
            Email("Juliana Almeida", "Oportunidade de Emprego", "Temos uma oportunidade de emprego interessante para você."),
            Email("Ryan Silva", "Oportunidade de Emprego", "Temos uma oportunidade de emprego interessante para você."),
            Email("Felipe Romeno", "Oportunidade de Emprego", "Temos uma oportunidade de emprego interessante para você."),
            // Add more emails here as needed
        )

    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().background(Color(0xFFB3D9FF))) {
            LazyColumn(
                modifier = Modifier.weight(1f).background(Color(0xFFB3D9FF)),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(emails) { email ->
                    EmailItem(email)
                }
            }

            Button(
                onClick = { navControler.navigate("EnviarEmailScreen") },
                modifier = Modifier
                    .size(70.dp)
                    .padding(bottom = 20.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(100.dp))
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(30.dp),
                colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor = Color(0xff205982))
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "ADD",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun EmailItem(email: Email) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = "De: ${email.sender}", fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Assunto: ${email.subject}", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = email.body, fontSize = 12.sp, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color(0xff205982), thickness = 1.dp)
    }
}

@Composable
fun Divider(color: Color, thickness: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
            .background(color)
    )
}

