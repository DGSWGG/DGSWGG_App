package kr.hs.dgsw.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.datasource.search.SearchDataSource
import kr.hs.dgsw.data.database.paging.SearchPagingSource
import kr.hs.dgsw.data.repository.SearchRepositoryImpl
import kr.hs.dgsw.domain.repository.SearchRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideSearchRepository(searchDataSource: SearchDataSource): SearchRepository {
        return SearchRepositoryImpl(searchDataSource)
    }
}