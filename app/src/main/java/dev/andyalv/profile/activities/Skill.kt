package dev.andyalv.profile.activities

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.andyalv.profile.R
import kotlinx.coroutines.delay

@Composable
fun SkillScreen() {
    val images = listOf(
        R.drawable.react_logo,
        R.drawable.astro_logo,
        R.drawable.vue_logo,
        R.drawable.fastapi_logo,
        R.drawable.spring_boot_logo,
        R.drawable.laravel_logo,
        R.drawable.django_logo
    )

    val pagerState = rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
        Int.MAX_VALUE
    }

    LaunchedEffect(pagerState) {
        while (true) {
            delay(2500)
            if (!pagerState.isScrollInProgress) {
                pagerState.animateScrollToPage(
                    pagerState.currentPage + 1,
                    animationSpec = tween(
                        durationMillis = 600,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        }
    }

    Column {
        Text("I am experienced with technologies for Frontend development as React, React Native, Astro and Vue.")

        Text("As for backend development, I've worked with FastAPI, SpringBoot, Laravel and Django with more experience with the first two.")

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) { page ->
            val imageIndex = page % images.size

            Image(
                painter = painterResource(images[imageIndex]),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}