import java.util.*;
public class ConnectFour extends GameBoard{

  private char[][] field;
  public char currentPlayerPiece;
  
  public ConnectFour(){
    // Declare field 2D array.
         field = new char[7][7];
         currentPlayerPiece='R';
         initializeField();
  }
  public void initializeField(){
        // Initialize with spaces
        for (int i = 0; i < 7; ++i)
            for (int j = 0; j < 7; ++j)
                field[i][j] = ' ';
  }
  
   public void changePlayer() {
        if (currentPlayerPiece == 'R') {
            currentPlayerPiece= 'Y';
        }
        else {
            currentPlayerPiece= 'R';
        }
    }
public  void printBoard() {
      System.out.println("  1 \t2 \t3 \t4 \t5 \t6 \t7");
        for (int row = 0; row < 7; ++row) {
            System.out.print(row+1+"[ ");
            for (int col = 0; col < 7; ++col)
              if (col==6)  System.out.print(field[row][col] + "] ");
            else System.out.print(field[row][col] + "]\t[ ");
            System.out.println();
        }

        // Print bottom line
        for (int col = 0; col < 7; ++col)
            System.out.print("---");
        System.out.println();
    }





    // This method attempts to put the disk of the given color in the given column.
    // It returns true if successful and false if the column is filled and we cannot 
    // put a disk.

    public void placeMark() {
      Scanner scan= new Scanner (System.in);
      if (currentPlayerPiece== 'R') System.out.print("Player 1 (R): ");
      else System.out.print("Player 2 (Y): ");
      System.out.println("Select Column number (numbers on the top) for your move");
      int column= scan.nextInt()-1;
      //check to see if column is empty
      if (column>=7||column<0) {
        System.out.println("Error: Column number not valid");
        placeMark();
      }
      else if (field[0][column]!=' '){
        System.out.println("Column is full. Please choose another column.");
        placeMark();
      }
      
        // Check all elements in the column.
     else    for (int row = 6; row >=0; row--) {
            // If we found something, which means if the character is not
            // zero character
            if (checkEmpty(row, column)) {
                // Put the disk on top of the current one.
                field[row][column] = currentPlayerPiece;
              break;
            }
        
      }
    }
      
        
     
        // If no other disks found, we place this diak at the bottom.
       
    

   public boolean checkEmpty(int row, int col){
      return field[row][col]==' ';
    }
   
 
    // Check rows, if there are 4 or more disks of the same color - return winner color
    public  char checkRowsForWin() {
        // Check rows and see if there are 4 disks of the same color
        for (int row = 0; row < 7; ++row) {
            int count = 0;
            // We will compare current element with the previous
            for (int column = 1; column < 7; ++column) {
                if (field[row][column] != ' ' &&
                    field[row][column] == field[row][column-1])
                    ++count;
                else
                    count = 1;

                // Check if there are 4 in a row.
                if (count >= 4) {
                    // Return color of the winner
                    return field[row][column];
                }
            }
        }
        // Otherwise return   character, which means nobody win in rows.
        return ' ';
    }

   
    // Check columns, if there are 4 or more disks of the same color - return winner color
    private char checkColumnsForWin() {
        // Check rows and see if there are 4 disks of the same color
        for (int column = 0; column < 7; ++column) {
            int count = 0;
            // We will compare current element with the previous
            for (int row = 1; row < 7; ++row) {
                if (field[row][column] != ' ' &&
                    field[row][column] == field[row-1][column])
                    ++count;
                else
                    count = 1;

                // Check if there are 4 in a row.
                if (count >= 4) {
                    // Return color of the winner
                    return field[row][column];
                }
            }
        }
        // Otherwise return   character, which means nobody win in rows.
        return ' ';
    }

   
// Check diagonals, if there are 4 or more disks of the same color - return winner color
   public char checkDiagonalsForWin() {
        // There are 2 kinds of diagonals, let's check those that go from top-left to bottom right

        // There are diagonals, that starts on top of each column, let's check them
        for (int column = 0; column < 7; ++column) {
            int count = 0;
            // Traverse diagonal that starts at [0][column], we start with the first row,
            // because we will compare elements with the previous one, similar to how
            // we did this for rows and columns
            for (int row = 1; row < 7; ++row) {
                // Coordinates an the diagonal change as [row + i][column + i], 
                // so we stop when column can get outside of the range
                if (column + row >= 7) break;
                if (field[row][column+row] != ' ' &&
                    field[row-1][column + row - 1] == field[row][column+row])
                    ++count;
                else
                    count = 1;
                if (count >= 4) return field[row][column+row];
            }
        }

        // There are diagonals, that starts on left of each row, let's check them
        for (int row = 0; row < 7; ++row) {
            int count = 0;
            // Traverse diagonal that starts at [row][0], we start with the first column,
            // because we will compare elements with the previous one, similar to how
            // we did this for rows and columns
            for (int column = 1; column < 7; ++column) {
                // Coordinates an the diagonal change as [row + i][column + i], 
                // so we stop when column can get outside of the range
                if (column + row >= 7) break;
                if (field[row + column][column] != ' ' &&
                    field[row+column - 1][column - 1] == field[row + column][column])
                    ++count;
                else
                    count = 1;
                if (count >= 4) return field[row + column][column];
            }
        }

        // Now we need to do the same for diagonals that go from top-right to bottom-left
        // There are diagonals, that starts on top of each column, let's check them
        for (int column = 0; column < 7; ++column) {
            int count = 0;
            // Traverse diagonal that starts at [0][column], we start with the first row,
            // because we will compare elements with the previous one, similar to how
            // we did this for rows and columns
            for (int row = 1; row < 7; ++row) {
                // Coordinates an the diagonal change as [row + i][column + i], 
                // so we stop when column can get outside of the range
                if (column - row < 0) break;
                if (field[row][column-row] != ' ' &&
                    field[row - 1][column - row + 1] == field[row][column-row])
                    ++count;
                else
                    count = 1;
                if (count >= 4) return field[row][column-row];
            }
        }

        // There are diagonals, that starts on left of each row, let's check them
        for (int row = 0; row < 7; ++row) {
            int count = 0;
            // Traverse diagonal that starts at [row][0], we start with the first column,
            // because we will compare elements with the previous one, similar to how
            // we did this for rows and columns
            for (int column = 5; column >= 0; --column) {
                // Coordinates an the diagonal change as [row + i][column + i], 
                // so we stop when column can get outside of the range
                if (column - row-1 < 0) break;
                if (field[column - row][column] != ' ' &&
                    field[column - row - 1][column + 1] == field[column - row][column])
                    ++count;
                else
                    count = 1;
                if (count >= 4) return field[column - row][column];
            }
        }

        // Otherwise return   character, which means nobody win in rows.
        return ' ';
    }

    public char getWinner() {
        char winner = checkRowsForWin();
        if (winner != ' ') return winner;
        winner = checkColumnsForWin();
        if (winner != ' ') return winner;
        winner = checkDiagonalsForWin();
        if (winner != ' ') return winner;

        // Now we need to check if there are empty positions, otherwise it is a draw
        for (int i = 0; i < field.length; ++i)
            for (int j = 0; j < field[i].length; ++j)
                if (field[i][j] == ' ') return ' ';

        return 'D';
    }

    

}

