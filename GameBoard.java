import java.util.*;
/* parent class of GameBoard- model for any game board that can be represented as a 2D array
 * This class contains the method names of the basic methods that each specific game (subclass) will need.
 * However, there is no actual code in the methods because the way that method is carried out depends entirely on the specific game!
 */
public class GameBoard { 
//These are the two common variables between all board sublcasses
    public char[][] board; //The actual board as a 2D array (The common point for the usage of this parent class)
    public char currentPlayerMark;//This is the current player's piece. These board games will have players and this changes depending on whose turn it is
   
   //This is the constructor for the parent class
 //This constructor will never be used because no generic board is needed in this code
  //It acts as a model to make the game specfic boards
    public GameBoard() {
        
    }
 
 
    //This is the commonly required method to loop through each element on the board and fill it with a starting value that can be changed according to the proceedings of the game
    public void initializeBoard() {
  
    }
 
 
    //This is another common method among subclasses that will print out the board to display to the users
      public void printBoard() {
         
          }

 
       
    // This method will serve to change from one player to another
   public  void changePlayer() {
     if (currentPlayerMark == ' ') { // this checks to see if it the marker is on one player
            currentPlayerMark = ' '; //if it is, it sets the marker to the other player 
        }
        else {
            currentPlayerMark = ' ';//if it is not, that means the other player has the mark and so switches the mark back to this player
        }
            }
 
         // This method takes input from the player and places their piece where they want in accordance with the rules of the specific game
    public  void placeMark() {
      
    }  
        
        
    
   
}