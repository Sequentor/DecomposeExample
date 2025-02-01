package ru.pam.decompose.feature.home.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import ru.pam.decompose.feature.home.screen.RootContent

class DefaultHomeComponent(
    componentContext: ComponentContext,
    private val openSettings: () -> Unit,
) : HomeComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<HomeComponent.Config>()

    override val childStack: Value<ChildStack<*, HomeComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = HomeComponent.Config.Home,
        key = "HomeComponent",
        serializer = HomeComponent.Config.serializer(),
        handleBackButton = true,
        childFactory = ::createChild,
    )

    override fun openSettings() {
        openSettings.invoke()
    }

    private fun createChild(
        config: HomeComponent.Config,
        componentContext: ComponentContext
    ): HomeComponent.Child = when (config) {
        is HomeComponent.Config.Home -> HomeComponent.Child.Home
    }

    @Composable
    override fun Render() {
        RootContent(component = this)
    }
}