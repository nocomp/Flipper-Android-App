package com.flipperdevices.debug.impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.flipperdevices.bridge.synchronization.api.SynchronizationApi
import com.flipperdevices.core.di.ComponentHolder
import com.flipperdevices.core.navigation.requireRouter
import com.flipperdevices.core.ui.ComposeFragment
import com.flipperdevices.debug.impl.compose.ComposableDebugScreen
import com.flipperdevices.debug.impl.di.DebugComponent
import com.flipperdevices.debug.impl.viewmodel.DebugViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class DebugScreenFragment : ComposeFragment() {

    @Inject
    lateinit var synchronizationApi: SynchronizationApi

    private val debugViewModel: DebugViewModel by viewModels()

    init {
        ComponentHolder.component<DebugComponent>().inject(this)
    }

    @Composable
    override fun RenderView() {
        ComposableDebugScreen(goToStressTest = {
            requireRouter().navigateTo(FragmentScreen { StressTestFragment() })
        }, startSynchronization = {
            synchronizationApi.startSynchronization(force = true)
        }, sendAlarmToFlipper = {
            debugViewModel.sendAlarmToFlipper()
        })
    }
}
