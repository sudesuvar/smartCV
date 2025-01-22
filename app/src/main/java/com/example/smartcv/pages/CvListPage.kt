package com.example.smartcv.pages

import android.widget.RatingBar
import android.widget.Toast
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartcv.R

@Composable
fun CvListPage() {
    var searchText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("All") }


    val context = LocalContext.current // Context'i burada alıyoruz

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar(
                searchText = searchText,
                onSearchTextChanged = { searchText = it },
                modifier = Modifier.weight(1f)

            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Sharp.Menu,
                contentDescription = "arama",
                modifier = Modifier
                    .clickable {
                        Toast.makeText(context, "Not yet implemented.", Toast.LENGTH_SHORT).show()
                    }
                    .padding(8.dp)
                    .size(42.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("stringResource(id = R.string.accdate)") },
                    onClick = {
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("stringResource(id = R.string.acccolor)") },
                    onClick = {
                        expanded = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Kategoriler", style = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.onBackground))
        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            CategoryButton("Hepsi", selectedCategory, Color.Gray) { selectedCategory = "Hepsi" }
            CategoryButton("Soft", selectedCategory, Color(0xFFa40000)) { selectedCategory = "Soft" }
            CategoryButton("Dinamik", selectedCategory, Color(0xFF008b00)) { selectedCategory = "Dinamik" }
            //CategoryButton("Yetkin", selectedCategory, Color(0xFF0961B6)) { selectedCategory = "Yetkin" }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.cv),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))

                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "cv adı",
                        style = MaterialTheme.typography.labelMedium,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "235 kez indirildi.",
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    //RatingBar(rating = cv.rating)
                }

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = { /* Favorilere ekleme işlemi */ },
                    modifier = Modifier
                        .size(40.dp)
                        .background(color = colorResource(R.color.Secondary), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = colorResource(R.color.Primary)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.cv),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))

                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "cv adı 2",
                        style = MaterialTheme.typography.labelMedium,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "235 kez indirildi.",
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    //RatingBar(rating = cv.rating)
                }

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = { /* Favorilere ekleme işlemi */ },
                    modifier = Modifier
                        .size(40.dp)
                        .background(color = colorResource(R.color.Secondary), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = colorResource(R.color.Primary)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.cv),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))

                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "cv adı 3",
                        style = MaterialTheme.typography.labelMedium,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "233 kez indirildi.",
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    //RatingBar(rating = cv.rating)
                }

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = { /* Favorilere ekleme işlemi */ },
                    modifier = Modifier
                        .size(40.dp)
                        .background(color = colorResource(R.color.Secondary), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = colorResource(R.color.Primary)
                    )
                }
            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(searchText: String, onSearchTextChanged: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = searchText,
        onValueChange = onSearchTextChanged,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        placeholder = {
            Text(
                text = "Arama",
                fontSize = 16.sp,
                color = Color.Gray

            )
        },
        textStyle = TextStyle(fontSize = 16.sp),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun CategoryButton(
    category: String,
    selectedCategory: String,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (category == selectedCategory) color else Color.LightGray
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = category, color = Color.White, fontSize = 18.sp)
    }
}


