// Name: Kaixiang Liu
// USC NetID: liukaixi@usc
// CS 455 PA3
// Fall 2025


/** 
   MineField
      Class with locations of mines for a minesweeper game.
      This class is mutable, because we sometimes need to change it once it's created.
      Mutators: populateMineField, resetEmpty
      Includes convenience method to tell the number of mines adjacent to a location.
 */
import java.util.Random;
public class MineField {
   
   // <put instance variables here>
   private final int rows;
   private final int cols;
   private final boolean[][]mines;        // an boolean array to display the mine status
   private int targetMineCount;
   private final Random rdPlacement = new Random();
   
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in
      the array such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice
      versa.  numMines() for this minefield will corresponds to the number of 'true' values in 
      mineData.
      @param mineData  the data for the mines; must have at least one row and one col,
                       and must be rectangular (i.e., every row is the same length)
    */
   public MineField(boolean[][] mineData) {
      this.rows = mineData.length;
      this.cols = mineData[0].length;
      this.mines = new boolean[rows][cols];

      int count = 0;
      for(int r = 0; r < rows; r++){
         for(int c = 0; c<cols;c++){
            boolean checker = mineData[r][c];
            this.mines[r][c] = checker;   // setting a defensive copy to point at different references
            if(checker){
               count++;
            }
         }
      }
      this.targetMineCount = count; 
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a 
      MineField, numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
      // must have prereq: numRows/numCols > 0, numMines >= 0 && <(1/3 of total blocks)
      this.rows = numRows;
      this.cols = numCols;
      this.mines = new boolean[rows][cols];
      this.targetMineCount = numMines;
   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on
      the minefield, ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col) and numMines() < (1/3 * numRows() * numCols())
    */
   public void populateMineField(int row, int col) {
      resetEmpty();
      int bombCounter = 0;

      while(bombCounter < targetMineCount){
         // using builtin randome generator 
         int r = rdPlacement.nextInt(rows);
         int c = rdPlacement.nextInt(cols);
         if((r == row && c == col) || mines[r][c]){
            continue;      // if the bomb is placed on the tile user's initial clicked position, ignore
         }
         mines[r][c] = true;
         bombCounter++;
      }
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or
      numCols().  Thus, after this call, the actual number of mines in the minefield does not match
      numMines().  
      Note: This is the state a minefield created with the three-arg constructor is in at the 
      beginning of a game.
    */
   public void resetEmpty() {
      for(int r = 0; r < rows; r++){
         for(int c = 0; c < cols; c++){
            mines[r][c] = false;
         }
      }
   }

   
  /**
     Returns the number of mines adjacent to the specified location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
      return 0;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
      return row >= 0 && row < rows && col >= 0 && col < cols; 
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return 0;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      return 0;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      return false;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg
      constructor, some of the time this value does not match the actual number of mines currently
      on the field.  See doc for that constructor, resetEmpty, and populateMineField for more
      details.
      @return number of mines
    */
   public int numMines() {
      return 0;       // DUMMY CODE so skeleton compiles
   }

   
   // <put private methods here>
   
         
}

