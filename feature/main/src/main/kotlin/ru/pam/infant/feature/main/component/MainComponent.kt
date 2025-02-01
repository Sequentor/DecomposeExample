package ru.pam.decompose.feature.main.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable
import ru.pam.decompose.feature.home.component.HomeComponent
import ru.pam.decompose.feature.news.component.NewsComponent

interface MainComponent {

    val childStack: Value<ChildStack<*, Child>>

    val startState: StateFlow<StartState>

    fun openTab(tab: Tab)

    sealed interface Child {
        class Home(val component: HomeComponent) : Child
        class News(val component: NewsComponent) : Child
    }

    data class StartState(
        val selectedTab: Tab = Tab.Home,
        val tabs: List<Tab> = listOf(Tab.Home, Tab.News),
    )

    @Serializable
    sealed interface Tab {

        @Serializable
        data object Home : Tab

        @Serializable
        data object News : Tab
    }

    @Composable
    fun Render()
}