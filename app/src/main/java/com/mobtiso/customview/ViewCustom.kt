package com.mobtiso.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import com.mobtiso.customview.databinding.ViewCustomBinding


class ViewCustom @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var callback: CustomViewCallback? = null
    private val binding = ViewCustomBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.withStyledAttributes(attrs, R.styleable.ViewCustom) {
            val value = getInt(R.styleable.ViewCustom_custom_value, 0)
            binding.tvValue.text = String.format(context.getString(R.string.text_value), value)
        }
        binding.btShow.setOnClickListener {
            callback?.onClick(binding.tvValue.text.toString())
        }
    }

    fun onClick(listener: CustomViewCallback) {
        callback = listener
    }
}

interface CustomViewCallback {
    fun onClick(value: String)
}

