package ru.pogoda.data.repository

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import ru.pogoda.domain.repository.LocationRepository
import ru.pogoda.domain.utils.LocationUtils

class LocationRepositoryImpl(
    private val context: Context
) : LocationRepository {

    @SuppressLint("MissingPermission")
    override val currentLocation = callbackFlow {
        val manager = context.getSystemService(LocationManager::class.java)
        val listener = LocationListener {
            launch { send(it.latitude to it.longitude) }
        }
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            launch { send(LocationUtils.DEFAULT_COORDINATES) }
        } else {
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000L, 10f, listener)
        }
        awaitClose {
            manager.removeUpdates(listener)
        }
    }

}