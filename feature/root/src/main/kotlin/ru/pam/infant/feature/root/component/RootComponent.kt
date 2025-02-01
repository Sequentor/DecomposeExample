package ru.pam.decompose.feature.root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.pam.decompose.feature.main.component.MainComponent
import ru.pam.decompose.feature.profile.component.ProfileComponent
import ru.pam.decompose.feature.settings.component.SettingsComponent

interface RootComponent {

    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        data class Main(val component: MainComponent) : Child
        data class Settings(val component: SettingsComponent) : Child
        data class Profile(val component: ProfileComponent) : Child
    }

    @Serializable
    sealed interface Config {

        @Serializable
        data object Main : Config

        @Serializable
        data object Settings : Config

        @Serializable
        data object Profile : Config
    }
}