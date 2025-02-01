package ru.pam.decompose.feature.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import ru.pam.decompose.core.resources.R
import ru.pam.decompose.core.ui.Toolbar

@Composable
internal fun HomeScreen(
    openSettings: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar(
            title = stringResource(R.string.home),
            actions = {
                Image(
                    modifier = Modifier.clickable(onClick = openSettings),
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
                )
            }
        )
    }
}