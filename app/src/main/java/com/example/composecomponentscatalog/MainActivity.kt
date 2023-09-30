package com.example.composecomponentscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composecomponentscatalog.ui.CheckInfo
import com.example.composecomponentscatalog.ui.theme.ComposeComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentsCatalogTheme {

                MyCrossFadeAnimation()


                /*val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.Pantalla1.route) {
                    composable(Routes.Pantalla1.route) { MyScreen1(navController) }
                    composable(Routes.Pantalla2.route) { MyScreen2(navController) }
                    composable(Routes.Pantalla3.route) { MyScreen3(navController) }
                    composable("pantalla4/{name}",
                            arguments = listOf(navArgument("name") {
                                type = NavType.IntType
                            })) { backStackEntry ->
                        val name = backStackEntry.arguments?.getInt("name") ?: 0
                        MyScreen4(navController, name)
                    }
                    composable(Routes.Pantalla5.route, arguments = listOf(navArgument(
                            "name"
                    ) { defaultValue = "Pepe" })) { backStackEntry ->
                        MyScreen5(navController = navController, name = backStackEntry.arguments?.getString("name"))
                    }
                }*/
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("Lobo") }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf("helado", "chocolate", "café", "futas", "natillas", "chilaquiles")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                        .clickable { expanded = true }
                        .fillMaxWidth())

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }, modifier = Modifier.fillMaxWidth()) {
            desserts.forEach { dessert ->
                DropdownMenuItem(text = { Text(text = dessert) }, onClick = {
                    expanded = false
                    selectedText = dessert
                })
            }
        }
    }

}

@Composable
fun MyDivider() {
    Divider(Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), color = Color.Gray)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(modifier = Modifier.padding(16.dp),
            badge = {
                Badge(content = { Text(text = "4") },
                        contentColor = Color.Cyan, containerColor = Color.DarkGray)
            }) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}

@Composable
fun MyCard() {
    Card(modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
            shape = CardDefaults.elevatedShape,
            colors = CardDefaults.cardColors(contentColor = Color.Blue, containerColor = Color.Green),
            border = CardDefaults.outlinedCardBorder(),
            elevation = CardDefaults.cardElevation(12.dp)) {

        Column(Modifier.padding(12.dp)) {
            Text(text = "loco")
            Text(text = "loco")
            Text(text = "loco")
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onSelectedItem: (String) -> Unit) {
    var status by remember { mutableStateOf("Pablo") }

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier) {
            RadioButton(selected = name == "Pablo", onClick = { onSelectedItem("Pablo") })
            Text(text = "Pablo", modifier = Modifier.padding(top = 10.dp))
        }
        Row(Modifier) {
            RadioButton(selected = name == "Isa", onClick = { onSelectedItem("Isa") })
            Text(text = "Isa", modifier = Modifier.padding(top = 10.dp))
        }
        Row(Modifier) {
            RadioButton(selected = name == "Pepe", onClick = { onSelectedItem("Pepe") })
            Text(text = "Pepe", modifier = Modifier.padding(top = 10.dp))
        }
        Row(Modifier) {
            RadioButton(selected = name == "Alex", onClick = { onSelectedItem("Alex") })
            Text(text = "Alex", modifier = Modifier.padding(top = 10.dp))
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        var radioButtonState by remember { mutableStateOf(false) }
        RadioButton(selected = radioButtonState, onClick = { radioButtonState = !radioButtonState })
        Text(text = "Pablo", modifier = Modifier.padding(top = 10.dp))
    }
}

@Composable
fun GetOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by remember { mutableStateOf(false) }
        CheckInfo(it, status) { status = it }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeComponentsCatalogTheme {
        MyCheckBoxWithText()
        //MyCheckBox()
        //MySwitch()
        //MyProgress()
        //MyScreenShugar()
        //MyIcon()
        //MyImage()
        //MyButton()
        //MyTextField()
        //MyText()
    }
}

@Composable
fun MyCheckBoxTriState() {
    var triState by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = triState, onClick = {
        triState = when (triState) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = checkInfo.selected, onCheckedChange = { checkInfo.onCheckedChanged(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title, modifier = Modifier.padding(vertical = 10.dp))
    }
}

@Composable
fun MyCheckBoxWithText() {
    var checkBoxState by remember { mutableStateOf(false) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = checkBoxState, onCheckedChange = { checkBoxState = !checkBoxState })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.padding(vertical = 10.dp))
    }
}

