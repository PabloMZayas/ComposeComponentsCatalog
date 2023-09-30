package com.example.composecomponentscatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

@Composable
fun MySlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MySliderAdvanced() {
    var sliderPosition by remember { mutableStateOf(0f) }
    var sliderEndPosition by remember { mutableStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..10f,
                steps = 9,
                onValueChangeFinished = { sliderEndPosition = sliderPosition })
        Text(text = sliderEndPosition.toString())
    }
}