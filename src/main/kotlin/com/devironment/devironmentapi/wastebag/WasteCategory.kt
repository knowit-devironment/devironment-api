package com.devironment.devironmentapi.wastebag

import java.beans.PropertyEditorSupport

enum class WasteCategory {
    FOOD, PLASTIC, MSW, GLASS_METAL, ELECTRONICS
}

class WasteCategoryConverter : PropertyEditorSupport() {

    @Throws(IllegalArgumentException::class)
    override fun setAsText(text: String) {
        value = WasteCategory.valueOf(text.toUpperCase())
    }

}