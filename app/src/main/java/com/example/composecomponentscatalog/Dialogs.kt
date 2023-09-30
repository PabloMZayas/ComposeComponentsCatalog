package com.example.composecomponentscatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable 
fun MyDialogWithRadioButtons(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(Modifier
                    .fillMaxWidth()
                    .background(Color.White)) {
                MyTitleDialog(title = "Phone Ringtone")
                Divider(Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray))
                var status by remember { mutableStateOf("") }
                MyRadioButtonList(name = status, onSelectedItem = { status = it })
                Divider(Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray))
                Row(Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = {  }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = {  }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)) {

                MyTitleDialog(title = "Set backup account")
                MyItemAccount(email = "ejemplo1@gmail.com", drawableRef = R.drawable.logo_shugar)
                MyItemAccount(email = "ejemplo2@gmail.com", drawableRef = R.drawable.logo_shugar)
                MyItemAccount(email = "Añadir cuenta", drawableRef = R.drawable.ic_launcher_background)
            }
        }
    }
}

@Composable
fun MyAlertDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {

    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() }, title = { Text(text = "Título") }, text = { Text(text = "Este es un nuevo diálogo que se utilizará como prueba") }, confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text(text = "Confirm")
            }
        }, dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = "Dismiss")
            }
        })
    }
}

@Composable
fun MyItemAccount(email: String, @DrawableRes drawableRef: Int) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = drawableRef),
                contentDescription = "description",
                modifier = Modifier
                        .padding(12.dp)
                        .clip(CircleShape)
                        .size(40.dp),
                contentScale = ContentScale.Crop)
        
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
    }
}

@Composable
fun MyTitleDialog(title: String, modifier: Modifier = Modifier.padding(12.dp)) {
    Text(text = title, fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier)
}
