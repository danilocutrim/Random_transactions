package com.devbeck.transactions.util

import java.util.logging.SimpleFormatter

class Util {
    companion object{
        fun formatDateTimeStyle(): String{
            return SimpleFormatter().toString()
        }
    }
}