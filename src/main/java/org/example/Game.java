package org.example;

public class Game {
    private Adventure adventure;

    public Game() {
        UserInterface ui = new UserInterface();
        Map map = new Map();
        Player player = new Player(map);
        adventure = new Adventure(ui, map, player);
    }

    public void start() {
        adventure.start();
    }
}
