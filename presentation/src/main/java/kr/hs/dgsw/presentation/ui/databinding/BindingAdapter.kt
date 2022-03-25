package kr.hs.dgsw.presentation.ui.databinding

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

@BindingAdapter("android:onEditorAction")
fun EditText.onEditorAction(onEditorAction: () -> Unit) {
    this.setOnEditorActionListener { v, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            onEditorAction()
        }
        false
    }
}