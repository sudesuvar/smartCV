package com.example.smartcv.pages

import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcv.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationPage(
    navController: NavController,
    onDateSelected: (Long?, Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerStateStart = rememberDatePickerState() // Başlangıç tarihi state
    val datePickerStateEnd = rememberDatePickerState()   // Bitiş tarihi state
    val showStartDatePicker = remember { mutableStateOf(false) }
    val showEndDatePicker = remember { mutableStateOf(false) }

    val selectedStartDate = remember { mutableStateOf<String?>(null) }
    val selectedEndDate = remember { mutableStateOf<String?>(null) }

    var dropControl = remember { mutableStateOf(false) }
    var selectIndex = remember { mutableIntStateOf(0) }
    val countryList = listOf("Kocaeli Üniversitesi", "İstanbul Üniversitesi", "Ankara Üniversitesi", "İzmir Üniversitesi", "Atılım Üniversitesi", "Çanakkale 18 Mart Üniversitesi")

    var checked = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            ),
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
                    navController.popBackStack()
                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text("Eğitim Bilgileri")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clickable {
                            dropControl.value = true
                        }
                ) {
                    Text(
                        text = countryList[selectIndex.value],
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 16.sp
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "name icon",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }

                DropdownMenu(
                    expanded = dropControl.value,
                    onDismissRequest = { dropControl.value = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    countryList.forEachIndexed { index, country ->
                        DropdownMenuItem(
                            text = { Text(text = country) },
                            onClick = {
                                dropControl.value = false
                                selectIndex.value = index
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Okul Adı") },
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
                    unfocusedBorderColor = colorResource(R.color.Secondary),
                        focusedPlaceholderColor = colorResource(R.color.Secondary)
                ),
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Bölüm Adı Input
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Bölüm Adı") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "department icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.Secondary)
                ),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {


                OutlinedButton(
                    onClick = { showStartDatePicker.value = true },
                    modifier = Modifier
                        //.fillMaxWidth(0.9f)
                        .padding(vertical = 8.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "date icon",
                        tint = colorResource(R.color.black)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = "Başlangıç",
                        fontSize = 16.sp,
                        color = colorResource( R.color.black)
                    )
                }

                OutlinedButton(
                    onClick = { showEndDatePicker.value = true },
                    modifier = Modifier
                        //.fillMaxWidth(0.9f)
                        .padding(vertical = 8.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "date icon",
                        tint = colorResource(R.color.black)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = "Bitiş ",
                        fontSize = 16.sp,
                        color = colorResource( R.color.black)
                    )
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Devam Ediyor",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(16.dp))
                Switch(
                    checked = checked.value,
                    onCheckedChange = {
                        checked.value = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(R.color.Primary),
                        checkedTrackColor = colorResource(R.color.Secondary),
                        uncheckedThumbColor = colorResource(R.color.Secondary),
                        uncheckedTrackColor = colorResource(R.color.Primary),
                    ),
                    modifier = Modifier.weight(1f)
                )
            }


            // Kaydet Butonu
            Button(
                onClick = {
                    onDateSelected(datePickerStateStart.selectedDateMillis, datePickerStateEnd.selectedDateMillis)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.Secondary),
                    contentColor = colorResource(R.color.white)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 50.dp)
                    .height(50.dp)
            ) {
                Text(text = "Kaydet", fontSize = 16.sp)
            }
        }
    }

    // Başlangıç Tarihi DatePickerDialog
    if (showStartDatePicker.value) {
        DatePickerDialog(
            onDismissRequest = { showStartDatePicker.value = false },
            confirmButton = {
                TextButton(onClick = {
                    selectedStartDate.value = datePickerStateStart.selectedDateMillis?.let {
                        it.toString()
                    }
                    onDateSelected(datePickerStateStart.selectedDateMillis, null)
                    showStartDatePicker.value = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showStartDatePicker.value = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerStateStart)
        }
    }

    if (showEndDatePicker.value) {
        DatePickerDialog(
            onDismissRequest = { showEndDatePicker.value = false },
            confirmButton = {
                TextButton(onClick = {
                    selectedEndDate.value = datePickerStateEnd.selectedDateMillis?.let {
                        it.toString()
                    }
                    onDateSelected(null, datePickerStateEnd.selectedDateMillis)
                    showEndDatePicker.value = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEndDatePicker.value = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerStateEnd)
        }
    }
}

