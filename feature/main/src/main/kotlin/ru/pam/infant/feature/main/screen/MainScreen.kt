@file:OptIn(ExperimentalMaterial3Api::class)

package ru.pam.decompose.feature.main.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import ru.pam.decompose.core.resources.R
import ru.pam.decompose.core.ui.BottomBar
import ru.pam.decompose.core.ui.BottomBarItem
import ru.pam.decompose.feature.main.component.MainComponent

@Composable
internal fun MainScreen(component: MainComponent) {
    val state by component.startState.collectAsState()
    Column {
        Children(
            stack = component.childStack,
            modifier = Modifier.weight(1f),
            animation = stackAnimation(fade() + scale()),
        ) {
            when (val child = it.instance) {
                is MainComponent.Child.Home -> child.component.Render()
                is MainComponent.Child.News -> child.component.Render()
            }
        }
        BottomBar(
            actions = {
                state.tabs.forEach { tab ->
                    BottomBarItem(
                        title = stringResource(tab.resId),
                        icon = tab.icon,
                        selected = state.selectedTab == tab,
                        onClick = { component.openTab(tab) },
                    )
                }
            },
        )
    }
}

internal val MainComponent.Tab.icon: ImageVector
    get() = when (this) {
        MainComponent.Tab.Home -> Icons.Outlined.Home
        MainComponent.Tab.News -> Icons.Outlined.Newspaper
    }

internal val MainComponent.Tab.resId: Int
    get() = when (this) {
        MainComponent.Tab.Home -> R.string.home
        MainComponent.Tab.News -> R.string.news
    }