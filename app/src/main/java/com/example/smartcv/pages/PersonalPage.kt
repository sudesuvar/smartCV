package com.example.smartcv.pages

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcv.R
import com.example.smartcv.Routes
import com.example.smartcv.viewmodel.InformationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalPage(navController: NavController,
                 onDateSelected: (Long?) -> Unit,
                 onDismiss: () -> Unit,
                 viewModel: InformationViewModel) {

    val datePickerState = rememberDatePickerState()
    val showDatePicker = remember { mutableStateOf(false) }
    val selectedGender = remember { mutableStateOf<String?>(null) }

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var telephone by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
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
            Text("Kişisel Bilgiler")
        }

        Box(
            modifier = Modifier
                .width(300.dp)
                .wrapContentHeight()
                .background(color = colorResource(R.color.Primary), shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 25.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile Image",
                        modifier = Modifier.fillMaxSize()
                    )
                    // GÖRÜNMÜYOORRRR İCONNNNN
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(36.dp)
                            .align(Alignment.BottomEnd)
                            .background(colorResource(R.color.Secondary), CircleShape)
                        .padding(vertical = 8.dp)
                    )

                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Bu fotoğrafı Cv'ne de ekleyebilirsin.",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = { Text(text = "İsim") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "name icon"
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
                value = surname,
                onValueChange = {surname = it},
                label = { Text(text = "Soyisim") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "surname icon"
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
                value = telephone,
                onValueChange = {telephone = it},
                label = { Text(text = "Telefon") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "telephone icon"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.Secondary)
                ),
            )
            Spacer(modifier =  Modifier.height(8.dp))

            Button(
                onClick = { showDatePicker.value = true },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.Secondary),
                    contentColor = colorResource(R.color.white)
                )
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "telephone icon"
                )
                Spacer(modifier =  Modifier.width(3.dp))
                Text(
                    text = "Doğum Tarihini Seç",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier =  Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                AssistChip(
                    onClick = { selectedGender.value = "Erkek" },
                    label = { Text("Erkek") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Localized description",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedGender.value == "Erkek") colorResource(id = R.color.Primary) else Color.Transparent
                    ),

                )
                AssistChip(
                    onClick = { selectedGender.value = "Kadın" },
                    label = { Text("Kadın") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Localized description",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedGender.value == "Kadın") colorResource(id = R.color.Primary) else Color.Transparent
                    ),

                )
                AssistChip(
                    onClick = { selectedGender.value = "Diğer" },
                    label = { Text("Diğer") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Face,
                            contentDescription = "Localized description",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedGender.value == "Diğer") colorResource(id = R.color.Primary) else Color.Transparent
                    ),
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick ={
                viewModel.personalInformation(
                    name = name,
                    surname = surname,
                    telephone = telephone,
                    birthDate = birthDate,
                    gender = selectedGender.value
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

        if (showDatePicker.value) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker.value = false },
                confirmButton = {
                    TextButton(onClick = {
                        birthDate = datePickerState.selectedDateMillis?.let {
                            java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault()).format(it)
                        } ?: ""
                        showDatePicker.value = false
                    }) {
                        Text("Tamam")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker.value = false }) {
                        Text("Geri")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }

    }

