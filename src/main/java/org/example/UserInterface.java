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
                handleEatCommand(player);
                break;
            case "take":
                handleTakeCommand(player);
                break;
            case "drop":
                handleDropCommand(player);
                break;
            // Andre kommandoer
            default:
                System.out.println("Invalid command. Type 'help' for available commands.");
                break;
        }
    }

    private void handleEatCommand(Player player) {

    }

    private void handleDropCommand(Player player) {

    }

    private void handleTakeCommand(Player player) {

    }

    // ... (andre metoder for at vise beskeder osv.)

    public String chooseItemFromInventory(Player player) {
        System.out.println("Your inventory contains:");
        player.displayInventory();
        return getUserChoice("Choose an item to interact with: ");
    }

    public void displayRoom(Room currentRoom) {

    }

    public void displayMessage(String s) {

    }
}
