package com.xecoding.xcrypto.presentation.person_info

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xecoding.xcrypto.common.NetworkResource
import com.xecoding.xcrypto.domain.use_cases.GetPersonInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PersonInfoViewModel @Inject constructor(
    private val getPersonInfoUseCase: GetPersonInfoUseCase,
    savedStateStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(PersonInfoState())
    val state = _state

    init {
        savedStateStateHandle.get<String>("personId")?.let {
            getPersonInfo(it)
        }
    }

    private fun getPersonInfo(personId: String) {
        getPersonInfoUseCase(personId).onEach {
            when (it) {
                is NetworkResource.Loading -> _state.value = PersonInfoState(isLoading = true)
                is NetworkResource.Success -> _state.value = PersonInfoState(personInfo = it.data)
                is NetworkResource.Error -> _state.value = PersonInfoState(message = it.message)
            }
        }.launchIn(viewModelScope)
    }

}