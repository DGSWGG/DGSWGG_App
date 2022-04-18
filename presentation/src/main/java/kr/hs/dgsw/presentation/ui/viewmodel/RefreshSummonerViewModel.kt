package kr.hs.dgsw.presentation.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.hs.dgsw.domain.usecase.summoner.PostRefreshSummonerInfoUseCase
import javax.inject.Inject

@HiltViewModel
class RefreshSummonerViewModel @Inject constructor(
    private val postRefreshSummonerInfoUseCase: PostRefreshSummonerInfoUseCase
): ViewModel() {
    val name = ObservableField("")
    val grade = ObservableField(0)
    val klass = ObservableField(0)
    val number = ObservableField(0)
    val summonerName = ObservableField("")

    fun postRefreshSummonerInfo() {
        val name = name.get()!!
        val grade = grade.get()!!
        val klass = klass.get()!!
        val number = number.get()!!
        val summonerName = summonerName.get()!!
        viewModelScope.launch {
            val params = PostRefreshSummonerInfoUseCase.Params(
                grade, klass, number, name, summonerName
            )
            postRefreshSummonerInfoUseCase.buildParamsUseCase(params)
        }
    }
}