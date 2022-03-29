package kr.hs.dgsw.presentation.ui.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.domain.usecase.search.GetAllSearchUseCase
import kr.hs.dgsw.domain.usecase.search.InsertSearchUseCase
import kr.hs.dgsw.presentation.ui.util.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllSearchUseCase: GetAllSearchUseCase,
    private val insertSearchUseCase: InsertSearchUseCase
): ViewModel() {

    val searchText = ObservableField<String>()

    private val _eventFinishActivity = SingleLiveEvent<Unit>()
    val eventFinishActivity: LiveData<Unit> = _eventFinishActivity

    private val _search = MutableLiveData<PagingData<Search>>()
    val search: LiveData<PagingData<Search>> = _search

    private val _refresh = SingleLiveEvent<Unit>()
    val refresh: LiveData<Unit> = _refresh

    fun getAllSearch() {
        viewModelScope.launch {
            getAllSearchUseCase.buildParamsUseCase(GetAllSearchUseCase.Params(10))
                .cachedIn(viewModelScope)
                .collectLatest {
                    _search.value = it
                }
        }
    }

    fun searchSummoner() {
        viewModelScope.launch {
            val search = Search(profileIconId = 550, summonerName = searchText.get() ?: "")
            insertSearchUseCase.buildParamsSuspendUseCase(InsertSearchUseCase.Params(search))
        }.invokeOnCompletion {
            _refresh.call()
        }
    }

    fun finishActivity() {
        _eventFinishActivity.call()
    }
}