package main;

import Engine.Game;
import Engine.WorldGen;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Human vs Goblins Game!");
        System.out.println("In this game you are a human who is moving through a grid world full of goblins and treasuries!");
        System.out.println("\nInstructions: To move, type the direction you want to go (W (Forward) | A (Right) | S (Back) | D (Left))");
        System.out.println("Press enter to start the game!\n======");

        userInput.nextLine();



        while(!game.gameOver()){
            game.showMap();

            System.out.println("What direction would you like to go?");
            char direction = userInput.nextLine().toLowerCase().charAt(0);

            game.move(direction);

            if(game.isInCombat()){
                System.out.println("\n" + game.getActiveCombat().combatType());
                System.out.println("Press Enter to continue:");
                userInput.nextLine();
                System.out.println(game.execCombat());
            }

            System.out.println(" - - - - - - ");
        }

        System.out.println("\nGame Over :(");
    }
}
