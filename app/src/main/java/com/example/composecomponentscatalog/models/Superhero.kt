package com.example.composecomponentscatalog.models

import androidx.annotation.DrawableRes

data class Superhero(
        var superheroName: String,
        var realName: String,
        var publisher: String,
        @DrawableRes var photo: Int)
