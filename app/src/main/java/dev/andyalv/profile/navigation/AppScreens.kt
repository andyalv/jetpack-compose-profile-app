package dev.andyalv.profile.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.Clipboard
import compose.icons.fontawesomeicons.regular.Futbol
import compose.icons.fontawesomeicons.regular.Gem
import compose.icons.fontawesomeicons.regular.HandScissors
import compose.icons.fontawesomeicons.solid.Book
import compose.icons.fontawesomeicons.solid.Home
import dev.andyalv.profile.activities.EducationScreen
import dev.andyalv.profile.activities.ExperienceScreen
import dev.andyalv.profile.activities.SkillScreen
import dev.andyalv.profile.activities.HobbieScren
import dev.andyalv.profile.activities.InterestsScreens
import dev.andyalv.profile.main.MainScreen

sealed class AppScreens(
    val route: String,
    val title: String,
    val content: @Composable () -> Unit,
    val drawerIcon: ImageVector = Icons.Default.Error,
    val shownInDrawer: Boolean = true
) {
    object Main: AppScreens(
        route = "main",
        title = "Home.md",
        content = { MainScreen() },
        drawerIcon = FontAwesomeIcons.Solid.Home
    )

    object Education: AppScreens(
        route = "education",
        title = "Education.md",
        content = { EducationScreen() },
        drawerIcon = FontAwesomeIcons.Solid.Book
    )

    object Skill: AppScreens(
        route = "skill",
        title = "Skills.md",
        content = { SkillScreen() },
        drawerIcon = FontAwesomeIcons.Regular.HandScissors
    )

    object Experience: AppScreens(
        route = "experience",
        title = "Experience.md",
        content = { ExperienceScreen() },
        drawerIcon = FontAwesomeIcons.Regular.Clipboard
    )

    object Hobbies: AppScreens(
        route = "hobbies",
        title = "Hobbies.md",
        content = { HobbieScren() },
        drawerIcon = FontAwesomeIcons.Regular.Futbol
    )

    object Interests: AppScreens(
        route = "interests",
        title = "Interests.md",
        content = { InterestsScreens() },
        drawerIcon = FontAwesomeIcons.Regular.Gem
    )
}