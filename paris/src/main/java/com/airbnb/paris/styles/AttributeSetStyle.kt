package com.airbnb.paris.styles

import android.annotation.*
import android.content.*
import android.util.*
import com.airbnb.paris.*
import com.airbnb.paris.typed_array_wrappers.*
import java.lang.*

data class AttributeSetStyle constructor(private val attributeSet: AttributeSet) : Style {

    /**
     * Android framework views apply value from [AttributeSet] themselves, and each @Styleable view
     * is responsible for applying the [AttributeSet] to itself, so never apply parents
     */
    override val shouldApplyParent = false

    override fun name(context: Context): String =
            throw UnsupportedOperationException("Style names are meant to be used in a debug context and never for AttributeSetStyle")

    @SuppressLint("Recycle")
    override fun obtainStyledAttributes(context: Context, attrs: IntArray): TypedArrayWrapper =
            TypedArrayTypedArrayWrapper(context.obtainStyledAttributes(attributeSet, attrs, 0, 0))
}
