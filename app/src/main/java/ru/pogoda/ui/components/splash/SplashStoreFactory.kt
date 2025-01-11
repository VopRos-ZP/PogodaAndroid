package ru.pogoda.ui.components.splash

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory

class SplashStoreFactory(
    private val storeFactory: StoreFactory,
    private val context: Context
) {

    fun create(): SplashStore = object : SplashStore, Store<Splash.Intent, Splash.State, Splash.Label> by storeFactory.create(
        name = "SplashStore",
        initialState = Splash.State(),
        executorFactory = coroutineExecutorFactory {
            onIntent<Splash.Intent.CheckPermissions> {
                publish(Splash.Label.OnGetPermission(
                    ContextCompat.checkSelfPermission(
                        context, Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ))
            }
        },
        reducer = { this }
    ) {}

}