package com.xecoding.xcrypto.domain.use_cases

import com.xecoding.xcrypto.common.Helpers.toPersonInfo
import com.xecoding.xcrypto.common.NetworkResource
import com.xecoding.xcrypto.domain.model.person.PersonInfo
import com.xecoding.xcrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPersonInfoUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(personId: String): Flow<NetworkResource<PersonInfo>> = flow {
        try {
            emit(NetworkResource.Loading())
            val personInfo = coinRepository.getPersonInfo(personId).toPersonInfo()
            emit(NetworkResource.Success(data = personInfo))
        } catch (e: Exception) {
            emit(NetworkResource.Error(message = e.message.toString()))
        }
    }

}