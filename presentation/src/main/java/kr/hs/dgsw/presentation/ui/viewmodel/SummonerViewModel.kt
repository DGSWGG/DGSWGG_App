package kr.hs.dgsw.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import kr.hs.dgsw.domain.entity.summoner.Summoner

class SummonerViewModel : ViewModel() {
    lateinit var summoner: Summoner
}