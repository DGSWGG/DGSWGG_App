package kr.hs.dgsw.presentation.ui.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel() {

    val searchText = ObservableField<String>()

    fun searchSummoner(summonerName: String) {
        Log.d("SearchViewModel", "searchSummoner: $summonerName")
    }
}