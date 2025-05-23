package com.example.bookshelf

import android.app.Application
import com.example.bookshelf.data.AppContainer
import com.example.bookshelf.data.DefaultAppContainer

class BookshelfApplication : Application() {
    /**AppContainer instance used by rest of classes to obtain dependencies**/
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}