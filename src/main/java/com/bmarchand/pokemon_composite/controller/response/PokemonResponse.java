package com.bmarchand.pokemon_composite.controller.response;

import com.bmarchand.pokemon_composite.service.domain.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PokemonResponse {

    List<Pokemon> pokemonTeam;
}
