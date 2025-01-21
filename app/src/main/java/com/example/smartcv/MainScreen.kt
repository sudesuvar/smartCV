package com.example.smartcv

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartcv.pages.CvListPage
import com.example.smartcv.pages.HomePage
import com.example.smartcv.pages.ProfilePage
import com.example.smartcv.viewmodel.AuthViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavController){
    //val navController = rememberNavController()
    val navItemLists = listOf(
        NavItem( "CV", Icons.Default.AddCircle),
        NavItem( "Home", Icons.Default.Home),
        NavItem( "Profile", Icons.Default.Person),
    )

    var selectedIndex by remember {
        mutableIntStateOf(1)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemLists.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {  selectedIndex = index },
                        icon = { Icon(imageVector = navItem.icon, contentDescription = "Icon", ) },
                        label = { Text(text = navItem.label)}
                    )
                }
            }
        }
        ) {innerPadding ->
            ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex,navController = navController)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int,navController: NavController) {
    when(selectedIndex){
        0 -> CvListPage()
        1 -> HomePage()
        2 -> ProfilePage(navController, viewModel = AuthViewModel())
    }
}

