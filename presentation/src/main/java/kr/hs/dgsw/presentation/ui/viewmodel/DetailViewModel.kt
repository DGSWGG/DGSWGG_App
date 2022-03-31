package kr.hs.dgsw.presentation.ui.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.domain.usecase.search.DeleteAllSearchUseCase
import kr.hs.dgsw.domain.usecase.search.DeleteSearchUseCase
import kr.hs.dgsw.domain.usecase.search.GetAllSearchUseCase
import kr.hs.dgsw.domain.usecase.search.InsertSearchUseCase
import kr.hs.dgsw.presentation.ui.uimodel.SearchUIModel
import kr.hs.dgsw.presentation.util.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val insertSearchUseCase: InsertSearchUseCase,
    private val deleteAllSearchUseCase: DeleteAllSearchUseCase,
    private val deleteSearchUseCase: DeleteSearchUseCase
): ViewModel() {

    private val _refresh = SingleLiveEvent<Unit>()
    val refresh: LiveData<Unit> = _refresh

    fun deleteSearch(id: Long) {
        viewModelScope.launch {
            deleteSearchUseCase.buildParamsSuspendUseCase(DeleteSearchUseCase.Params(id))
        }.invokeOnCompletion {
            _refresh.call()
        }
    }

    fun deleteAllSearch() {
        viewModelScope.launch {
            deleteAllSearchUseCase.buildSuspendUseCase()
        }.invokeOnCompletion {
            _refresh.call()
        }
    }

    fun searchSummoner(searchText: String) {
        Log.d("TAG", "searchSummoner: ")
        viewModelScope.launch {
            val search = Search(profileIconId = 550, summonerName = searchText)
            insertSearchUseCase.buildParamsSuspendUseCase(InsertSearchUseCase.Params(search))
        }.invokeOnCompletion {
            _refresh.call()
        }
    }
}