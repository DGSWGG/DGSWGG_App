package kr.hs.dgsw.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.presentation.ui.util.SingleLiveEvent

class HomeViewModel : ViewModel() {

    private val _searchBtn = SingleLiveEvent<Unit>()
    val searchBtn: LiveData<Unit> = _searchBtn

    fun onClickSearch() {
        _searchBtn.call()
    }
}