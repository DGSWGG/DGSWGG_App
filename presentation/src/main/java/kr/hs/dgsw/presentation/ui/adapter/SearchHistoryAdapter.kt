package kr.hs.dgsw.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.entity.Search
import kr.hs.dgsw.presentation.databinding.HeaderSearchBinding
import kr.hs.dgsw.presentation.databinding.ItemSearchBinding
import kr.hs.dgsw.presentation.ui.adapter.viewholder.search.SearchHeaderViewHolder
import kr.hs.dgsw.presentation.ui.adapter.viewholder.search.SearchItemViewHolder

class SearchHistoryAdapter: PagingDataAdapter<Search, RecyclerView.ViewHolder>(diffUtil) {

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> SEARCH_HEADER
            else -> SEARCH_ITEM
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is SearchItemViewHolder -> getItem(position)?.let { holder.bind(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            SEARCH_HEADER -> SearchHeaderViewHolder(
                HeaderSearchBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            SEARCH_ITEM -> SearchItemViewHolder(
                ItemSearchBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("잘못된 수")
        }
    }

    companion object {
        private const val SEARCH_HEADER = 0
        private const val SEARCH_ITEM = 1
        private val diffUtil = object: DiffUtil.ItemCallback<Search>() {
            override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}