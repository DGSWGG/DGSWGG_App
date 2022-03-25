package kr.hs.dgsw.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.hs.dgsw.presentation.databinding.ActivitySearchBinding
import kr.hs.dgsw.presentation.ui.viewmodel.SearchViewModel
import kr.hs.dgsw.presentation.util.bindings

class SearchActivity : AppCompatActivity() {

    private val binding: ActivitySearchBinding by bindings(ActivitySearchBinding::inflate)
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.vm = viewModel
    }
}