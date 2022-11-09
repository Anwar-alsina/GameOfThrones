package com.example.got.epoxy

import coil.load
import com.airbnb.epoxy.TypedEpoxyController
import com.example.got.R
import com.example.got.ViewBindingKotlinModel
import com.example.got.databinding.ModelCharacterListItemBinding
import com.example.got.model.domain.Characters

class CharacterEpoxyController: TypedEpoxyController<List<Characters>>() {
    override fun buildModels(data: List<Characters>?) {

        if (data == null || data.isEmpty()){
            //todo error state
            return
        }

        data.forEach { characters ->
            CharacterEpoxymodel(characters).id(characters.id).addTo(this)

        }
    }

    data class CharacterEpoxymodel(
        val characters: Characters
    ): ViewBindingKotlinModel<ModelCharacterListItemBinding>(R.layout.model_character_list_item){
        override fun ModelCharacterListItemBinding.bind() {
            characterImageView.load(data = characters.imageUrl)
            characterNameTextView.text = characters.fullName
        }

    }



}