package com.xecoding.xcrypto.presentation.coin_info

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.xecoding.xcrypto.data.remote.dto.coin.info.Team
import com.xecoding.xcrypto.presentation.Screen

@Composable
fun TeamListItem(
    member: Team,
    onItemClicked: (String) -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onItemClicked(member.id)
            }
    ) {
        Text(text = member.name)
        Text(text = member.position)
    }
}