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
    public Player PlayerDisplay(@PathVariable int id) {
        return playerDao.findById(id);
    }

    @PostMapping(value = "/Players")
    public void AddPlayer(@RequestBody Player player) {
        playerDao.save(player);
    }

    @PutMapping(value = "Players/{id}")
    public void UpdatePlayer(@PathVariable int id, @RequestBody Player player) {
        playerDao.update(id, player);
    }
}
