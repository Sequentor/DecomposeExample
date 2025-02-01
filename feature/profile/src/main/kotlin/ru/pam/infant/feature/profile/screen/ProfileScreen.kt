package ru.pam.decompose.feature.profile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import ru.pam.decompose.core.resources.R
import ru.pam.decompose.core.ui.Toolbar

@Composable
internal fun ProfileScreen(onBackClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar(
            title = stringResource(R.string.profile),
            navigationIcon = {
                Image(
                    modifier = Modifier.clickable(onClick = onBackClick),
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
                )
            },
        )
    }
}