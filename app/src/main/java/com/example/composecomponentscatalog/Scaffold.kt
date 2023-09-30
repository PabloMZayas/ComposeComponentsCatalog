package com.example.composecomponentscatalog

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold() {
    val scaffoldState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar() {
            coroutineScope.launch {
                scaffoldState.showSnackbar(it)
            }
        }
    }, snackbarHost = { scaffoldState },
            bottomBar = { MyBottomNavigation() },
            floatingActionButton = { MyFAB() },
            floatingActionButtonPosition = FabPosition.Center) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(title = { Text(text = "Mi primera TopAppBar") },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.Green, titleContentColor = Color.White
            ), navigationIcon = {
        IconButton(onClick = {  }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
        }
    }, actions = {
        IconButton(onClick = { onClickIcon("star") }) {
            Icon(imageVector = Icons.Filled.Star, contentDescription = "star")
        }
        IconButton(onClick = { onClickIcon("add") }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
        }
    })
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }
    BottomAppBar() {
        NavigationBarItem(selected = index == 1, onClick = { index = 1 },
                icon = {
                    Icon(imageVector = Icons.Default.AccountBox,
                            contentDescription = "account")
                },
                label = { Text(text = "account") })

        NavigationBarItem(selected = index == 2, onClick = { index = 2 },
                icon = {
                    Icon(imageVector = Icons.Default.Close,
                            contentDescription = "close")
                },
                label = { Text(text = "close") })

        NavigationBarItem(selected = index == 3, onClick = { index = 3 },
                icon = {
                    Icon(imageVector = Icons.Default.Star,
                            contentDescription = "star")
                },
                label = { Text(text = "star") })
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(onClick = { }, containerColor = Color.Green) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "add")
    }
}

@Composable
fun MyDrawer() {
    Column(Modifier.padding(8.dp)) {
        Text(text = "Primera opción", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Segunda opción", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Tercera opción", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
        Text(text = "Cuarta opción", modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
    }
}
