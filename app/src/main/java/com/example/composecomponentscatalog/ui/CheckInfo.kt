package com.example.composecomponentscatalog.ui

data class CheckInfo (val title: String,
                      var selected: Boolean = false,
                      var onCheckedChanged: (Boolean) -> Unit)
