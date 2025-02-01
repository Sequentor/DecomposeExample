package ru.pam.decompose.feature.home.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

interface HomeComponent {

    val childStack: Value<ChildStack<*, Child>>

    fun openSettings()

    sealed interface Child {
        data object Home : Child
    }

    @Serializable
    sealed interface Config {

        @Serializable
        data object Home : Config
    }

    @Composable
    fun Render()
}