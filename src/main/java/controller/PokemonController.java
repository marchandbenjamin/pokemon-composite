package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/optimizePokemonTeam")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public Object pokemonTeamOptimizer(List<String> pokemonList) {
        return pokemonService.pokemonTeamOptimizer(pokemonList);
    }
}
