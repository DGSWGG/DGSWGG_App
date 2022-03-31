package kr.hs.dgsw.presentation.ui.adapter.viewholder.search

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kr.hs.dgsw.presentation.databinding.ItemSearchBinding
import kr.hs.dgsw.presentation.ui.uimodel.SearchUIModel
import kr.hs.dgsw.utils.Constants.IMAGE_URL

class SearchItemViewHolder(
    private val binding: ItemSearchBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(searchModel: SearchUIModel.SearchModel, onClickDelete: (Long) -> Unit) {
        with(searchModel) {
            binding.tvSummonerNameItemSearch.text = search.summonerName
            binding.ivProfileImageItemSearch.load("${IMAGE_URL}profileicon/${search.profileIconId}.png")
            binding.ibRemoveItemSearch.setOnClickListener {
                onClickDelete.invoke(search.id)
            }
        }
    }
}