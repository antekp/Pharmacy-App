package com.yt.fooddeliveryappui.screens.bottomNavigation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.CommonHeader
import com.yt.fooddeliveryappui.commonui.CommonIconButton
import com.yt.fooddeliveryappui.commonui.Text15_600
import com.yt.fooddeliveryappui.commonui.Text17_600
import com.yt.fooddeliveryappui.model.Food
import com.yt.fooddeliveryappui.model.listOfFood
import com.yt.fooddeliveryappui.screens.activities.FavoritesViewModel
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.ui.theme.orange

@Composable
fun WishListTab(navHostController: NavHostController, favoritesViewModel: FavoritesViewModel) {
    val favorites by favoritesViewModel.favorites.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(lightGray)
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                CommonHeader(
                    text = "Ulubione",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    navHostController.navigateUp()
                }
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(favorites) { food ->
                        EachRow(food = food,favoritesViewModel)
                    }

                }
            }


        }
    }

}

@Composable
fun EachRow(
    food: Food,
    favoritesViewModel: FavoritesViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = Modifier.background(Color.White)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(id = food.image), contentDescription = "",
                    modifier = Modifier.size(70.dp),
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                ) {
                    Text17_600(text = food.name, color = Color.Black)
                    Text15_600(
                        text = "${food.price} zł",
                        color = orange,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) // Spacer to push the icon to the right
                CommonIconButton(icon = R.drawable.close_outline,
                    onClick = {favoritesViewModel.removeFavorite(food)},
                    modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }

}