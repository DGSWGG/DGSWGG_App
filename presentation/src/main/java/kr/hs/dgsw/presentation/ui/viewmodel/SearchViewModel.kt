package kr.hs.dgsw.presentation.ui.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.presentation.ui.util.SingleLiveEvent

class SearchViewModel: ViewModel() {

    val searchText = ObservableField<String>()

    private val _eventFinishActivity = SingleLiveEvent<Unit>()
    val eventFinishActivity: LiveData<Unit> = _eventFinishActivity

    fun searchSummoner() {
        Log.d("SearchViewModel", "searchSummoner: ${searchText.get()}")
    }

    fun finishActivity() {
        _eventFinishActivity.call()
    }
}