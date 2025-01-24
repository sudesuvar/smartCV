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
import com.example.smartcv.pages.ContactPage
import com.example.smartcv.pages.EducationPage
import com.example.smartcv.pages.ExperiencePage
import com.example.smartcv.pages.LanguagePage
import com.example.smartcv.pages.PersonalPage
import com.example.smartcv.pages.ReferencePage
import com.example.smartcv.pages.SettingPage
import com.example.smartcv.pages.SkillPage
import com.example.smartcv.viewmodel.AuthViewModel
import com.example.smartcv.viewmodel.InformationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.loginScreen, builder ={
                composable(Routes.loginScreen,){
                    LoginScreen(navController, viewModel = AuthViewModel())
                }
                composable(Routes.signupScreen,){
                    SignupScreen(navController, viewModel = AuthViewModel())
                }
                composable(Routes.forgotPasswordScreen,){
                    ForgotPasswordScreen(navController)
                }
                composable(Routes.mainScreen,){
                    MainScreen(navController = navController)
                }
                composable(Routes.personalPage,){
                    PersonalPage(
                        navController,
                        onDateSelected = { selectedDate ->
                            // For now, just print or log the selected date
                            println("Selected date: $selectedDate")
                        },
                        onDismiss = {
                            // For now, just pop the back stack or dismiss the page
                            navController.navigate(Routes.personalPage)
                        },
                        viewModel = InformationViewModel()
                    )
                }
                composable(Routes.educationPage,) {
                    EducationPage(
                        navController,
                        onDateSelected = { startDate, endDate ->
                        },
                        onDismiss = {
                            navController.navigate(Routes.personalPage)
                        }
                    )
                }
                composable(Routes.experiencePage,) {
                    ExperiencePage(navController)
                }
                composable(Routes.languagePage,) {
                    LanguagePage(navController,  viewModel = InformationViewModel())
                }
                composable(Routes.skillPage,) {
                    SkillPage(navController)
                }
                composable(Routes.contactPage,){
                    ContactPage(navController, viewModel = InformationViewModel())
                }
                composable(Routes.referencePage,){
                    ReferencePage(navController)
                }
                composable(Routes.settingPage,) {
                    SettingPage(navController)
                }
            })
        }
    }
}

