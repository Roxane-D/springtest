package com.springtest.springtest.web.controller;

import com.springtest.springtest.dao.PlayerDao;
import com.springtest.springtest.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerDao playerDao;

    @GetMapping(value = "Players")
    public List<Player> PlayerList() {
        return playerDao.findAll();
    }

    @GetMapping(value = "Players/{id}")
    public Player Index(@PathVariable int id) {
        return playerDao.findById(id);
    }

    @PostMapping(value = "/Players")
    public void Create(@RequestBody Player player) {
        playerDao.save(player);
    }

    @PutMapping(value = "Players/{id}")
    public void Update(@RequestBody Player player) {
        playerDao.save(player);
    }

    @DeleteMapping(value = "Players/{id}")
    public void Delete(@PathVariable int id) {
        playerDao.delete(id);
    }
}
