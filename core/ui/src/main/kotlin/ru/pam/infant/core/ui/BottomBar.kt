package ru.pam.decompose.core.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pam.decompose.core.designsystem.theme.decomposeTheme
import ru.pam.decompose.core.ui.ext.noRippleClickable

@Composable
fun BottomBar(
    actions: @Composable RowScope.() -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            actions()
        }
    }
}

@Composable
fun RowScope.BottomBarItem(
    title: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    val iconSize by animateDpAsState(
        targetValue = if (selected) 30.dp else 24.dp,
        animationSpec = tween(200)
    )

    val alpha by animateFloatAsState(
        targetValue = if (selected) 1f else 0.6f,
        animationSpec = tween(200)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .weight(1f)
            .noRippleClickable { onClick() }

    ) {
        Icon(
            modifier = Modifier.size(iconSize),
            imageVector = icon,
            contentDescription = title,
            tint = if (selected) MaterialTheme.colorScheme.primary else Color.Gray
        )
        Text(
            modifier = Modifier.alpha(alpha),
            text = title,
            style = MaterialTheme.typography.titleSmall,
            color = if (selected) MaterialTheme.colorScheme.primary else Color.Gray
        )
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    decomposeTheme {
        Surface {
            BottomBar(
                actions = {
                    BottomBarItem(
                        title = stringResource(android.R.string.cancel),
                        icon = Icons.Outlined.Home,
                        selected = true,
                        onClick = { },
                    )
                    BottomBarItem(
                        title = stringResource(android.R.string.ok),
                        icon = Icons.Outlined.Newspaper,
                        selected = false,
                        onClick = { },
                    )
                    BottomBarItem(
                        title = stringResource(android.R.string.copy),
                        icon = Icons.Outlined.Mail,
                        selected = false,
                        onClick = { },
                    )
                },
            )
        }
    }
}