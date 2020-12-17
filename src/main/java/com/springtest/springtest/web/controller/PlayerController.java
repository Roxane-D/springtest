package com.springtest.springtest.web.controller;

import com.springtest.springtest.model.Player;
import com.springtest.springtest.model.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(value = "/Players")
    public Iterable<Player> Index() {
        return playerRepository.findAll();
    }

    @GetMapping(value = "/Players/{id}")
    public Optional<Player> Store(@PathVariable int id) {
        Optional<Player> player = playerRepository.findById(id);
        return player;
    }

    @PostMapping(value = "/Players")
    public ResponseEntity<Void> Create(@RequestBody Player player) {
        playerRepository.save(player);
        if (player == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(player.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "Players/{id}")
    public String Update(@RequestBody Player player) {
        playerRepository.save(player);
        return "Updated";
    }

    @DeleteMapping(value = "/Players/{id}")
    public String Delete(@PathVariable int id) {
        playerRepository.deleteById(id);
        return "Deleted";
    }
}
