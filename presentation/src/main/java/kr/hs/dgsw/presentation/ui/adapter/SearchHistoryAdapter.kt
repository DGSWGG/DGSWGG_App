package kr.hs.dgsw.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.presentation.databinding.ItemSearchBinding
import kr.hs.dgsw.presentation.ui.adapter.viewholder.search.SearchItemViewHolder

class SearchHistoryAdapter: PagingDataAdapter<Search, SearchItemViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        return SearchItemViewHolder(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    companion object {
        private val diffUtil = object: DiffUtil.ItemCallback<Search>() {
            override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
                return oldItem == newItem
            }

        }
    }
}