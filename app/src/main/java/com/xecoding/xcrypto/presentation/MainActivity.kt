package com.xecoding.xcrypto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xecoding.xcrypto.presentation.coin_info.CoinInfoScreen
import com.xecoding.xcrypto.presentation.coin_list.CoinListScreen
import com.xecoding.xcrypto.presentation.person_info.PersonInfoScreen
import com.xecoding.xcrypto.presentation.ui.theme.XCryptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XCryptoTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route,
                        builder = {
                            composable(
                                route = Screen.CoinListScreen.route
                            ) {
                                CoinListScreen(navController)
                            }
                            composable(
                                route = Screen.CoinInfoScreen.route + "/{coinId}"
                            ) {
                                CoinInfoScreen(navController)
                            }
                            composable(
                                route = Screen.PersonInfoScreen.route + "/{personId}"
                            ) {
                                PersonInfoScreen()
                            }
                        }
                    )
                }
            }
        }
    }
}