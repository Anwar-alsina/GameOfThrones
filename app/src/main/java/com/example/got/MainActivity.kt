package com.example.got

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.got.databinding.ActivityMainBinding
import com.example.got.epoxy.CharacterEpoxyController
import com.example.got.model.domain.Characters
import com.example.got.model.mapper.CharacterMapper
import com.example.got.network.CharacterService
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var charactersService: CharacterService

    @Inject
    lateinit var characterMapper: CharacterMapper

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val controller = CharacterEpoxyController()
        binding.epoxyRecyclerview.setController(controller)
        controller.setData(emptyList())


        lifecycleScope.launchWhenStarted {
            val response = charactersService.getAllCharacters()
            val domainCharacters : List<Characters> = response.body()!!.map {
                characterMapper.buildFrom(networkCharacters = it)
            }
            controller.setData(domainCharacters)
        }
    }
}

