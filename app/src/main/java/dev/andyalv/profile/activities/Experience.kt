package dev.andyalv.profile.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.andyalv.profile.R

@Composable
fun ExperienceScreen(){
    Column {
        Image(
            painter = painterResource(R.drawable.logophaimat),
            contentDescription = null,
            Modifier.size(100.dp)
        )
        Text("Phaimat Labs", fontWeight = FontWeight.Bold)
        Text("Mar. 2025 - Now • 10 months", fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(2.dp))
        Text("Independent contractor managing virtual private servers and databases, collaborating on a web application development project with REST API.")
    }
}