package org.example;

public class Game {
    private Adventure adventure;

    public Game() {
        UserInterface ui = new UserInterface();
        Map map = new Map();
        Player player = new Player(map, ui); // Tilføj UserInterface som argument
        adventure = new Adventure(ui, map, player);
    }

    public void start() {
        adventure.start();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
