package com.t5application

import android.app.Application
import com.t5application.database.adventureDB.AdventureRepository
import com.t5application.database.encounterDB.EncounterRepository
import com.t5application.database.npcDB.NPCRepository
import com.t5application.database.townDB.TownRepository

class T5Application : Application() {

    override fun onCreate() {
        super.onCreate()
        TownRepository.initialize(this)
        NPCRepository.initialize(this)
        EncounterRepository.initialize(this)
        AdventureRepository.initialize(this)
    }

}