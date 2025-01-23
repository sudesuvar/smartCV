package com.example.smartcv.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcv.R
import com.example.smartcv.Routes
import com.example.smartcv.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(navController: NavController, viewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Üst Profil Alanı
        Row (
            modifier = Modifier.fillMaxWidth()
                .background(colorResource(R.color.Secondary))
                .padding(top = 24.dp, start = 5.dp)
                .height(height = 120.dp),
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.Center

        ){
            Spacer(modifier =  Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "sude",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(start = 4.dp)
                    .border(
                        BorderStroke(4.dp, Color.Black),
                        CircleShape
                    )
                    .padding(2.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier =  Modifier.width(16.dp))

            Column(){
                Text("Sude Deniz Suvar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Developper", fontSize = 16.sp)
            }

        }

        // Kaydırılabilir İçerik
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                //.background(colorResource(R.color.white)),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // İlk Grup
            item {
                ProfileItemRow(
                    navController = navController,
                    items = listOf(
                        ProfileItem("Kişisel Bilgiler", R.drawable.personal, Routes.personalPage),
                        ProfileItem("Eğitim Bilgileri", R.drawable.education, Routes.educationPage)
                    )
                )
            }

            // İkinci Grup
            item {
                ProfileItemRow(
                    navController = navController,
                    items = listOf(
                        ProfileItem("Deneyim", R.drawable.experience, Routes.experiencePage),
                        ProfileItem("Yabancı Diller", R.drawable.language, Routes.languagePage)
                    )
                )
            }

            // Üçüncü Grup
            item {
                ProfileItemRow(
                    navController = navController,
                    items = listOf(
                        ProfileItem("Yetkinlikler", R.drawable.skiils, Routes.experiencePage),
                        ProfileItem("Sosyal Medya", R.drawable.profile, Routes.contactPage)
                    )
                )
            }

            // Diğer Grup
            item {
                ProfileItemRow(
                    navController = navController,
                    items = listOf(
                        ProfileItem("Referanslar", R.drawable.referenca, Routes.referencePage),
                        ProfileItem("Ayarlar", R.drawable.setting, Routes.referencePage)
                    )
                )
            }

            // Çıkış Grubu
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.25f)
                            .clickable {
                                viewModel.signout()
                                navController.navigate(Routes.loginScreen)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.logout),
                            contentDescription = "Logout",
                            modifier = Modifier
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(16.dp)
                                .size(48.dp)
                        )
                        Text(
                            text = "Çıkış",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileItemRow(
    navController: NavController,
    items: List<ProfileItem>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items.forEach { item ->
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(item.icon),
                    contentDescription = item.title,
                    modifier = Modifier
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable { navController.navigate(item.route) }
                )
                Text(
                    text = item.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

data class ProfileItem(val title: String, val icon: Int, val route: String)




