package com.bmarchand.pokemon_composite.service.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EvolvedPokemon extends Pokemon {

    private Pokemon preEvolution;

    @Override
    public List<PokemonType> getAllPossibleTypes() {
        List<PokemonType> allTypes = new ArrayList<>(super.getTypes());
        if (preEvolution != null) {
            allTypes.addAll(preEvolution.getAllPossibleTypes());
        }
        return allTypes
                .stream()
                .distinct()
                .sorted()
                .toList();
    }

    @Override
    public List<PokemonCapacities> getAllPossibleCapacities() {
        List<PokemonCapacities> allCapacities = new ArrayList<>(super.getCapacities());
        if (preEvolution != null) {
            allCapacities.addAll(preEvolution.getAllPossibleCapacities());
        }
        return allCapacities
                .stream()
                .sorted()
                .toList();
    }
}
