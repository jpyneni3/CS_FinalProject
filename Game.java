import java.util.*;
public class Game {
 
   public static void main(String[] args)
  {
     
    Scanner scan = new Scanner(System.in);
     System.out.println("\t\t\tWELCOME TO JAS'S ARCADE!");
     System.out.println("****************************************");
     System.out.println("*************GAME MENU*************");
     System.out.println("*1|  Tic Tac Toe                                      *");
     System.out.println("*2|   Connect 4                                       *");
     System.out.println("****************************************");
     System.out.println();
     System.out.println("Enter Game # to play");
       int gameNum= scan.nextInt();
    
     
     
     
    if (gameNum==1){
     System.out.println("You are now playing Tic Tac Toe!");
     System.out.println("Would you like the rules?(Yes or No)");
     String response= scan.next();
     if (response.equals("yes")||response.equals("Yes")) {
       System.out.println("Player 1 is 'X'. Player 2 is 'O'. \nThe first player starts the game by placing their piece anywhere in the board by first choosing the row then the column corresponding to the desired location.");
       System.out.println("Players alternating placing their respective pieces until one of them has three in a row horizontally, veritcally or diagonally. \nIf all 9 squares are filled without a winner, then the game results in a draw!");
       System.out.println("Good Luck!");
     }
     else System.out.println("Good Luck!");
        // Create game and initialize it.
// First player will be 'x'
TicTacToe game = new TicTacToe();
game.printBoard();

int count =1;

while (count <=9){
// Player 'x' places a mark in the top right corner row 0, lumn 2
// These values are based on a zero index array, so you may need to simply take in a row 1 and subtract 1 from it if you want that.

game.placeMark();

// Lets print the board
game.printBoard();

// Did we have a winner?
if (game.checkForWin()) break;
else if (game.isBoardFull()) {
  count =9;
   System.out.println("Appears we have a draw!");
   }

// No winner or draw, switch players to 'o'
count++;
game.changePlayer();

// Repeat steps again for placing mark and checking game status...
  }
    System.out.println("Hope you enjoyed the game!");
}

    
    else{
      System.out.println("You are now playing Connect Four");
        System.out.println("Would you like the rules?(Yes or No)");
     String response= scan.next();
     if (response.equals("yes")||response.equals("Yes")) {
       System.out.println("Player 1 is 'R' for red. Player 2 is 'Y' for yellow. \nThe first player starts the game by choosing the desired column for their piece. Their piece occupies the bottom most row possible in that column.");
       System.out.println("Players alternating placing their respective pieces in the columns until one of them has four in a row horizontally, veritcally or diagonally. ");
       System.out.println("Good Luck!");
     }
     else System.out.println("Good Luck!");
         ConnectFour game= new ConnectFour();
              
       game.printBoard();

       int count= 0;
         while (count<=49) {
                    
            // Try to put disk in a column, method returns false if the columns
            // is filled and you cannot put a disk there.
           game.placeMark();

            game.printBoard();
           

            // Get winner, this method returns R if Red win, Y if Yellow wins, D
            // if it is a draw and space character if we need to continue the game.
            char result =game.getWinner();
            if (result == 'D') {
                System.out.println("It is a draw!");
                break;
            }
            else if (result == 'R') {
                System.out.println("Player 1 wins! Congrats!!");
                break;
            }
            else if (result == 'Y') {
                System.out.println("Player 2 wins! Congrats!!");
                break;
            }
            
             game.changePlayer();
        }
         count++;
    }
   }
    
    }

 
