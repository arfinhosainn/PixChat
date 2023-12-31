package com.arfin.pixchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arfin.pixchat.presentation.chat.ChatScreen
import com.arfin.pixchat.presentation.username.UsernameScreen
import com.arfin.pixchat.ui.theme.PixChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixChatTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "username_screen") {
                    composable("username_screen") {
                        UsernameScreen(onNavigate = navController::navigate)
                    }
                    composable("chat_screen/{username}",
                        arguments = listOf(
                            navArgument(name = "username") {
                                type = NavType.StringType
                                nullable = true
                            }
                        )) {
                        val username = it.arguments?.getString("username")
                        ChatScreen(username = username)

                    }
                }

            }
        }
    }
}
