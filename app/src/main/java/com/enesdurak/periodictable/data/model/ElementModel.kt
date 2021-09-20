package com.enesdurak.periodictable.data.model

import androidx.annotation.ColorRes

data class ElementModel(
    val index: Int,
    val symbol: String,
    val name: String,
    @ColorRes val backgroundColor: Int,
    @ColorRes val textColor: Int,
) : PeriodicTableModel()