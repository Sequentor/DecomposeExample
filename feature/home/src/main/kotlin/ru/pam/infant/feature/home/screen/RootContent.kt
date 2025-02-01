package ru.pam.decompose.feature.home.screen

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import ru.pam.decompose.feature.home.component.HomeComponent

@Composable
fun RootContent(component: HomeComponent) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is HomeComponent.Child.Home -> {
                HomeScreen(openSettings = component::openSettings)
            }
        }
    }
}