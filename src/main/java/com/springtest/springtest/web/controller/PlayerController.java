package com.springtest.springtest.web.controller;

import com.springtest.springtest.dao.PlayerDao;
import com.springtest.springtest.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class PlayerController {

    @Autowired
    private PlayerDao playerDao;

    @GetMapping(value = "Players")
    public ResponseEntity<List<Player>> Index() {
        return ResponseEntity.ok(playerDao.findAll());
    }

    @GetMapping(value = "Players/{id}")
    public ResponseEntity<Player> Store(@PathVariable int id) {
        return ResponseEntity.ok(
                Objects.requireNonNull(
                        playerDao.findById(id)
                                .orElse(null)
                ));
    }

    @PostMapping(value = "/Players")
    public ResponseEntity<Void> Create(@RequestBody Player player) {

        Player playerAdded = playerDao.save(player);

        if (playerAdded == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(playerAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "Players/{id}")
    public ResponseEntity<Void> Update(@RequestBody Player player) {
        playerDao.update(player);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping(value = "Players/{id}")
    public ResponseEntity<Void> Delete(@PathVariable int id) {
        playerDao.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
