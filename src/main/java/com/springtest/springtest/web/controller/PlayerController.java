package com.springtest.springtest.web.controller;

import com.springtest.springtest.dao.PlayerDao;
import com.springtest.springtest.model.Player;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Api(description="CRUD des players")
@RestController
public class PlayerController {

    @Autowired
    private PlayerDao playerDao;

    @ApiOperation(value="Méthode Index : affichage de tous les joueurs")
    @GetMapping(value = "Players")
    public ResponseEntity<List<Player>> Index() {
        return ResponseEntity.ok(playerDao.findAll());
    }

    @ApiOperation(value="Méthode Store : affichage d'un joueur")
    @GetMapping(value = "Players/{id}")
    public ResponseEntity<Player> Store(@PathVariable int id) {
        return ResponseEntity.ok(
                Objects.requireNonNull(
                        playerDao.findById(id)
                                .orElse(null)
                ));
    }

    @ApiOperation(value="Méthode Create : création d'un joueur")
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

    @ApiOperation(value="Méthode Update : modification d'un joueur")
    @PutMapping(value = "Players/{id}")
    public ResponseEntity<Void> Update(@RequestBody Player player) {
        playerDao.update(player);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value="Méthode Delete : suppression d'un joueur")
    @DeleteMapping(value = "Players/{id}")
    public ResponseEntity<Void> Delete(@PathVariable int id) {
        playerDao.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
