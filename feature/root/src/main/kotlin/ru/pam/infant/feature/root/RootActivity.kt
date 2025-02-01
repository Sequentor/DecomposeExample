package ru.pam.decompose.feature.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.arkivanov.decompose.retainedComponent
import ru.pam.decompose.core.designsystem.theme.decomposeTheme
import ru.pam.decompose.feature.root.component.DefaultRootComponent
import ru.pam.decompose.feature.root.component.RootComponent
import ru.pam.decompose.feature.root.screen.RootScreen

class RootActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen: SplashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition { false }

        enableEdgeToEdge()

        val component: RootComponent = retainedComponent { componentContext ->
            DefaultRootComponent(componentContext)
        }

        setContent {
            decomposeTheme {
                Surface {
                    RootScreen(component = component)
                }
            }
        }
    }
}