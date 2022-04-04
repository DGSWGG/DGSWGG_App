package kr.hs.dgsw.presentation.ui.databinding

import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("android:onEditorAction")
fun EditText.onEditorAction(onEditorAction: () -> Unit) {
    this.setOnEditorActionListener { v, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            onEditorAction()
        }
        false
    }
}

@BindingAdapter("android:onClickNavigation")
fun Toolbar.onClickNavigation(onClickNavigation: () -> Unit) {
    this.setNavigationOnClickListener {
        onClickNavigation()
    }
}

@BindingAdapter("android:image")
fun ImageView.loadImage(url: Any) {
    load(url)
}