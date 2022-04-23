package SnakeLadder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SnakeLadder {

    private static List<Players> Players;

    public static void main(String[] args) {
        // print welcome message
        System.out.println("Welcome to snake and Ladder ");
        System.out.println("Created by Resh GAming");
        //Initialing Scanner
        Scanner scan = new Scanner (System.in);
        //Prompt for number of player
        int numPlayer = 0;
        while(numPlayer<=0||numPlayer>6) {
            System.out.println("Please Enter the number Of Player (1-6):");
            numPlayer = scan.nextInt();
        }
        //Initialize the Players

        List <Player> players = new ArrayList<Player>();
        for (int idx = 0; idx < numPlayer ; idx++) {
            Player player = new Player ("P"+idx);
            player.add(player);
        }
        Board board = new Board (Players);
        //Loop until a player reaches the final spot
        //Players take turns to roll the die and move to the board
        boolean done = false;
        int playerIdx = 0;
        while(!done) {
            //Player takes turn
            Player currPlayer = players.get(playerIdx);
            int roll = currPlayer.takeTurn();
            //update the board
            done = board.movePlayer(currPlayer,roll);

            //Print the board
            System.out.println(board);
            System.out.println("...................\n");
            //If we're done, print end message
            if (done)
            {System.out.println(currPlayer+"wins");
            }
            //set up for next player
            Players Idx;
            if (playerIdx==numPlayer) {
                playerIdx=0;
            }


        }

    }

}
