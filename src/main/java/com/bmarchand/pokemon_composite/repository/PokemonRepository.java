package com.bmarchand.pokemon_composite.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import com.bmarchand.pokemon_composite.service.domain.Pokemon;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PokemonRepository {

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

    public Object pokemonTeamOptimizer() {
        return null;
    }
}
