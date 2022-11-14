package com.xecoding.xcrypto.domain.use_cases

import com.xecoding.xcrypto.common.Helpers.toCoin
import com.xecoding.xcrypto.common.NetworkResource
import com.xecoding.xcrypto.domain.model.Coin
import com.xecoding.xcrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<NetworkResource<List<Coin>>> = flow {
        try {
            emit(NetworkResource.Loading())
            val allCoins = coinRepository.getCoinList().map { it.toCoin() }
            emit(NetworkResource.Success(allCoins))
        } catch (e: Exception) {
            emit(NetworkResource.Error(message = e.message.toString()))
        }
    }
}