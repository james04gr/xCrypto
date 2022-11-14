package com.xecoding.xcrypto.presentation.coin_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xecoding.xcrypto.data.remote.dto.coin.info.Team

@Composable
fun TeamListItem(
    member: Team
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = member.name)
        Text(text = member.position)
    }
}