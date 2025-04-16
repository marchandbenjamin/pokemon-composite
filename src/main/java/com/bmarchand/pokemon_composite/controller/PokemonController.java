package com.bmarchand.pokemon_composite.controller;

import com.bmarchand.pokemon_composite.controller.response.PokemonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bmarchand.pokemon_composite.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/optimizePokemonTeam")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<PokemonResponse> pokemonTeamOptimizer(List<String> pokemonList) {
        return ResponseEntity.ok(pokemonService.pokemonTeamOptimizer(pokemonList));
    }
}
