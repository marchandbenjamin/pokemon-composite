package com.bmarchand.pokemon_composite.controller;

import com.bmarchand.pokemon_composite.controller.response.PokemonResponse;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bmarchand.pokemon_composite.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/optimizePokemonTeam")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<PokemonResponse> pokemonTeamOptimizer(@RequestBody List<String> pokemonList) {
        return ResponseEntity.ok(pokemonService.pokemonTeamOptimizer(pokemonList));
    }
}
