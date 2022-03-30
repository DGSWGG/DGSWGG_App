package kr.hs.dgsw.presentation.ui.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.hs.dgsw.presentation.R
import kr.hs.dgsw.presentation.databinding.ActivitySearchBinding
import kr.hs.dgsw.presentation.ui.adapter.SearchHistoryAdapter
import kr.hs.dgsw.presentation.ui.adapter.itemdecoration.SearchDividerItemDecoration
import kr.hs.dgsw.presentation.ui.viewmodel.SearchViewModel
import kr.hs.dgsw.presentation.util.bindings
import kr.hs.dgsw.presentation.util.dp

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val searchHistoryAdapter by lazy { SearchHistoryAdapter() }
    private val binding: ActivitySearchBinding by bindings(ActivitySearchBinding::inflate)
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
        observe()
        flow()
    }

    private fun flow() {
        lifecycleScope.launch {
            searchHistoryAdapter.loadStateFlow
                .collect {
                    binding.rvHistorySearch.smoothScrollToPosition(0)
                }
        }
    }

    private fun init() {
        binding.vm = viewModel
        viewModel.getAllSearch()
        binding.rvHistorySearch.adapter = searchHistoryAdapter
        binding.rvHistorySearch.addItemDecoration(
            SearchDividerItemDecoration(
                Color.valueOf(getColor(R.color.line)),
                15.dp
            )
        )
    }

    private fun observe() {
        viewModel.eventFinishActivity.observe(this) {
            finish()
        }
        viewModel.search.observe(this) {
            searchHistoryAdapter.submitData(lifecycle, it)
        }
        viewModel.refresh.observe(this) {
            searchHistoryAdapter.refresh()
        }
    }
}