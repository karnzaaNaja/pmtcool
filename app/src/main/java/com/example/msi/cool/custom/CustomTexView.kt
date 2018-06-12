package com.example.msi.cool.custom

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

class CustomTexView : AppCompatTextView {
    constructor(context: Context) : super(context){
        setup()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        setup()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        setup()
    }

    private fun setup() {
        paintFlags = getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG
    }
}