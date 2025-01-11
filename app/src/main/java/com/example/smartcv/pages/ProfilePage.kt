package com.example.smartcv.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcv.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage() {
    Column(
        modifier = Modifier.fillMaxSize().paint(
            painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillBounds
        ),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
                .background(colorResource(R.color.Primary))
                .padding(top = 24.dp, start = 5.dp)
                .height(height = 120.dp),
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.Center

        ){
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

            Spacer(modifier =  Modifier.width(8.dp))

            Column(){
                Text("Sude Deniz Suvar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Developper", fontSize = 16.sp)
            }

            Spacer(modifier =  Modifier.width(80.dp))

            Column(){
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.Primary),
                        contentColor = colorResource(R.color.white)),
                ) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "Setting Icon",
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        TextButton(onClick ={},
            colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.BrokenWhite),
            contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Secondary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 20.dp)
                .height(50.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Personel Icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Kişisel Bilgiler",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        TextButton(onClick ={},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.BrokenWhite),
                contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Secondary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 20.dp)
                .height(50.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Personel Icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Eğitim Bilgileri",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        TextButton(onClick ={},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.BrokenWhite),
                contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Secondary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 20.dp)
                .height(50.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Experience Icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Deneyimler",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        TextButton(onClick ={},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.BrokenWhite),
                contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Secondary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 20.dp)
                .height(50.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.Create,
                    contentDescription = "LanguageIcon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Yabancı Diller",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        TextButton(onClick ={},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.BrokenWhite),
                contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Secondary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 20.dp)
                .height(50.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.Build,
                    contentDescription = "LanguageIcon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Yetkinlikler",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        TextButton(onClick ={},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.BrokenWhite),
                contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Secondary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 20.dp)
                .height(50.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.Share,
                    contentDescription = "Social Icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Sosyal Medya Hesapları",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        TextButton(onClick ={},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.BrokenWhite),
                contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Secondary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 20.dp)
                .height(50.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Social Icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Referanslar",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        TextButton(onClick ={},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.BrokenWhite),
                contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Secondary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 20.dp)
                .height(50.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "Info Icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "CV Hazırlarken Dikkat Edilmesi Gerekenler",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier =  Modifier.height(16.dp))

        Button(onClick ={
        },  colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.Primary),
            contentColor = colorResource(R.color.black)),
            border = BorderStroke(2.dp, colorResource(R.color.Primary)),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .padding(horizontal = 50.dp)
                .height(50.dp)) {
            Icon(
                Icons.Default.ExitToApp,
                contentDescription = "Social Icon",
                tint = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier =  Modifier.width(4.dp))
            Text(text = "Çıkış", fontSize = 16.sp)
        }

    }

}