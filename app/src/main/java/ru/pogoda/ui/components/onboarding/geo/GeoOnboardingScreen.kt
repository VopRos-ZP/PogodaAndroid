package ru.pogoda.ui.components.onboarding.geo

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.pogoda.R
import ru.pogoda.ui.theme.PogodaTheme

@Composable
fun GeoOnboardingScreen(component: GeoOnboardingComponent) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) {
        when (it.all { (_, b) -> b }) {
            true -> component.onPermissionClick()
            else -> component.onCustomizeClick()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = PogodaTheme.gradients.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(0.2f))
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.logo),
            contentDescription = "Logo",
        )
        Spacer(modifier = Modifier.weight(0.1f))
        Image(
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = null,
            modifier = Modifier.size(207.dp)
        )
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            color = MaterialTheme.colorScheme.onBackground,
            text = "Приложение «pogoda.ru» запрашивает разрешение на сбор данных о местоположении, чтобы держать вас в курсе погоды в любом месте",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                onClick = {
                    launcher.launch(
                        arrayOf(
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION
                        ),
                    )
                },
            ) {
                Text(text = "Разрешить")
            }
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { component.onCustomizeClick() },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0f),
                    contentColor = MaterialTheme.colorScheme.onBackground,
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "Настроить в ручную")
            }
        }
        Spacer(modifier = Modifier.height(54.dp))
    }
}