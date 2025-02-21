package com.example.prography_10th_android.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prography_10th_android.core.designsystem.theme.Prography10thandroidTheme

@Composable
fun UnSplashPhotoCard(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.fillMaxWidth()
        .clip(shape = RoundedCornerShape(10.dp)),
        content = content,
    )
}

@Preview
@Composable
private fun UnSplashPhotoCardPreview() {
    Prography10thandroidTheme {
        UnSplashPhotoCard(
            modifier = Modifier.size(600.dp)
        ) {}
    }
}
