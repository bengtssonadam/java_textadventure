package kyh.textadventure;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Initialisering
        Room pinkRoom = new Room("Pink room", "This is a room with pink walls filled with pink furniture");
        Room aHall = new Room("A hall", "A large hallway with a fancy rug on the floor");
        Room theEntrance = new Room("The entrance", "A large entrance to the map.");
        Room aDarkCave = new Room("A dark cave", "A very dark cave without any lights, and it is close to pitch black.");

        Room[][] map = {
                {pinkRoom, aHall},
                {theEntrance, aDarkCave}
        };
        int row = 1;
        int col = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Text Adventure Game (TAG)");

        boolean running = true;

        // Här börjar spelloopen
        while(running) {
            // 1. Skriv ut i vilket rum vi är i
            System.out.println(map[row][col].getName());
            System.out.println(map[row][col].getDescription());


            // 2. Läs in kommando från användaren
            System.out.print("> ");
            String command = input.nextLine();

            // 3. Dela upp kommandot i delar, varje ord blir en sträng i en array
            //    Vi delar upp det inmatade värdet vid varje mellanslag
            String[] commandParts = command.split(" ");

            // 4. Kollar vilket "huvudkommando" som angivits
            //    Dessa är:
            //      - go
            //      - quit
            if(commandParts[0].equalsIgnoreCase("go")) {
                // Vi har angett go som kommando


                // Kontrollera att man har skrivit något efter go, alltså en riktning
                if(commandParts.length >= 2) {
                    // Kolla efter riktning
                    if(commandParts[1].equalsIgnoreCase("north")) {
                        row--;
                        // Kontrollera så vi inte hamnar utanför kartan
                        if(row < 0) {
                            row = 0;
                        }
                    }
                    else if(commandParts[1].equalsIgnoreCase("south")) {
                        row++;
                        if(row >= map.length) {
                            row--;
                        }
                    }
                    else if(commandParts[1].equalsIgnoreCase("east")) {
                        col++;
                        if(col >= map[row].length) {
                            col--;
                        }
                    }
                    else if(commandParts[1].equalsIgnoreCase("west")) {
                        col--;
                        if(col < 0) {
                            col = 0;
                        }
                    }
                    System.out.println("Going " + commandParts[1]);
                }
                else {
                    System.out.println("You can't go without any direction");
                }
            }

            if(command.equalsIgnoreCase("quit")) {
                running = false;
            }
        }
        System.out.println("Thanks for playing TAG");
    }
}