@Composable
fun MyCheckBox() {
    Column(Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

        var switchState by remember { mutableStateOf(false) }
        Checkbox(checked = switchState,
                onCheckedChange = { switchState = !switchState },
                enabled = true, colors = CheckboxDefaults.colors(
                checkmarkColor = Color.Blue,
                checkedColor = Color.Green,
                uncheckedColor = Color.Red
        ))
    }
}

@Composable
fun MySwitch() {
    Column(Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

        var switchState by remember { mutableStateOf(false) }
        Switch(checked = switchState, onCheckedChange = { switchState = !switchState })
    }
}

@Composable
fun MyProgress() {
    var showLoading by remember { mutableStateOf(false) }
    var progressStatus by remember { mutableStateOf(0f) }

    Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

        if (showLoading) {
            CircularProgressIndicator(strokeWidth = 20.dp, progress = progressStatus)
            LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp), color = Color.Black, trackColor = Color.Red)
        }

        Row(Modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { progressStatus += 0.1f }) {
                Text(text = "Incrementar")
            }

            Button(onClick = { progressStatus -= 0.1f }) {
                Text(text = "Decrementar")
            }
        }

        Button(onClick = { showLoading = !showLoading }, modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Cambiar")
        }
    }
}

@Composable
fun MyIcon() {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = Icons.Rounded.Star,
                contentDescription = "", tint = Color.Cyan, modifier = Modifier.padding(32.dp))
    }
}

@Composable
fun MyImage() {
    Column(Modifier.fillMaxSize()) {
        Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "myImage", alpha = 0.5f,
                modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Yellow)
                        .border(2.dp, Color.Gray, CircleShape))
    }
}

@Composable
fun MyButton() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(Modifier
            .fillMaxSize()
            .padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { enabled = false },
                enabled = enabled,
                colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.Red,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.Yellow
                ),
                border = BorderStroke(5.dp, Color.Yellow)
        ) {
            Text(text = "Button")
        }

        OutlinedButton(onClick = { enabled = false },
                enabled = enabled,
                colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.Red,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.Yellow
                )
        ) {
            Text(text = "Button")
        }

        TextButton(
                onClick = { enabled = false },
                enabled = enabled,
        ) {
            Text(text = "Button")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvanced() {
    Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        var myText by remember { mutableStateOf("") }

        OutlinedTextField(value = myText,
                onValueChange = {
                    myText = if (it.contains("a")) {
                        it.replace("a", "")
                    } else {
                        it
                    }
                },
                label = { Text(text = "Ingresa usuario") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Blue, unfocusedBorderColor = Color.Red
                ))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(myText: String, onValueChanged: (String) -> Unit) {
    Column(Modifier.fillMaxSize()) {
        TextField(value = myText, onValueChange = { onValueChanged(it) })
    }
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text("Ejemplo de Text", fontSize = 28.sp)
        Text("Ejemplo de Text", fontSize = 20.sp, color = Color.Blue)
        Text("Ejemplo de Text", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        Text("Ejemplo de Text", fontSize = 20.sp, fontFamily = FontFamily.Cursive)
        Text("Ejemplo de Text", fontSize = 28.sp, textDecoration = TextDecoration.LineThrough)
        Text("Ejemplo de Text", fontSize = 28.sp, textDecoration = TextDecoration.combine(
                listOf(TextDecoration.Underline, TextDecoration.LineThrough)
        ))
    }
}

@Composable
fun MyScreenShugar() {
    Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(R.color.shugar_background))) {

        Image(painter = painterResource(id = R.drawable.logo_shugar),
                contentDescription = "logo_shugar",
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 125.dp))

        Text(
                text = "Sin dramas\n¡solo diversión!",
                color = Color.White,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                textAlign = TextAlign.Center, fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Button(onClick = { /*TODO*/ },
                Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                        .padding(top = 50.dp), colors = ButtonDefaults.buttonColors(
                contentColor = Color(R.color.shugar_text_button),
                containerColor = Color.White
        )) {
            Text(text = "Registrarse")
        }

        Button(onClick = { /*TODO*/ }, Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 10.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(R.color.shugar_text_button)
        )) {
            Text(text = "Inicia sesión")
        }

        Text(text = "Al registrarte o iniciar sesión, aceptas nuestras Condiciones. Consulta cómo utilizamos tus datos en nuestra Política de privacidad y Política de cookies.",
                color = Color.White,
                modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .padding(top = 20.dp), fontSize = 10.sp, textAlign = TextAlign.Center)
    }
}
