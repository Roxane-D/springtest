package com.springtest.springtest.web.controller;

import com.springtest.springtest.model.Player;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    @RequestMapping(value = "/Players", method = RequestMethod.GET)
    public String PlayersList() {
        return "Une bien belle liste";
    }

    @GetMapping(value = "Players/{id}")
    public Player PlayerDisplay(@PathVariable int id) {
        return new Player(id, "Sam", "Hobbit");
    }
}
