package com.bmarchand.pokemon_composite.service.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EvolvedPokemon.class, name = "EvolvedPokemon"),
        @JsonSubTypes.Type(value = Pokemon.class, name = "Pokemon")
})
public class Pokemon {

    private String name;
    private List<PokemonType> types;
    private List<PokemonCapacities> capacities;

    public List<PokemonType> getAllPossibleTypes() {
        return getTypes()
                .stream()
                .sorted()
                .toList();
    }

    public List<PokemonCapacities> getAllPossibleCapacities() {
        return getCapacities()
                .stream()
                .sorted()
                .toList();
    }
}
