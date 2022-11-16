package com.xecoding.xcrypto.presentation.person_info

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.os.persistableBundleOf
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PersonInfoScreen(
    viewModel: PersonInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        state.personInfo?.let { personInfo ->
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ) {
                Text(
                    text = personInfo.name,
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = personInfo.description,
                    style = MaterialTheme.typography.body2
                )
            }
        }
        if(!state.message.isNullOrBlank()) {
            Text(
                text = state.message,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}