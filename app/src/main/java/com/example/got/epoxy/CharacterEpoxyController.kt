package com.example.got.epoxy

import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import coil.load
import com.airbnb.epoxy.TypedEpoxyController
import com.example.got.R
import com.example.got.ViewBindingKotlinModel
import com.example.got.databinding.ModelCharacterListItemBinding
import com.example.got.model.domain.Characters
import kotlinx.coroutines.delay

class CharacterEpoxyController: TypedEpoxyController<List<Characters>>() {
    override fun buildModels(data: List<Characters>?) {

        if (data == null || data.isEmpty()){
            repeat(8){
                val epoxyId = it + 1
                CharacterEpoxymodel(characters = null).id(epoxyId).addTo(this)
            }
            return
        }

        data.forEach { characters ->
            CharacterEpoxymodel(characters).id(characters.id).addTo(this)

        }
    }

    data class CharacterEpoxymodel(
        val characters: Characters?
    ): ViewBindingKotlinModel<ModelCharacterListItemBinding>(R.layout.model_character_list_item){

        override fun ModelCharacterListItemBinding.bind() {
            shimmerViewContainer.isVisible = false
            cardView.isInvisible = false
            characters?.let {characters ->
                shimmerViewContainer.stopShimmer()
                characterImageView.load(data = characters.imageUrl)
                characterNameTextView.text = characters.fullName

            } ?: shimmerViewContainer.startShimmer()

        }

    }



}