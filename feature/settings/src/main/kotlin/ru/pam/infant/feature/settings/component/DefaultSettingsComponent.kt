package ru.pam.decompose.feature.settings.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import ru.pam.decompose.feature.settings.screen.SettingsScreen

class DefaultSettingsComponent(
    componentContext: ComponentContext,
    private val onBackClick: () -> Unit
) : SettingsComponent, ComponentContext by componentContext {

    @Composable
    override fun Render() {
        SettingsScreen(onBackClick = onBackClick)
    }
}