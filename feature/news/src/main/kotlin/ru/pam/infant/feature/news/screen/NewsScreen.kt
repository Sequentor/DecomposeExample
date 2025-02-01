package ru.pam.decompose.feature.news.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.pam.decompose.core.resources.R
import ru.pam.decompose.core.ui.Toolbar

@Composable
internal fun NewsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar(
            title = stringResource(R.string.news),
        )
    }
}