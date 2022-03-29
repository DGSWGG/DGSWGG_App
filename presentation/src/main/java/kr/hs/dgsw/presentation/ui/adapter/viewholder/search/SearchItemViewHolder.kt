package kr.hs.dgsw.presentation.ui.adapter.viewholder.search

import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.presentation.databinding.ItemSearchBinding
import kr.hs.dgsw.presentation.ui.uimodel.SearchUIModel

class SearchItemViewHolder(
    private val binding: ItemSearchBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(searchModel: SearchUIModel.SearchModel) {
        with(searchModel) {
            binding.tvSummonerNameItemSearch.text = search.summonerName
        }
    }
}