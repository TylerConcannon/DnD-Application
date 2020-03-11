package com.t5application.character_classes.backgrounds

class Criminal: Background() {

    override var DECEPTION: Boolean
        get() = true
        set(value) {}
    override var STEALTH: Boolean
        get() = true
        set(value) {}
}