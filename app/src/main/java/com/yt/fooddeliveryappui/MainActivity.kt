package com.yt.fooddeliveryappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.navigator.Navigator
import com.yt.fooddeliveryappui.screens.StartScreen
import com.yt.fooddeliveryappui.screens.activities.FavoritesViewModel
import com.yt.fooddeliveryappui.ui.theme.AnkavirAppUiTheme


class MainActivity : ComponentActivity() {
    private val favoritesViewModel: FavoritesViewModel by viewModels {
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnkavirAppUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colors.background
                ) {
                    Navigator(screen = StartScreen)
                }
            }
        }
    }
}
