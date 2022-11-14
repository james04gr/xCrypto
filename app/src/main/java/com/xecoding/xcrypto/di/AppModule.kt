package com.xecoding.xcrypto.di

import com.xecoding.xcrypto.BuildConfig
import com.xecoding.xcrypto.data.remote.api.XCryptoApi
import com.xecoding.xcrypto.data.repository.CoinRepositoryImpl
import com.xecoding.xcrypto.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun cryptApiProvider(): XCryptoApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_HOLDER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(XCryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun coinRepositoryProvider(xCryptoApi: XCryptoApi): CoinRepository {
        return CoinRepositoryImpl(xCryptoApi)
    }

}