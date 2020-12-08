package com.springtest.springtest.web.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    @RequestMapping(value = "/Players", method = RequestMethod.GET)
    public String PlayersList() {
        return "Une bien belle liste";
    }

//    @RequestMapping(value = "/Players/{id}", method = RequestMethod.GET)
    @GetMapping(value = "Players/{id}")
    public String PlayerDisplay(@PathVariable int id) {
        return "Un joueur " + id;
    }
}
