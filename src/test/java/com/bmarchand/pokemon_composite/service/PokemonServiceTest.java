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

@SpringBootTest
class PokemonServiceTest {

    @Autowired
    private PokemonService pokemonService;  // Ton service réel qui utilise PokemonRepository


    @Test
    void pokemonTeamOptimizer_should_return_pikachu_type_and_capacities() {
        // GIVEN
        String pikachu = "Pikachu";
        List<String> pokemonList = List.of(pikachu);

        // WHEN
        PokemonResponse pokemonResponse = pokemonService.pokemonTeamOptimizer(pokemonList);

        // ASSERT
        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pokemon.getName(), pikachu);
        Assertions.assertEquals(pokemon.getAllPossibleTypes(), List.of(PokemonType.ELECTRIC));
        Assertions.assertEquals(
                List.of(
                        PokemonCapacities.THUNDER_SHOCK,
                        PokemonCapacities.GROWL,
                        PokemonCapacities.QUICK_ATTACK,
                        PokemonCapacities.THUNDERBOLT,
                        PokemonCapacities.THUNDER,
                        PokemonCapacities.SWIFT,
                        PokemonCapacities.DOUBLE_TEAM,
                        PokemonCapacities.REST),
                pokemon.getAllPossibleCapacities()
        );
    }

    @Test
    void pokemonTeamOptimizer_should_return_raichu_and_pikachu_type_and_capacities() {
        // GIVEN
        String raichu = "Raichu";
        List<String> pokemonList = List.of(raichu);

        // WHEN
        PokemonResponse pokemonResponse = pokemonService.pokemonTeamOptimizer(pokemonList);

        // ASSERT
        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pokemon.getName(), raichu);
        Assertions.assertEquals(pokemon.getAllPossibleTypes(), List.of(PokemonType.ELECTRIC));
        Assertions.assertEquals(
                List.of(
                        PokemonCapacities.THUNDER_SHOCK,
                        PokemonCapacities.GROWL,
                        PokemonCapacities.QUICK_ATTACK,
                        PokemonCapacities.THUNDERBOLT,
                        PokemonCapacities.THUNDER,
                        PokemonCapacities.SWIFT,
                        PokemonCapacities.DOUBLE_TEAM,
                        PokemonCapacities.REST,
                        PokemonCapacities.THUNDER_WAVE,
                        PokemonCapacities.AGILITY
                ),
                pokemon.getAllPossibleCapacities()
        );
    }

    @Test
    void pokemonTeamOptimizer_should_return_aquali_and_evoli_types_and_capacities() {
        // GIVEN
        String aquali = "Aquali";
        List<String> pokemonList = List.of(aquali);

        // WHEN
        PokemonResponse pokemonResponse = pokemonService.pokemonTeamOptimizer(pokemonList);

        // ASSERT
        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pokemon.getName(), aquali);
        Assertions.assertEquals(pokemon.getAllPossibleTypes(),
                List.of(PokemonType.NORMAL, PokemonType.WATER));
        Assertions.assertEquals(
                List.of(
                        PokemonCapacities.GROWL,
                        PokemonCapacities.QUICK_ATTACK,
                        PokemonCapacities.TACKLE,
                        PokemonCapacities.SAND_ATTACK,
                        PokemonCapacities.TAIL_WHIP,
                        PokemonCapacities.BITE,
                        PokemonCapacities.DOUBLE_EDGE,
                        PokemonCapacities.WATER_GUN,
                        PokemonCapacities.ACID_ARMOR,
                        PokemonCapacities.AURORA_BEAM,
                        PokemonCapacities.HAZE,
                        PokemonCapacities.MIST
                ),
                pokemon.getAllPossibleCapacities()
        );

    }
}