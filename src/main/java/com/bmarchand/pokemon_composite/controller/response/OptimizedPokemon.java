package com.bmarchand.pokemon_composite.controller.response;

import com.bmarchand.pokemon_composite.service.domain.PokemonCapacities;
import com.bmarchand.pokemon_composite.service.domain.PokemonType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OptimizedPokemon {

    private String name;
    private List<PokemonType> allTypes;
    private List<PokemonCapacities> allCapacities;
}
