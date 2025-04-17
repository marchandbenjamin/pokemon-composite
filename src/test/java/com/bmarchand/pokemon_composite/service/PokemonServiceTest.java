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
import java.util.stream.Stream;

@SpringBootTest
class PokemonServiceTest {

    @Autowired
    private PokemonService pokemonService;

    @Test
    void pokemonTeamOptimizer_should_return_pikachu_type_and_capacities() {
        // GIVEN
        String pikachu = "Pikachu";
        List<String> pokemonList = List.of(pikachu);

        // WHEN
        PokemonResponse pokemonResponse = pokemonService.pokemonTeamOptimizer(pokemonList);

        // ASSERT
        List<PokemonCapacities> expectedCapacities = Stream.of(
                PokemonCapacities.THUNDER_SHOCK,
                PokemonCapacities.GROWL,
                PokemonCapacities.QUICK_ATTACK,
                PokemonCapacities.THUNDERBOLT,
                PokemonCapacities.THUNDER,
                PokemonCapacities.SWIFT,
                PokemonCapacities.DOUBLE_TEAM,
                PokemonCapacities.REST
        ).sorted().toList();

        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pokemon.getName(), pikachu);
        Assertions.assertEquals(pokemon.getAllPossibleTypes(), List.of(PokemonType.ELECTRIC));
        Assertions.assertEquals(expectedCapacities, pokemon.getAllPossibleCapacities()
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
        List<PokemonCapacities> expectedCapacities = Stream.of(
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
        ).sorted().toList();

        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pokemon.getName(), raichu);
        Assertions.assertEquals(pokemon.getAllPossibleTypes(), List.of(PokemonType.ELECTRIC));
        Assertions.assertEquals(expectedCapacities, pokemon.getAllPossibleCapacities()
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
        List<PokemonCapacities> expectedCapacities = Stream.of(
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
        ).sorted().toList();

        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pokemon.getName(), aquali);
        Assertions.assertEquals(pokemon.getAllPossibleTypes(),
                List.of(PokemonType.NORMAL, PokemonType.WATER));
        Assertions.assertEquals(expectedCapacities, pokemon.getAllPossibleCapacities()
        );

    }

    @Test
    void pokemonTeamOptimizer_should_return_dracaufeu_reptincel_and_salameche_types_and_capacities() {
        // GIVEN
        String dracaufeu = "Dracaufeu";
        List<String> pokemonList = List.of(dracaufeu);

        // WHEN
        PokemonResponse pokemonResponse = pokemonService.pokemonTeamOptimizer(pokemonList);

        // ASSERT
        List<PokemonCapacities> expectedCapacities = Stream.of(
                PokemonCapacities.EMBER,
                PokemonCapacities.FIRE_BLAST,
                PokemonCapacities.FIRE_SPIN,
                PokemonCapacities.FLAMETHROWER,
                PokemonCapacities.GROWL,
                PokemonCapacities.LEER,
                PokemonCapacities.RAGE,
                PokemonCapacities.SCARY_FACE,
                PokemonCapacities.SCRATCH,
                PokemonCapacities.SLASH,
                PokemonCapacities.SMOKESCREEN,
                PokemonCapacities.WING_ATTACK
        ).sorted().toList();

        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pokemon.getName(), dracaufeu);
        Assertions.assertEquals(pokemon.getAllPossibleTypes(),
                List.of(PokemonType.FIRE, PokemonType.FLYING));
        Assertions.assertEquals(expectedCapacities, pokemon.getAllPossibleCapacities()
        );
    }

    @Test
    void pokemonTeamOptimizer_should_return_magby_and_magmar_type_and_capacities() {
        // GIVEN
        String magmar = "Magmar";
        List<String> pokemonList = List.of(magmar);

        // WHEN
        PokemonResponse pokemonResponse = pokemonService.pokemonTeamOptimizer(pokemonList);

        // ASSERT
        List<PokemonCapacities> expectedCapacities = Stream.of(
                PokemonCapacities.CONFUSE_RAY,
                PokemonCapacities.EMBER,
                PokemonCapacities.FIRE_PUNCH,
                PokemonCapacities.FIRE_SPIN,
                PokemonCapacities.LEER,
                PokemonCapacities.SMOKESCREEN
        ).sorted().toList();

        Assertions.assertNotNull(pokemonResponse.getPokemonTeam());
        Pokemon pokemon = pokemonResponse.getPokemonTeam().getFirst();
        Assertions.assertEquals(pokemon.getName(), magmar);
        Assertions.assertEquals(pokemon.getAllPossibleTypes(), List.of(PokemonType.FIRE));
        Assertions.assertEquals(expectedCapacities, pokemon.getAllPossibleCapacities()
        );
    }
}