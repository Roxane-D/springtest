//package com.springtest.springtest.dao;
//
//import com.springtest.springtest.model.Player;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class PlayerDaoImpl implements PlayerDao {
//
//    public static List<Player> players = new ArrayList<>();
//
//    static {
//        players.add(new Player(1, "Gandalf", "Magicien"));
//        players.add(new Player(2, "Samouram", "Magicien"));
//        players.add(new Player(3, "Theoden", "Guerrier"));
//    }
//
//    @Override
//    public List<Player> findAll() {
//        return players;
//    }
//
//    @Override
//    public Optional<Player> findById(int id) {
//        for (Player player : players) {
//            if (player.getId() == id) return Optional.of(player);
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public Player save(Player player) {
//        players.add(player);
//        return player;
//    }
//
//    @Override
//    public int update(Player player) {
//        return findById(player.getId()).map(player1 -> {
//            int playerUpdate = players.indexOf(player1);
//            if (playerUpdate >= 0) {
//                players.set(playerUpdate, new Player(player.getId(), player.getName(), player.getType()));
//                return 1;
//            }
//            return 0;
//        })
//                .orElse(0);
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return players.removeIf(
//                player -> String.valueOf(
//                        player.getId()
//                )
//                        .equals(String.valueOf(id)));
//    }
//}
