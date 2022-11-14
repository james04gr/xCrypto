package com.xecoding.xcrypto.presentation.coin_info

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.xecoding.xcrypto.data.remote.dto.coin.info.Tag

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CoinTag(
    tag: Tag
) {
    Chip(
        onClick = { /* Do something! */ },
        border = BorderStroke(
            ChipDefaults.OutlinedBorderSize,
            Color.Green
        ),
        colors = ChipDefaults.chipColors(
            backgroundColor = Color.White,
            contentColor = Color.Green
        )
    ) {
        Text(tag.name)
    }
}