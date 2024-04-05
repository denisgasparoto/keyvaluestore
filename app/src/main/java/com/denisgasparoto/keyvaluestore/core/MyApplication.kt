package com.denisgasparoto.keyvaluestore.core

import android.app.Application
import com.denisgasparoto.keyvaluestore.core.di.AppContainer

internal class MyApplication : Application() {
    val appContainer = AppContainer()
}
