package com.persol.evkart.model.kart

import com.persol.evkart.model.location.Location

class Kart (
    var name: String? = null,
    var profilePicUrl: String? = null,
    var speedKmh: Int = 0,
    var battery: Int = 0,
    var location: Location? = null,
    var lastUpdate: Long = 0L,
    var streamingUrl: String? = null
)