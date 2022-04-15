package kr.hs.dgsw.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import kr.hs.dgsw.presentation.R
import kr.hs.dgsw.presentation.databinding.ActivityRefreshSummonerBinding
import kr.hs.dgsw.presentation.ui.adapter.SpinnerArrayAdapter
import kr.hs.dgsw.presentation.util.bindings

class RefreshSummonerActivity : AppCompatActivity() {

    private val binding: ActivityRefreshSummonerBinding by bindings(ActivityRefreshSummonerBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gradeAdapter = SpinnerArrayAdapter(
            this,
            R.layout.enabled_spinner_dropdown_item,
            R.array.grade
        )

        val classAdapter = SpinnerArrayAdapter(
            this,
            R.layout.enabled_spinner_dropdown_item,
            R.array.klass
        )

        val numberAdapter = SpinnerArrayAdapter(
            this,
            R.layout.enabled_spinner_dropdown_item,
            R.array.number
        )

        binding.spinnerSummonerGradeRefreshSummoner.adapter = gradeAdapter
        binding.spinnerSummonerClassRefreshSummoner.adapter = classAdapter
        binding.spinnerSummonerNumberRefreshSummoner.adapter = numberAdapter
    }
}