package ru.pam.decompose.feature.news.component

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import ru.pam.decompose.feature.news.screen.NewsScreen

class DefaultNewsComponent(
    componentContext: ComponentContext,
) : NewsComponent, ComponentContext by componentContext {

    @Composable
    override fun Render() {
        NewsScreen()
    }
}