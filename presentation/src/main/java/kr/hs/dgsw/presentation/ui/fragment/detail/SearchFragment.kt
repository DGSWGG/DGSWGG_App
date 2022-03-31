package kr.hs.dgsw.presentation.ui.fragment.detail

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.hs.dgsw.presentation.R
import kr.hs.dgsw.presentation.databinding.FragmentSearchBinding
import kr.hs.dgsw.presentation.ui.adapter.SearchHistoryAdapter
import kr.hs.dgsw.presentation.ui.adapter.itemdecoration.SearchDividerItemDecoration
import kr.hs.dgsw.presentation.ui.viewmodel.DetailViewModel
import kr.hs.dgsw.presentation.ui.viewmodel.SearchViewModel
import kr.hs.dgsw.presentation.util.bindings
import kr.hs.dgsw.presentation.util.dp

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchHistoryAdapter by lazy { SearchHistoryAdapter() }
    private val binding: FragmentSearchBinding by bindings(FragmentSearchBinding::inflate)
    private val activityViewModel: DetailViewModel by activityViewModels()
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.vm = viewModel
        binding.activityVm = activityViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        listener()
        observe()
        flow()
    }

    private fun flow() {
        lifecycleScope.launch {
            searchHistoryAdapter.loadStateFlow
                .collect {
                    binding.rvHistorySearch.smoothScrollToPosition(0)
                    if (it.source.refresh is LoadState.NotLoading && searchHistoryAdapter.itemCount <= 1) {
                        binding.rvHistorySearch.visibility = View.GONE
                        binding.tvHistoryNothingItemSearch.visibility = View.VISIBLE
                    } else {
                        binding.rvHistorySearch.visibility = View.VISIBLE
                        binding.tvHistoryNothingItemSearch.visibility = View.GONE
                    }
                }
        }
    }

    private fun init() {
        binding.vm = viewModel
        viewModel.getAllSearch()
        binding.rvHistorySearch.adapter = searchHistoryAdapter
        binding.rvHistorySearch.addItemDecoration(
            SearchDividerItemDecoration(
                Color.valueOf(getColor(requireContext(), R.color.line)),
                15.dp
            )
        )
    }

    private fun listener() {
        searchHistoryAdapter.onClickDeleteSearch = {
            activityViewModel.deleteSearch(it)
        }

        searchHistoryAdapter.onClickDeleteAllSearch = {
            activityViewModel.deleteAllSearch()
        }
    }

    private fun observe() {
        viewModel.search.observe(viewLifecycleOwner) {
            searchHistoryAdapter.submitData(lifecycle, it)
        }
        activityViewModel.refresh.observe(viewLifecycleOwner) {
            searchHistoryAdapter.refresh()
        }
        viewModel.eventFinishActivity.observe(viewLifecycleOwner) {
            requireActivity().finish()
        }
    }
}