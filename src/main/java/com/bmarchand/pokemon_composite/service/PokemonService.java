package com.bmarchand.pokemon_composite.service;

import com.bmarchand.pokemon_composite.controller.response.OptimizedPokemon;
import com.bmarchand.pokemon_composite.controller.response.PokemonResponse;
import com.bmarchand.pokemon_composite.service.domain.Pokemon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final Map<String, Pokemon> pokemonDatabase = new HashMap<>();
    private static final ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources("classpath:data/*.json");

            for (Resource resource : resources) {
                List<Pokemon> pokemonList = mapper.readValue(resource.getInputStream(), new TypeReference<List<Pokemon>>() {
                });

                for (Pokemon pokemon : pokemonList) {
                    pokemonDatabase.put(pokemon.getName().toLowerCase(), pokemon);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Pokémon data from JSON", e);
        }
    }

    public PokemonResponse pokemonTeamOptimizer(List<String> pokemonList) {
        List<OptimizedPokemon> optimizedPokemonList = new ArrayList<>();
        pokemonList.forEach(pokemonName -> {
            Pokemon pokemon = pokemonDatabase.get(pokemonName.toLowerCase());
            if (pokemon != null) {
                optimizedPokemonList.add(
                        OptimizedPokemon.builder()
                                .name(pokemon.getName())
                                .allCapacities(pokemon.getAllPossibleCapacities())
                                .allTypes(pokemon.getAllPossibleTypes())
                                .build()
                );
            }
        });

        return new PokemonResponse(optimizedPokemonList);
    }
}
