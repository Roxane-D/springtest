package com.springtest.springtest.dao;

import java.util.List;

import com.springtest.springtest.model.Player;

public interface PlayerDao {
    List<Player> findAll();

    Player PlayerById(int id);

    Player PlayerSave(Player player);
}