package org.example;

public class Adventure {
    private UserInterface ui;
    private Map map;
    private Player player;

    public Adventure(UserInterface ui, Map map, Player player) {
        this.ui = ui;
        this.map = map;
        this.player = player;
    }

    public void start() {
        ui.displayMessage("Welcome to the Adventure Game!");
        ui.displayRoom(player.getCurrentRoom());

        while (true) {
            String command = ui.getUserInput().toLowerCase();

            switch (command) {
                case "exit":
                    ui.displayMessage("Thank you for playing!");
                    return;
                case "help":
                    ui.displayMessage("Available commands: go [n/e/s/w], look, exit, take, drop, eat");
                    break;
                case "look":
                    ui.displayRoom(player.getCurrentRoom());
                    break;
                case "take":
                    player.takeItem();
                    break;
                case "attack":
                    player.attack();
                    break;
                case "drop":
                    player.dropItem();
                    break;
                case "eat":
                    player.eatItem();
                    break;
                case "health":
                    ui.displayHealth(100);
                    break;
                case "sword":
                    player.takeItem();
                    break;
                default:
                    if (command.startsWith("go ")) {
                        String direction = command.substring(3);
                        player.move(direction);
                        ui.displayRoom(player.getCurrentRoom());
                    } else {
                        ui.displayMessage("Invalid choice. Type 'help' for available commands.");
                    }
            }
        }
    }
}
