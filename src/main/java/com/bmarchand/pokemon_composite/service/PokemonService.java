package com.bmarchand.pokemon_composite.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.bmarchand.pokemon_composite.repository.PokemonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public Object pokemonTeamOptimizer(List<String> pokemonList) {
        // Do logic
        return pokemonRepository.pokemonTeamOptimizer();
    }
}
