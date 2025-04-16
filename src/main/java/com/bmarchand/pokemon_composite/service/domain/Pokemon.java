package com.bmarchand.pokemon_composite.service.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Pokemon {

    private String name;
    private List<PokemonType> types;
    private List<PokemonCapacities> capacities;
}
