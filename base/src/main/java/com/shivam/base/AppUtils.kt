package com.shivam.base

import java.text.SimpleDateFormat
import java.util.*

object AppUtils {

    fun DateTimeParser(before : String) : String {
        val parser = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) // the initial pattern
        val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()) // the desired output pattern

        // Put the date in the parser, convert the string to Date class
        val parse = parser.parse(before)
        return formatter.format(parse)
    }

}