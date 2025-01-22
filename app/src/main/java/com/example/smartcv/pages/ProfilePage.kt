package com.example.smartcv.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
        modifier = Modifier.fillMaxSize(),
    ) {
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
        //Spacer(modifier =  Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ){
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.personal),
                    contentDescription = "Personal Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable { navController.navigate(Routes.personalPage)})

                Text(text = "Kişisel Bilgiler",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.education),
                    contentDescription = "Education Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable {  navController.navigate(Routes.educationPage) })

                Text(text = "Eğitim Bilgileri",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }


        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ){
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.experience),
                    contentDescription = "ExperienceImage",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable {  navController.navigate(Routes.experiencePage) })

                Text(text = "Deneyim",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.language),
                    contentDescription = "Language Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable {  navController.navigate(Routes.languagePage) })

                Text(text = "Yabancı Diller",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ){
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.skiils),
                    contentDescription = "Skiils Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable {  navController.navigate(Routes.experiencePage) })

                Text(text = "Yetkinlikler",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.profile),
                    contentDescription = "Social Media Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable {  navController.navigate(Routes.contactPage) })

                Text(text = "Sosyal Medya",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ){
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.referenca),
                    contentDescription = "Referance Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable {  navController.navigate(Routes.referencePage) })

                Text(text = "Referanslar",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.info),
                    contentDescription = "Info Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable {  })

                Text(text = "Dikkat Edilmesi Gerekenler",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ){
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.setting),
                    contentDescription = "Setting Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable {  navController.navigate(Routes.referencePage) })

                Text(text = "Ayarlar",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(R.drawable.logout),
                    contentDescription = "logout Image",
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                        .size(48.dp)
                        .clickable { viewModel.signout()
                            navController.navigate(Routes.loginScreen) })

                Text(text = "Çıkış",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }

        }



    }


}



