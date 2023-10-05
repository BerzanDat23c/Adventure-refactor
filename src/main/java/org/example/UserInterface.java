package org.example;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        System.out.print("Enter a command: ");
        return scanner.nextLine().toLowerCase();
    }

    public String getUserChoice(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().toLowerCase();
    }

    public void processCommand(String command, Player player) {
        switch (command) {
            case "eat":
                player.eatItem();
                break;
            case "take":
            case "collection":  // Tillader "collection" som synonym for "take"
                player.takeItem();
                break;
            case "drop":
                player.dropItem();
                break;
            case "look":
                displayRoom(player.getCurrentRoom());
                break;
            case "inventory":
                player.displayInventory();
                break;
            case "help":
                displayHelp();
                break;
            // Andre kommandoer
            default:
                displayMessage("Invalid command. Type 'help' for available commands.");
                break;
        }
    }

    void displayRoom(Room currentRoom) {
        displayMessage("You are in " + currentRoom.getName());
        displayMessage(currentRoom.getDescription());
        displayMessage("Items in the room: ");
        currentRoom.displayItems();
    }

    private void displayHelp() {
        displayMessage("Available commands:");
        displayMessage("eat - Eat food from the room");
        displayMessage("take (or collection) - Take an item from the room");
        displayMessage("drop - Drop an item from your inventory");
        displayMessage("look - Examine the current room");
        displayMessage("inventory - View your inventory");
        // Andre kommandoer
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayInventory() {

    }
}
