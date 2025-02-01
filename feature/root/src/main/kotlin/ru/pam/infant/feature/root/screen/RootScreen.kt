package ru.pam.decompose.feature.root.screen

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import ru.pam.decompose.feature.root.component.RootComponent

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Main -> child.component.Render()
            is RootComponent.Child.Settings -> child.component.Render()
            is RootComponent.Child.Profile -> child.component.Render()
        }
    }
}