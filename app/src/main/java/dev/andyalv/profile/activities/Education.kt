package dev.andyalv.profile.activities

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun EducationScreen(){
    HorizontalDivider()

    // School
    TitleText("Formation")

    Text("Instituto Tecnológico de Morelia", fontWeight = FontWeight.Bold)
    Text("2020-2026", fontWeight = FontWeight.Light)
    Text("Computer Science Engineer with specialization in Cloud Development")

    HorizontalDivider()
    Spacer(modifier = Modifier.height(10.dp))

    // Languages
    TitleText("Languages")

    Text("English level - B1")
    HorizontalDivider()
}

@Composable
fun TitleText(text: String) {
    Text(text.uppercase(), style = MaterialTheme.typography.titleMedium)
    Spacer(modifier = Modifier.height(3.dp))
}