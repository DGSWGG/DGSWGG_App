package kr.hs.dgsw.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.presentation.R
import kr.hs.dgsw.presentation.databinding.ActivitySearchBinding
import kr.hs.dgsw.presentation.util.bindings

class SearchActivity : AppCompatActivity() {

    private val binding: ActivitySearchBinding by bindings(ActivitySearchBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}