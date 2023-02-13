package br.com.alexf.cinky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.alexf.cinky.navigation.CinkyNavHost
import br.com.alexf.cinky.navigation.navigateToPostForm
import br.com.alexf.cinky.navigation.postFormRoute
import br.com.alexf.cinky.navigation.postsListRoute
import br.com.alexf.cinky.ui.theme.CinkyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinkyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val backStackState by navController.currentBackStackEntryAsState()
                    val isShowFab = when(backStackState?.destination?.route) {
                        postsListRoute -> true
                        else -> false
                    }
                    CinkyApp(
                        isShowFab = isShowFab,
                        onFabClick = {
                            navController.navigateToPostForm()
                        }
                    ) {
                        CinkyNavHost(navController)
                    }
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinkyApp(
    isShowFab: Boolean = false,
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            if (isShowFab) {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(
                        Icons.Default.Create,
                        contentDescription = "ícone para criar um post"
                    )
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            content()
        }
    }
}
