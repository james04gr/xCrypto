package com.xecoding.xcrypto.presentation.person_info

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.xecoding.xcrypto.domain.model.person.PersonLink

@Composable
fun LinkListItem(
    link: PersonLink
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = link.category,
            color = Color.DarkGray,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2
        )
        LazyColumn {
            items(link.links) { url ->
                Text(text = url)
            }
        }
    }
}