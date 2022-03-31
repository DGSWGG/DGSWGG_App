package kr.hs.dgsw.presentation.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.hs.dgsw.domain.usecase.search.GetAllSearchUseCase
import kr.hs.dgsw.presentation.ui.uimodel.SearchUIModel
import kr.hs.dgsw.presentation.util.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllSearchUseCase: GetAllSearchUseCase,
): ViewModel() {
    val searchText = ObservableField<String>()

    private val _eventFinishActivity = SingleLiveEvent<Unit>()
    val eventFinishActivity: LiveData<Unit> = _eventFinishActivity

    private val _search = MutableLiveData<PagingData<SearchUIModel>>()
    val search: LiveData<PagingData<SearchUIModel>> = _search

    fun getAllSearch() {
        viewModelScope.launch {
            getAllSearchUseCase.buildParamsUseCase(GetAllSearchUseCase.Params(10))
                .cachedIn(viewModelScope)
                .collectLatest {
                    _search.value =
                        it.map { search ->
                            SearchUIModel.SearchModel(search) as SearchUIModel
                        }.insertHeaderItem(TerminalSeparatorType.FULLY_COMPLETE, SearchUIModel.Header)
                }
        }
    }

    fun finishActivity() {
        _eventFinishActivity.call()
    }
}