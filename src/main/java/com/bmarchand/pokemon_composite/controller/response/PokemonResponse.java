package com.bmarchand.pokemon_composite.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PokemonResponse {

    List<OptimizedPokemon> pokemonTeam;
}
