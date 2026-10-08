package com.example.bottomnavigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bottomnavigationdemo.ui.theme.BottomNavigationDemoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.ButtonDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavigationDemoTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF6DDE7),
                        Color(0xFFFFFAF7)
                    )
                )
            )
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(88.dp)
                    .background(
                        color = Color(0xFF74455C),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "</>",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
            }

            Text(
                text = "KodeSpire",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF442C3A),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Lær Kotlin og Jetpack Compose",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF74455C)
            )

            Text(
                text = "Små steg. Mer forståelse.\nBygg kunnskap gjennom øving",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF442C3A),
                textAlign = TextAlign.Center
            )
        }

        Card(
            onClick = { expanded = !expanded},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFF4F8)
            )
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Bli kjent med KodeSpire",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF442C3A)
                )

                Text(
                    text = "Forstå, prøv og lær",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xff74455C)
                )

                if (expanded) {
                    Text(
                        text = "Utforsk begreper i Kotlin og Jetpack Compose, " +
                        "se enkle kodeeksempler og test forståelsen din med " +
                        "små quizer. Start med grensesnitt, state og navigasjon",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF442C3A)
                    )
                }

                Text(
                    text = if (expanded) "Vis mindre -" else "Les mer +",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFF74455C)
                )
            }
        }
    }
}

@Composable
fun PracticeScreen() {
    var selectedAnswer by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Øving",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Test forståelsen din av Column, Row og Box.",
            style = MaterialTheme.typography.bodyLarge
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Hva plasserer elementer under hverandre?",
                    style = MaterialTheme.typography.titleMedium
                )

                listOf("Column", "Row", "Box").forEach { answer ->
                    OutlinedButton(
                        onClick = { selectedAnswer = answer },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (selectedAnswer == answer) {
                                MaterialTheme.colorScheme.primaryContainer
                            } else {
                                Color.Transparent
                            },
                            contentColor = MaterialTheme.colorScheme.onSurface
                        )
                    ) {
                        Text(
                            text = if (selectedAnswer == answer) {
                                "Valgt: $answer"
                            } else {
                                answer
                            }
                        )
                    }
                }

                if (selectedAnswer.isNotEmpty()) {
                    Text(
                        text = if (selectedAnswer == "Column") {
                            "Riktig! Column plasserer elementer vertikalt."
                        } else {
                            "Prøv igjen! Column plasserer elementer " +
                                    " under hverandre. Row plasserer dem " +
                                    "ved siden av hverandre, og Box kan " +
                                    "legge dem oppå hverandre."
                        }
                    )
                }
            }

        }
    }
}

@Composable
fun LearningScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Utforsk",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Bli kjent med byggesteinene i Jetpack Compose."
        )

        Text(
            text = "Grensesnitt",
            style = MaterialTheme.typography.titleLarge
        )

        CourseCard(
            title = "Column",
            summary = "Plasserer elementer under hverandre",
            learning = "Column organiserer innhold vertikalt. " +
            "I denne appen bruker vi Column til å plassere " +
            "overskrifter, tekster og kort under hverandre."
        )

        CourseCard(
            title = "Row",
            summary = "Plasserer elementer ved siden av hverandre",
            learning = "Row organiserer innhold horisontalt. " +
            "Den kan for eksempel brukes til å vise " +
            "et ikon og en tekst ved siden av hverandre."
        )

        CourseCard(
            title = "Box",
            summary = "Plasserer innhold oppå hverandre",
            learning = "Box kan legge elementer oppå hverandre og " +
            "plassere dem innenfor samme område. I KodeSpire " +
            "bruker vi Box til å sentrere </<-symbolet i sirkelen."
        )
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    var selectedScreen by rememberSaveable {
        mutableStateOf("Hjem")
    }

    Scaffold(
      modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedScreen == "Hjem",
                    onClick = { selectedScreen = "Hjem" },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Hjem"
                        )
                    },
                    label = { Text("Hjem") }
                )

                NavigationBarItem(
                    selected = selectedScreen == "Øving",
                    onClick = { selectedScreen = "Øving"},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Work,
                            contentDescription = "Øving"
                        )
                    },
                    label = { Text("Øving") }
                )

                NavigationBarItem(
                    selected = selectedScreen == "Læring",
                    onClick = { selectedScreen = "Læring" },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = "Læring"
                        )
                    },
                    label = { Text("Læring") }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when (selectedScreen) {
                "Hjem" -> HomeScreen()
                "Øving" -> PracticeScreen()
                "Læring" -> LearningScreen()
            }
        }
    }
}

@Composable
fun CourseCard(
    title: String,
    summary: String,
    learning: String
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        onClick = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = summary,
                style = MaterialTheme.typography.bodyMedium
            )

            if (expanded) {
                Text(
                    text = learning,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = if (expanded) "Vis mindre -" else "Les mer +",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}