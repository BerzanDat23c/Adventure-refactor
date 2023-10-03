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
                    return; // Afslut spillet ved at returnere fra metoden
                case "help":
                    ui.displayMessage("Available commands: go [n/e/s/w], look, exit");
                    break;
                case "look":
                    ui.displayMessage(player.getCurrentRoom().getDescription());
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
