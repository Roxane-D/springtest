package com.springtest.springtest.dao;

import java.util.List;

import com.springtest.springtest.model.Player;

public interface PlayerDao {
    List<Player> findAll();

    Player findById(int id);

    Player save(Player player);

    boolean delete(int id);
}