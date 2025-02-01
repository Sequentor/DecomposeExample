package ru.pam.decompose.feature.main.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.pam.decompose.feature.home.component.DefaultHomeComponent
import ru.pam.decompose.feature.main.screen.MainScreen
import ru.pam.decompose.feature.news.component.DefaultNewsComponent

class DefaultMainComponent(
    componentContext: ComponentContext,
    private val openSettings: () -> Unit,
) : MainComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<MainComponent.Tab>()

    private val _startState: MutableStateFlow<MainComponent.StartState> =
        MutableStateFlow(MainComponent.StartState())

    override val childStack: Value<ChildStack<*, MainComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = MainComponent.Tab.Home,
        key = "MainComponent",
        serializer = MainComponent.Tab.serializer(),
        handleBackButton = false,
        childFactory = ::createChild,
    )

    override val startState: StateFlow<MainComponent.StartState> = _startState

    override fun openTab(tab: MainComponent.Tab) {
        navigation.bringToFront(tab)
        _startState.update { it.copy(selectedTab = tab) }
    }

    @Composable
    override fun Render() {
        MainScreen(component = this)
    }

    private fun createChild(
        tab: MainComponent.Tab,
        componentContext: ComponentContext
    ): MainComponent.Child = when (tab) {
        is MainComponent.Tab.Home -> homeComponent(componentContext)
        is MainComponent.Tab.News -> newsComponent(componentContext)
    }

    private fun homeComponent(context: ComponentContext) =
        MainComponent.Child.Home(
            DefaultHomeComponent(
                componentContext = context,
                openSettings = openSettings,
            )
        )

    private fun newsComponent(context: ComponentContext) =
        MainComponent.Child.News(
            DefaultNewsComponent(
                componentContext = context,
            )
        )
}