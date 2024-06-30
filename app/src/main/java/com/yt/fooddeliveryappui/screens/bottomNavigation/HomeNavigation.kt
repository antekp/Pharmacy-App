package com.yt.fooddeliveryappui.screens.bottomNavigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yt.fooddeliveryappui.screens.activities.FavoritesViewModel
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.CartTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.CompleteTheOrderTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.DeliveryAvailabilityTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.DiscountTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.HistoryTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.HomeTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.PrivatePolicyTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.ProfileTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.SecurityTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.WishListTab


@Composable
fun HomeNavigation(
    navHostController: NavHostController,
    scaffoldState: ScaffoldState,
    favoritesViewModel: FavoritesViewModel
) {

    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route ){
        composable(BottomBarScreen.Home.route){
            HomeTab(scaffoldState, favoritesViewModel = favoritesViewModel)
        }

        composable(BottomBarScreen.Fav.route){
            WishListTab(navHostController, favoritesViewModel)
        }

        composable(BottomBarScreen.Profile.route){
            ProfileTab(navHostController)
        }

        composable(BottomBarScreen.History.route){
            HistoryTab(navHostController, favoritesViewModel)
        }
        composable(BottomBarScreen.Cart.route)
        {
            CartTab(navHostController, favoritesViewModel)
        }
        composable("Profil")
        {
            ProfileTab(navHostController = navHostController)
        }
        composable("Zamówienia")
        {
            HistoryTab(navHostController,favoritesViewModel)
        }
        composable("Oferty i Promocje")
        {
            DiscountTab(navHostController)
        }
        composable("Polityka prywatności")
        {
            PrivatePolicyTab(navHostController)
        }
        composable("Bezpiecześtwo")
        {
            SecurityTab(navHostController)
        }
        composable("Finalizacja Zamówienia")
        {
            CompleteTheOrderTab(navHostController, favoritesViewModel)
        }

    }

}