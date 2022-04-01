package kr.hs.dgsw.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.database.cache.SearchCache
import kr.hs.dgsw.data.datasource.search.SearchDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun searchDataSource(searchCache: SearchCache): SearchDataSource {
        return SearchDataSource(searchCache)
    }
}