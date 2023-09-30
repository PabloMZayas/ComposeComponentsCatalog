package com.example.composecomponentscatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun MyScreen1(navController: NavHostController) {
    Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)) {
        Text(text = "pantalla 1",
                modifier = Modifier.align(Alignment.Center).clickable {
                    navController.navigate(Routes.Pantalla2.route)
                }
        )
    }
}

@Composable
fun MyScreen2(navController: NavHostController) {
    Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)) {
        Text(text = "pantalla 2",
                modifier = Modifier.align(Alignment.Center).clickable {
                    navController.navigate(Routes.Pantalla3.route)
                })
    }
}

@Composable
fun MyScreen3(navController: NavHostController) {
    Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)) {
        Text(text = "pantalla 3", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate("pantalla4/320")
        })
    }
}

@Composable
fun MyScreen4(navController: NavHostController, name: Int) {
    Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Text(text = name.toString(), modifier = Modifier.align(Alignment.Center).
        clickable { navController.navigate(Routes.Pantalla5.createRoute("Paps")) })
    }
}

@Composable
fun MyScreen5(navController: NavHostController, name: String?) {
    Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Text(text = "me llamo $name", modifier = Modifier.align(Alignment.Center))
    }
}