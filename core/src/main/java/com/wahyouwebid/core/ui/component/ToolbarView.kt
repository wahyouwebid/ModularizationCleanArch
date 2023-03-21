package com.wahyouwebid.core.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.wahyouwebid.core.R
import com.wahyouwebid.core.databinding.ComponentToolbarBinding
import com.wahyouwebid.core.utils.extension.hide
import com.wahyouwebid.core.utils.extension.show

class ToolbarView(
    context: Context,
    attributeSet: AttributeSet? = null,
) : ConstraintLayout(context, attributeSet) {

    private var showNavigate: Boolean = true

    private val binding: ComponentToolbarBinding = ComponentToolbarBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        attributeSet?.let {
            context.theme.obtainStyledAttributes(
                it,
                R.styleable.ToolbarView,
                0,
                0
            ).apply {
                try {
                    showNavigate = getBoolean(R.styleable.ToolbarView_showNavigate, false)
                } finally {
                    setDefault(showNavigate)
                    recycle()
                }
            }
        }
    }

    private fun setDefault(showNavigate: Boolean) = with(binding){
        if (showNavigate) {
            clBack.show()
        } else {
            clBack.hide()
        }
    }

    fun setToolbar(title: String?, ) = with(binding) {
        tvToolbar.text = title
    }

    fun setBack(onClick:() -> Unit) = with(binding){
        clBack.setOnClickListener {
            onClick.invoke()
        }
    }
}