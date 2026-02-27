package com.mauisiios.notehub_server.service


fun standardiseTokenCase(token: String/*TokenDto*/): String/*TokenDto*/ {
    return token.lowercase() // TODO: Change when TokenDto is created
}