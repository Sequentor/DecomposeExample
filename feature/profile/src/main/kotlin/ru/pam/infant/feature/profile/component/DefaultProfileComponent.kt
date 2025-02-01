package ru.pam.decompose.feature.profile.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import ru.pam.decompose.feature.profile.screen.ProfileScreen

class DefaultProfileComponent(
    componentContext: ComponentContext,
    private val onBackClick: () -> Unit
) : ProfileComponent, ComponentContext by componentContext {

    @Composable
    override fun Render() {
        ProfileScreen(onBackClick = onBackClick)
    }
}