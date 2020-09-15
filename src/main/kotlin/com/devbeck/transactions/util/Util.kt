package com.devbeck.transactions.util

import com.devbeck.transactions.db.LocalTransactions
import java.time.format.DateTimeFormatter
import java.util.logging.SimpleFormatter

class Util {
    companion object{
        fun formatDateTimeStyle(): String{
            return SimpleFormatter().toString()
        }
    }
}