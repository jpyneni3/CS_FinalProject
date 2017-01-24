import java.util.*;
public class TicTacToe extends GameBoard {
//This is the specific class for the Tic Tac Toe Board Game
    private char[][] square; //These are the same variables that were identified in the parent class -this one is for the square board
    public char currentPlayerMark;//This is the current player's piece. This changes depending on whose turn it is
      
   //This is the constructor for the Tic Tac Toe class
      public TicTacToe() {
        square = new char[3][3];// It instantiates a 3 by 3 square as the board
        currentPlayerMark = 'X';//This sets the first player's marker to X
        initializeBoard();//This calls the intialize method to set up the board
    }
 
 
    // This method intiatilizes the board by setting up the square with a dash in each element
    public void initializeBoard() {
  
        // Loop through each row (Total 3- 0, 1, 2)
        for (int i = 0; i < 3; i++) {
            // Loop through columns (Total 3- 0,1,2)
            for (int j = 0; j < 3; j++) {
                square[i][j] = '-';//This fills each element with a dash to initialize that element
            }
        }
    }
       // This method changes from one player to another
    public void changePlayer() {
        if (currentPlayerMark == 'X') {//If the current player is X, player 1, then ...
            currentPlayerMark = 'O';//This method sets it to the next player, O, player 2
        }
        else {
            currentPlayerMark = 'X';//If X is not the current player, meaning O is, then it sets X as the current player, switching back
        }
    }
 
  
    // This method loops through each element and prints out the board 
    public void printBoard() {
        System.out.println("-------------");//This is a top line
        System.out.println("   1   2   3");//THe
  
        for (int i = 0; i < 3; i++) {
            System.out.print((i+1)+"| ");
            for (int j = 0; j < 3; j++) {
              System.out.print(square[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    
         // Places a mark at the cell specified by row and col with the mark of the current player.
    
    public void placeMark() {
      if( currentPlayerMark=='X' ) {System.out.print("Player 1 (X): "); }
      else {System.out.print("Player 2 (O): ");}
      Scanner scan= new Scanner(System.in);
     System.out.println("Select Row number (numbers on the left side) for your next placement");
     int row= scan.nextInt()-1;
     if (row<0||row>2) {System.out.println("Invalid Row number. Try Again with new location!");
       placeMark();
     }
     System.out.println("Select Column number (numbers on the top) for your next placement");
    int col= scan.nextInt()-1;
     if (col<0||col>2) {System.out.println("Invalid Column number. Try Again with new location!");
       placeMark();
     }
    if( !checkEmpty(row, col)){
      System.out.println("Cannot place your piece here. Already full! Try again!");
      placeMark();
    }  
        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (square[row][col] == '-') {
                    square[row][col] = currentPlayerMark;
                    }
            }
        }
  
        }
    
    public boolean checkEmpty(int row, int col){
      return square[row][col]=='-';
    }
 
    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean isBoardFull() {
        boolean isFull = true;
  
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (square[i][j] == '-') {
                    isFull = false;
                }
            }
        }
  
        return isFull;
    }
 
 
    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }
 
 
    // Loop through rows and see if any are winners.
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(square[i][0], square[i][1], square[i][2]) == true) {
                System.out.println("Congrats, we have a winner!"+currentPlayerMark+" won!");
        return true;
            }
        }
        return false;
    }
 
 
    // Loop through columns and see if any are winners.
    public boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(square[0][i], square[1][i], square[2][i]) == true) {
               System.out.println("Congrats, we have a winner!"+currentPlayerMark+" won!");
               return true;
            }
        }
        return false;
    }
 
 
    // Check the two diagonals to see if either is a win. Return true if either wins.
    public boolean checkDiagonalsForWin() {
      if ((checkRowCol(square[0][0], square[1][1], square[2][2]) == true) || (checkRowCol(square[0][2], square[1][1], square[2][0]) == true)){
        System.out.println("Congrats, we have a winner! "+currentPlayerMark+" won!");
        return true;
    }
      else return false;
    }
 
 
    // Check to see if all three values are the same (and not empty) indicating a win.
   public boolean checkRowCol(char a, char b, char c) {
        return ((a != '-') && (a == b) && (b == c));
    }
 
 
 
}