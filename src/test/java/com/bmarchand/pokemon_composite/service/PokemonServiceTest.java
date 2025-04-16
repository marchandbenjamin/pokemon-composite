package com.bmarchand.pokemon_composite.service;

import com.bmarchand.pokemon_composite.controller.response.PokemonResponse;
import com.bmarchand.pokemon_composite.service.domain.Pokemon;
import com.bmarchand.pokemon_composite.service.domain.PokemonCapacities;
import com.bmarchand.pokemon_composite.service.domain.PokemonType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PokemonServiceTest {

    @Autowired
    private PokemonService pokemonService;  // Ton service réel qui utilise PokemonRepository


    @Test
    void pokemonTeamOptimizer_should_return_pikachu_type_and_capacities() {
        // GIVEN
        String pikachu = "Pikachu";
        List<String> pokemonList = List.of(pikachu);

        PokemonResponse pokemonResponse = pokemonService.pokemonTeamOptimizer(pokemonList);

        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pikachu, pokemon.getName());
        Assertions.assertEquals(List.of(PokemonType.ELECTRIC), pokemon.getTypes());
        Assertions.assertEquals(
                pokemon.getCapacities(),
                List.of(
                        PokemonCapacities.THUNDER_SHOCK,
                        PokemonCapacities.GROWL,
                        PokemonCapacities.QUICK_ATTACK,
                        PokemonCapacities.THUNDERBOLT,
                        PokemonCapacities.THUNDER,
                        PokemonCapacities.SWIFT,
                        PokemonCapacities.DOUBLE_TEAM,
                        PokemonCapacities.REST)
        );
    }
}