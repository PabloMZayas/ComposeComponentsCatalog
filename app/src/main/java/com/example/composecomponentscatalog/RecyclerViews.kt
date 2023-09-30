package com.example.composecomponentscatalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecomponentscatalog.models.Superhero
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MySuperheroViewStickyHeader() {
    val context = LocalContext.current
    val mySuperHeroList = getMySuperheroes().groupBy { it.publisher }

    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

        mySuperHeroList.forEach { publisher, superheroList ->
            stickyHeader {
                Text(text = publisher, modifier = Modifier.fillMaxWidth().background(Color.Green), fontSize = 16.sp)
            }

            items(superheroList) { superhero ->
                ItemHero(superhero) {
                    Toast.makeText(context, "${it.superheroName}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun MySuperheroWithScrollView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()

    Column() {
        LazyRow(state = rvState, horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.weight(1f)) {
            items(getMySuperheroes()) { superhero ->
                ItemHero(superhero) {
                    Toast.makeText(context, "${it.superheroName}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if (showButton) {
            Button(onClick = {
                             coroutinesScope.launch {
                                 rvState.animateScrollToItem(0)
                             }
            }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)) {
                Text(text = "Button")
            }
        }
    }
}

@Composable
fun MySimpleRecyclerView() {
    val myItemsList = listOf("Alex", "Juan", "Isa", "Pepe", "Aura", "Ana")
    LazyColumn {
        item { Text(text = "header") }
        items(myItemsList) {
            Text(text = "El item es $it")
        }
        item { Text(text = "footer") }
    }
}

@Composable
fun MySuperheroViewGrid() {
    val context = LocalContext.current
    //LazyVerticalGrid(columns = GridCells.Adaptive(100.dp), content = {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getMySuperheroes()) { superhero ->
            ItemHero(superhero) {
                Toast.makeText(context, "${it.superheroName}", Toast.LENGTH_SHORT).show()
            }
        }
    }, contentPadding = PaddingValues(horizontal = 4.dp, vertical = 10.dp))
}

@Composable
fun MySuperheroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getMySuperheroes()) { superhero ->
            ItemHero(superhero) {
                Toast.makeText(context, "${it.superheroName}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(border = BorderStroke(2.dp, color = Color.Gray),
            modifier = Modifier
                    .width(200.dp)
                    .clickable { onItemSelected(superhero) }
                    .padding(vertical = 4.dp, horizontal = 4.dp)) {
        Column() {
            Image(painter = painterResource(id = superhero.photo),
                    contentDescription = "hero avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
            )
            Text(text = superhero.superheroName, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = superhero.realName,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp)
            Text(text = superhero.publisher,
                    modifier = Modifier
                            .align(Alignment.End)
                            .padding(8.dp),
                    fontSize = 10.sp)
        }
    }
}

fun getMySuperheroes(): List<Superhero> {
    return listOf(
            Superhero(superheroName = "Batman", realName = "John", publisher = "DC", R.drawable.batman),
            Superhero(superheroName = "Daredevil", realName = "Pable", publisher = "Marvel", R.drawable.daredevil),
            Superhero(superheroName = "Flash", realName = "Looky", publisher = "DC", R.drawable.flash),
            Superhero(superheroName = "Green Lantern", realName = "Gary", publisher = "Marvel", R.drawable.green_lantern),
            Superhero(superheroName = "Wolverine", realName = "Logan", publisher = "Marvel", R.drawable.logan),
            Superhero(superheroName = "Spiderman", realName = "Peter Parker", publisher = "DC", R.drawable.spiderman),
            Superhero(superheroName = "Thor", realName = "Pedro", publisher = "DC", R.drawable.thor),
            Superhero(superheroName = "Wonder Woman", realName = "Athena", publisher = "Marvel", R.drawable.wonder_woman),
    )
}