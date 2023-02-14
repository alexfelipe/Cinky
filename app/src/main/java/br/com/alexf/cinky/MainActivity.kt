package br.com.alexf.cinky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.alexf.cinky.model.currentUser
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
                    val currentRoute = backStackState?.destination?.route
                    val isShowFab = when (currentRoute) {
                        postsListRoute -> true
                        else -> false
                    }
                    val isShowTopAppBar = when (currentRoute) {
                        postsListRoute -> true
                        else -> false
                    }
                    CinkyApp(
                        isShowFab = isShowFab,
                        isShowTopAppBar = isShowTopAppBar,
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
    modifier: Modifier = Modifier,
    isShowFab: Boolean = false,
    isShowTopAppBar: Boolean = false,
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        state = rememberTopAppBarState()
    )
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
        },
        topBar = {
            if (isShowTopAppBar) {
                TopAppBar(
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "ícone para perfil"
                            )
                            Text(text = currentUser.name)
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        Box(modifier = Modifier.padding(it)) {
            content()
        }
    }
}
