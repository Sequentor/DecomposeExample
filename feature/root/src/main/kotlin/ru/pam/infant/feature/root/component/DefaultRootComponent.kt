package ru.pam.decompose.feature.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import ru.pam.decompose.feature.main.component.DefaultMainComponent
import ru.pam.decompose.feature.profile.component.DefaultProfileComponent
import ru.pam.decompose.feature.settings.component.DefaultSettingsComponent

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<RootComponent.Config>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = RootComponent.Config.Main,
        key = "RootComponent",
        serializer = RootComponent.Config.serializer(),
        handleBackButton = true,
        childFactory = ::createChild,
    )

    private fun createChild(
        config: RootComponent.Config,
        componentContext: ComponentContext
    ): RootComponent.Child = when (config) {
        is RootComponent.Config.Main -> mainComponent(componentContext)
        is RootComponent.Config.Settings -> settingsComponent(componentContext)
        is RootComponent.Config.Profile -> profileComponent(componentContext)
    }

    private fun mainComponent(context: ComponentContext) =
        RootComponent.Child.Main(
            DefaultMainComponent(
                componentContext = context,
                openSettings = { openSettings() },
            )
        )

    private fun settingsComponent(context: ComponentContext) =
        RootComponent.Child.Settings(
            DefaultSettingsComponent(
                componentContext = context,
                onBackClick = { onBackClick() }
            )
        )

    private fun profileComponent(context: ComponentContext) =
        RootComponent.Child.Profile(
            DefaultProfileComponent(
                componentContext = context,
                onBackClick = { onBackClick() }
            )
        )

    private fun openSettings() {
        navigation.push(RootComponent.Config.Settings)
    }

    private fun onBackClick() {
        navigation.pop()
    }
}