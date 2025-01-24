package com.example.smartcv.pages


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcv.R
import com.example.smartcv.viewmodel.InformationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactPage(navController: NavController,  viewModel: InformationViewModel){

    var linkedn by remember { mutableStateOf("" ) }
    var github by remember { mutableStateOf("") }
    val saveStatus by viewModel.saveStatus.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(saveStatus) {
        saveStatus?.let { success ->
            val message = if (success) {
                "Bilgiler başarıyla kaydedildi."
            } else {
                "Bilgiler kaydedilirken bir hata oluştu."
            }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    //navController.popBackStack()
                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text("Sosyal Medya Hesapları")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedTextField(
                value = github,
                onValueChange = {github = it},
                label = { Text(text = "Github") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "github icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.Secondary)
                ),
            )
            Spacer(modifier =  Modifier.height(8.dp))

            OutlinedTextField(
                value = linkedn,
                onValueChange = {linkedn = it},
                label = { Text(text = "Linkedn") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "github icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.Secondary)
                ),
            )

            Spacer(modifier =  Modifier.height(8.dp))

            Button(onClick ={
                viewModel.contactInformation(
                    github= github,
                   linkedn = linkedn,
                )
            },  colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.Secondary),
                contentColor = colorResource(R.color.white)),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 50.dp)
                    .height(50.dp)) {
                Text(text = "Kaydet", fontSize = 16.sp)
            }
        }
    }

}