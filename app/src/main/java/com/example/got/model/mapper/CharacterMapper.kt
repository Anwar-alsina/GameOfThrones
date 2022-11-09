package com.example.got.model.mapper

import com.example.got.model.domain.Characters
import com.example.got.network.NetworkCharacters
import javax.inject.Inject

class CharacterMapper @Inject constructor() {

    fun buildFrom(networkCharacters: NetworkCharacters): Characters{
        return Characters(
            fullName = networkCharacters.fullName,
            id = networkCharacters.id,
            imageUrl = networkCharacters.imageUrl,
            family = networkCharacters.family,
            firstName = networkCharacters.firstName,
            lastName = networkCharacters.lastName,
            title = networkCharacters.title,
            image = networkCharacters.image
        )
    }
}