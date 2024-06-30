package com.yt.fooddeliveryappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yt.fooddeliveryappui.screens.activities.FavoritesViewModel
import com.yt.fooddeliveryappui.ui.theme.AnkavirAppUiTheme

abstract class BaseActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnkavirAppUiTheme() {
                    Content()
            }
        }
    }

    @Composable
    abstract fun Content()
}