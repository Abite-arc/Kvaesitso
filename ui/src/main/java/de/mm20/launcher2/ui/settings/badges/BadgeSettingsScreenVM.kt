package de.mm20.launcher2.ui.settings.badges

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import de.mm20.launcher2.preferences.LauncherDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BadgeSettingsScreenVM : ViewModel(), KoinComponent {

    private val dataStore: LauncherDataStore by inject()

    val notifications = dataStore.data.map { it.badges.notifications }.asLiveData()
    fun setNotifications(notifications: Boolean) {
        viewModelScope.launch {
            dataStore.updateData {
                it.toBuilder()
                    .setBadges(
                        it.badges.toBuilder()
                            .setNotifications(notifications)
                    )
                    .build()
            }
        }
    }

    val cloudFiles = dataStore.data.map { it.badges.cloudFiles }.asLiveData()
    fun setCloudFiles(cloudFiles: Boolean) {
        viewModelScope.launch {
            dataStore.updateData {
                it.toBuilder()
                    .setBadges(
                        it.badges.toBuilder()
                            .setCloudFiles(cloudFiles)
                    )
                    .build()
            }
        }
    }

    val shortcuts = dataStore.data.map { it.badges.shortcuts }.asLiveData()
    fun setShortcuts(shortcuts: Boolean) {
        viewModelScope.launch {
            dataStore.updateData {
                it.toBuilder()
                    .setBadges(
                        it.badges.toBuilder()
                            .setShortcuts(shortcuts)
                    )
                    .build()
            }
        }
    }

    val suspendedApps = dataStore.data.map { it.badges.suspendedApps }.asLiveData()
    fun setSuspendedApps(suspendedApps: Boolean) {
        viewModelScope.launch {
            dataStore.updateData {
                it.toBuilder()
                    .setBadges(
                        it.badges.toBuilder()
                            .setSuspendedApps(suspendedApps)
                    )
                    .build()
            }
        }
    }
}