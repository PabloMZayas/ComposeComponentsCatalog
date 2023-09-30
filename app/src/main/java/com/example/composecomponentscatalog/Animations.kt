package com.example.composecomponentscatalog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun MySimpleColorAnimation() {
    Column() {
        var firstColor by remember { mutableStateOf(false) }

        var secondColor by remember { mutableStateOf(false) }
        var showFirstBox by remember { mutableStateOf(true) }

        var realColor = if (firstColor) Color.Red else Color.Yellow

        if (showFirstBox) {
            Box(Modifier
                    .size(100.dp)
                    .background(realColor)
                    .clickable {
                        firstColor = !firstColor
                    }) {
            }
        }

        Spacer(modifier = Modifier.size(200.dp))

        val realColor2 by animateColorAsState(
                targetValue = if (secondColor) Color.Red else Color.Yellow,
                animationSpec = tween(2000),
                finishedListener = { showFirstBox = !showFirstBox }
        )


        Box(Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable {
                    secondColor = !secondColor
                }) {
        }
    }
}

@Composable
fun MySizeAnimation() {
    var isSmallSize by remember { mutableStateOf(true) }
    val size by animateDpAsState(
            targetValue = if (isSmallSize) 50.dp else 100.dp,
            animationSpec = tween(1500),
            finishedListener = { }
    )

    Box(Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable {
                isSmallSize = !isSmallSize
            }) {
    }
}

@Composable
fun VisibilityAnimation() {

    var isBoxVisible by remember { mutableStateOf(true) }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { isBoxVisible = !isBoxVisible }) {
            Text(text = "Mostrar/Ocultar")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(visible = isBoxVisible,
                enter = slideInHorizontally(),
                exit = slideOutHorizontally()) {
            Box(Modifier
                    .background(Color.Red)
                    .size(200.dp))
        }
    }
}

@Composable
fun MyCrossFadeAnimation() {

    var componentType by remember {
        mutableStateOf(TypeComponent.Text)
    }

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { componentType = getTypeComponent() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(targetState = componentType) { componentType ->
            when (componentType) {
                TypeComponent.Text -> Text(text = "COMPONENTE DE TEXTO")
                TypeComponent.Image -> Image(painter = painterResource(id = R.drawable.logo_shugar), contentDescription = "")
                TypeComponent.Box -> Box(modifier = Modifier
                        .size(100.dp)
                        .background(Color.Magenta))
                TypeComponent.Error -> Text(text = "Errroooooor")
            }
        }
    }
}

fun getTypeComponent(): TypeComponent {
    return when (nextInt(0, 3)) {
        0 -> TypeComponent.Text
        1 -> TypeComponent.Image
        2 -> TypeComponent.Box
        else -> TypeComponent.Error
    }
}

enum class TypeComponent {
    Text, Image, Box, Error
}
