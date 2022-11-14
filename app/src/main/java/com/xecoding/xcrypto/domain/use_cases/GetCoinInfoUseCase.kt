package com.xecoding.xcrypto.domain.use_cases

import com.xecoding.xcrypto.common.Helpers.toCoinInfo
import com.xecoding.xcrypto.common.NetworkResource
import com.xecoding.xcrypto.domain.model.CoinInfo
import com.xecoding.xcrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinInfoUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<NetworkResource<CoinInfo>> = flow {
        try {
            emit(NetworkResource.Loading())
            val coinInfo = coinRepository.getCoinInfo(coinId).toCoinInfo()
            emit(NetworkResource.Success(data = coinInfo))
        } catch (e: Exception) {
            emit(NetworkResource.Error(message = e.message.toString()))
        }
    }

}