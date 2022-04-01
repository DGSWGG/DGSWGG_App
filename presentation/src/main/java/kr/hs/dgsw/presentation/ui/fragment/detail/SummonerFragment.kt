package kr.hs.dgsw.presentation.ui.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import kr.hs.dgsw.presentation.R
import kr.hs.dgsw.presentation.databinding.FragmentSummonerBinding
import kr.hs.dgsw.presentation.ui.viewmodel.SearchViewModel
import kr.hs.dgsw.presentation.ui.viewmodel.SummonerViewModel
import kr.hs.dgsw.presentation.util.bindings

class SummonerFragment : Fragment() {

    private val binding: FragmentSummonerBinding by bindings(FragmentSummonerBinding::inflate)
    private val viewModel: SummonerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}