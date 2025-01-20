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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcv.R


@Composable
fun LanguagePage(navController: NavController){


    var dropControl = remember { mutableStateOf(false) }
    var selectIndex = remember { mutableIntStateOf(0) }
    val languageList = listOf("İngilizce", "İspanyolca", "Almanca", "Fransızca", "İtalyanca", "Arapça", "Rusça","Türkçe")
    val selectedLevel = remember { mutableStateOf<String?>(null) }


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
            Text(" Yabancı Dil Bilgileri")
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
                        text = languageList[selectIndex.value],
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
                    languageList.forEachIndexed { index, country ->
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

            Spacer(modifier =  Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                AssistChip(
                    onClick = { selectedLevel.value = "Başlangıç" },
                    label = { Text("Başlangıç") },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedLevel.value == "Başlangıç") colorResource(id = R.color.Primary) else Color.Transparent
                    ),

                    )
                AssistChip(
                    onClick = { selectedLevel.value = "Orta" },
                    label = { Text("Orta") },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedLevel.value == "Orta") colorResource(id = R.color.Primary) else Color.Transparent
                    ),

                    )
                AssistChip(
                    onClick = { selectedLevel.value = "İleri" },
                    label = { Text("İleri") },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedLevel.value == "İleri") colorResource(id = R.color.Primary) else Color.Transparent
                    ),
                )
            }

            Spacer(modifier =  Modifier.height(16.dp))

            Button(
                onClick = {

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




}