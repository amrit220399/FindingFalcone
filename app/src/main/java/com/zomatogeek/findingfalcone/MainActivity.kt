package com.zomatogeek.findingfalcone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zomatogeek.findingfalcone.ui.theme.FindingFalconeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindingFalconeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val isPortfolioVisible = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .height(390.dp)
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(corner = CornerSize(12.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateProfileImage()
                Divider(
                    modifier = Modifier.padding(top = 4.dp),
                    thickness = 1.5.dp,
                    color = Color.LightGray
                )
                CreateUserInfo()
                Button(
                    onClick = {
                        isPortfolioVisible.value = !isPortfolioVisible.value
                    },
                ) {
                    Text(text = "Portfolio", style = MaterialTheme.typography.headlineSmall)
                }
                if (isPortfolioVisible.value) {
                    PortfolioContent()
                } else {
                    Box {}
                }
            }


        }
    }
}


@Composable
fun PortfolioContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(12.dp)),
            border = BorderStroke(2.dp, color = Color.LightGray),
        ) {
            Portfolio(
                data = listOf(
                    "Project 1",
                    "Project 2",
                    "Project 3",
                    "Project 4",
                    "Project 5",
                    "Project 6"
                )
            )
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    // Similar to RecyclerView
    LazyColumn(modifier = Modifier.background(Color.White)) {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp)
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    CreateProfileImage(Modifier.size(70.dp))
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(item, fontWeight = FontWeight.Bold)
                        Text("A great project!", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateUserInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Amrit Singh",
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier.padding(3.dp),
            text = "@Full Stack Developer",
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(3.dp),
            text = "Android/ ROR/ ReactNative"
        )
    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        shadowElevation = 4.dp,
        border = BorderStroke(width = 0.5.dp, color = Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.batman_logo_avatar),
            contentDescription = "Profile Pic",
            modifier = modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FindingFalconeTheme {
        CreateBizCard()
    }
}