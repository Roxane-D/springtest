package com.springtest.springtest.dao;

import com.springtest.springtest.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    public static List<Player> players = new ArrayList<>();
    static {
        players.add(new Player(1, "Gandalf", "Magicien" ));
        players.add(new Player(2, "Samouram", "Magicien" ));
        players.add(new Player(3, "Theoden", "Guerrier" ));
    }

    @Override
    public List<Player> findAll() {
        return players;
    }

    @Override
    public Player findById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    @Override
    public Player save(Player player) {
        players.add(player);
        return player;
    }

    @Override
    public Player update(int id, Player player) {
        return null;
    }
}
