package dev.edwinperaza.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.edwinperaza.movieapp.model.Movie
import dev.edwinperaza.movieapp.model.getMovies
import dev.edwinperaza.movieapp.navigation.MovieScreens
import dev.edwinperaza.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp
            ) {
                Text(text = "Movies")
            }
        }
    ) {  paddingValues ->
        MainContent(navController, paddingValues)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    paddingValues: PaddingValues,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    Log.d("Edwin", "MainContent: $movie")
                }
            }
        }
    }
}
