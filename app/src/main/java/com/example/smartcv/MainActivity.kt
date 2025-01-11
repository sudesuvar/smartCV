package com.example.smartcv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartcv.AuthScreens.ForgotPasswordScreen
import com.example.smartcv.AuthScreens.LoginScreen
import com.example.smartcv.AuthScreens.SignupScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.loginScreen, builder ={
                composable(Routes.loginScreen,){
                    LoginScreen(navController)
                }
                composable(Routes.signupScreen,){
                    SignupScreen(navController)
                }
                composable(Routes.forgotPasswordScreen,){
                    ForgotPasswordScreen(navController)
                }
                composable(Routes.mainScreen,){
                  MainScreen()
                }
            })
        }
    }
}

