@file:OptIn(ExperimentalMaterial3Api::class)

package dev.andyalv.profile.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.brands.InstagramSquare
import compose.icons.fontawesomeicons.brands.Linkedin
import dev.andyalv.profile.R

@Composable
fun MainScreen() {
    val personalDescription = buildAnnotatedString {
        append("Computer Science Engineer Student at ")

        pushLink(
            LinkAnnotation.Url("https://share.google/0W59FtOHDhEOSMYnz")
        )
        withStyle(
            style = SpanStyle(
                color = LocalContentColor.current,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Instituto Tecnológico de Morelia")
        }
        append(".")
        pop()
    }

    Text("Carlos Andrés Alvarez Arreygue")
    ProfilePicture(R.drawable.profile_picture)
    Text("Mostly found as @andyalv")

    SocialRow()

    Text(personalDescription)
    Text("I am passionate about creating technological solutions to real life problems. I am specialized in web development and personally interested in fullstack development.")
}

@Composable
fun SocialRow() {
    val socialList: List<Pair<ImageVector, String>> = listOf(
        FontAwesomeIcons.Brands.Github to "https://github.com/andyalv",
        FontAwesomeIcons.Brands.Linkedin to "https://www.linkedin.com/in/andyalv/",
        FontAwesomeIcons.Brands.InstagramSquare to "https://www.instagram.com/andyalv12/",
    )

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        socialList.forEach { (vector, url) ->
            SocialButton(vector, url)
        }
    }
}

@Composable
fun SocialButton(
    vector: ImageVector,
    url: String,
    description: String? = null,
) {
    val uriHandler = LocalUriHandler.current

    IconButton(
        onClick = { uriHandler.openUri(url) },
    ) {
        Icon(
            imageVector = vector,
            contentDescription = description,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun ProfilePicture(imgResource: Int, description: String? = null) {
    Image(
        painter = painterResource(imgResource),
        contentDescription = description,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .border(
                width = 3.dp,
                color = LocalContentColor.current,
                shape = CircleShape,
            )
    )
}