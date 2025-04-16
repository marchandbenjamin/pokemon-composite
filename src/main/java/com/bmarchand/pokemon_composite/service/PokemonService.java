package com.bmarchand.pokemon_composite.service;

import com.bmarchand.pokemon_composite.controller.response.PokemonResponse;
import com.bmarchand.pokemon_composite.service.domain.Pokemon;
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
                Pokemon pokemon = mapper.readValue(resource.getInputStream(), Pokemon.class);
                pokemonDatabase.put(pokemon.getName().toLowerCase(), pokemon);
            }
            System.out.println("✅ " + pokemonDatabase.size() + " Pokémon(s) loaded from JSON.");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Pokémon data from JSON", e);
        }
    }

    public PokemonResponse pokemonTeamOptimizer(List<String> pokemonList) {
        List<Pokemon> optimizedPokemonList = new ArrayList<Pokemon>();
        pokemonList.forEach(pokemonName -> {
            Pokemon pokemon = pokemonDatabase.get(pokemonName.toLowerCase());
            if (pokemon != null) {
                optimizedPokemonList.add(pokemon);
            }
        });

        return new PokemonResponse(optimizedPokemonList);
    }
}
