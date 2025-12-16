@file:OptIn(ExperimentalMaterial3Api::class)
package dev.andyalv.profile.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerNavigation() {
    val navController = rememberNavController()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val drawerScreens = listOf(
        AppScreens.Main,
        AppScreens.Education,
        AppScreens.Skill,
        AppScreens.Experience,
        AppScreens.Interests,
        AppScreens.Hobbies,
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(
                    navController = navController,
                    drawerScreens= drawerScreens,
                    onClose = { scope.launch { drawerState.close() } }
                )
            }
        }
    ) {
        AppNavigation(
            navController = navController,
            drawerState = drawerState,
            drawerScreens = drawerScreens,
            scope = scope
        )
    }
}

@Composable
fun CustomTopAppBar(title: String, onClick: () -> Unit) {

    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton( onClick = onClick ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                )
            }
        }
    )
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    drawerState: DrawerState,
    drawerScreens: List<AppScreens>,
    scope: CoroutineScope
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentScreen = drawerScreens.find { it.route == currentRoute }
    val title = currentScreen?.title.orEmpty()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title,
                onClick = { scope.launch { drawerState.open() } }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreens.Main.route,
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
        ) {
            drawerScreens.forEach { screen ->
                composable(route = screen.route) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    ) {
                        screen.content()
                    }
                }
            }
        }
    }
}

@Composable
fun DrawerLabel(icon: ImageVector, text: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, Modifier.size(24.dp))
        Text(text)
    }
}

@Composable
fun DrawerContent(
    navController: NavController,
    drawerScreens: List<AppScreens>,
    onClose: () -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Column(
       modifier = Modifier.padding(10.dp)
    ) {
        drawerScreens
            .filter { it.shownInDrawer }
            .forEach { screen ->
                NavigationDrawerItem(
                    label = { DrawerLabel(screen.drawerIcon, screen.title) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        if (currentRoute != screen.route) {
                            navController.navigate(screen.route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                        onClose()
                    }
                )
            }
    }
}