package com.springtest.springtest.dao;

import com.springtest.springtest.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    public static List<Player> players = new ArrayList<>();

    static {
        players.add(new Player(1, "Gandalf", "Magicien"));
        players.add(new Player(2, "Samouram", "Magicien"));
        players.add(new Player(3, "Theoden", "Guerrier"));
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
        Player playerToEdit = findById(player.getId());
        if (playerToEdit != null) {
            players.set(players.indexOf(playerToEdit), player);
            return player;
        }
        players.add(player);
        return player;
    }

    @Override
    public boolean delete(int id) {
        return players.removeIf( player -> String.valueOf(player.getId()).equals(String.valueOf(id)));
    }
}
