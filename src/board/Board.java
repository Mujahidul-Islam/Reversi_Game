
package board;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Board {

    private int[][] square; //2D array for Board
    private int size;      //size of 2D array
    public final static int Empty =0, BLACK = 1, WHITE = 2; //setting values for white black and empty
    
    /**
     * Construction that takes board size as a parameter and initialize board with default values
     * @param size size of board
     */
    public Board(int size){
        this.size=size;
        square = new int[size][size];
        
        int middle = size/2-1; //dividing size into half
          
        square[middle][middle]=WHITE; //setting values for middle
        square[middle][middle+1]=BLACK;//setting values for middle right
        square[middle+1][middle]=BLACK; // setting values for middle down
        square[middle+1][middle+1]=WHITE; //setting values for middle down right
     
      
      
    }
    /**
     * Constructor that takes file name as parameter
     * @param fileName
     * @throws IOException 
     */
    public Board(String fileName) throws IOException{
        
        this.importBoardSetup(fileName); //calling importBoardSetup function to initialize
    }
    
    //Function that put . in place of 0, X in place of 1(black), 0 in place of 2(white)
      public String toString() {
          String str="";
          //loop tp traverse whole 2d array
          for(int i=0;i<size;i++){
             for(int j=0;j<size;j++){
                 
                 if(square[i][j]==0){
                     str=str+".";
                 }else if(square[i][j]==1){
                     str=str+"X";
                 }else if(square[i][j]==2){
                     str=str+"0";
                 }
              
          }
             str=str+"\n";
             
          }
          return str;
      }
      /*
      function that gets the opponent of player
      */
    public static int opponentOf(int player){
        //if player numbe is 1 than return 2 as opponent
        if(player==1){
            return 2;
        }else if(player==2){ //if player numbe is 2 than return 1 as opponent
            return 1;
        }
        return 0;
    }
    /**
     * Function for getting name of player
     * @param player player number
     * @return 
     */
    public static String nameOf(int player){
        
         if(player==1){
            return "BLACK"; //retrun black for player 1
        }else if(player==2){
            return "WHITE"; //return white for player 2
        }
         return "Invalid"; //else return invalid
    }
    /**
     * Function for getting scores of the game
     * @return 
     */
    public int getScore() {
        int black=0,white=0;
        
        //loop through the whole 2D array
         for(int i=0;i<size;i++){
             for(int j=0;j<size;j++){
                 
                  if(square[i][j]==1){ ///if player numbe is 1 than ncrement black
                      black++;
                    
                 }else if(square[i][j]==2){//if player numbe is 2 than ncrement white
                     white++;
                 }
             }
         }
         if((black-white)>0){// if black number are greater than white than return 1
             return 1;
         }else if (black-white<0){// if black number are less than white than return -1
             return -1;
         }else{
             return 0; ///  return 0 for tie
         }
    }
     public MoveList allValidMoves(int player){
         MoveList ml=new MoveList();
     
         for(int i=0;i<size;i++){
             for(int j=0;j<size;j++){
                 DirectionList m=new DirectionList();
              
                 //if square is  of opponent value
                 if(square[i][j]==Board.opponentOf(player)){
                     
                     //checking direction for all possible direction
                    if(CheckDown(i,j,player)!=null)
                         m.addDirection(CheckDown(i,j,player));
                    
                     if(CheckUp(i,j,player)!=null)
                         m.addDirection(CheckUp(i,j,player));
                     
                     if(CheckLeft(i,j,player)!=null)
                         m.addDirection(CheckLeft(i,j,player));
                     
                     if(CheckRight(i,j,player)!=null)
                         m.addDirection(CheckRight(i,j,player));
                     
                     if(CheckUpRight(i,j,player)!=null)
                         m.addDirection(CheckUpRight(i,j,player));
                     
                     if(CheckUpLeft(i,j,player)!=null)
                         m.addDirection(CheckUpLeft(i,j,player));
                     
                     if(CheckDownLeft(i,j,player)!=null)
                         m.addDirection(CheckDownLeft(i,j,player));
                     
                     if(CheckDownRight(i,j,player)!=null)
                         m.addDirection(CheckDownRight(i,j,player));
                     
                    if(m.length()!=0){ //if direction list is not empty
                        ml.addMove(new Move(i,j,m));// add move to the list
                    }
                 }
             }
             
     }
         return ml;
     }
     /**
      * Helper function for checking Down direction validity
      * @param row 
      * @param col
      * @param player
      * @return direction if valid else return null
      */
     private Direction CheckDown(int row,int col,int player){
         if(!(row>=0 & (row+1)<size & col>=0 & col<size)){
             return null;
         }
 
         if(square[row+1][col]==0){
            
             for (int i=1;(row-i)>=0;i++){
                 if(square[row-i][col]==0){
                     return null;
                 }

                 if(square[row-i][col]==player){
                   
                     return new Direction(1,0);
                    
             }
             }
         }
         return null;
     }
      /**
      * Helper function for checking Up direction validity
      * @param row 
      * @param col
      * @param player
      * @return direction if valid else return null
      */
      private Direction CheckUp(int row,int col,int player){
          if(!((row-1)>=0 & row<size & col>=0 & col<size)){
              
             return null;
         }
        
         if(square[row-1][col]==0){
              
             for (int i=1;(row+i)<size;i++){
                 if(square[row+i][col]==0){
                     return null;
                 }
                 if(square[row+i][col]==player){
                  
                      return   new Direction(-1,0);
                   
             }
         }
         }
         return null;
     }
       /**
      * Helper function for checking Left direction validity
      * @param row 
      * @param col
      * @param player
      * @return direction if valid else return null
      */
    private Direction CheckLeft(int row,int col,int player){
       if(!(row>=0 & row<size & (col-1)>=0 & col<size)){
             return null;
         }
       
         if(square[row][col-1]==0){
             
            for (int i=1;(col+i)<size ;i++){
                 if(square[row][col+i]==0){
                     return null;
                 }
                 if(square[row][col+i]==player){
                    return new Direction(0,-1);
                   
             } 
         }}
         return null;
     }
     /**
      * Helper function for checking Right direction validity
      * @param row 
      * @param col
      * @param player
      * @return direction if valid else return null
      */
      private Direction CheckRight(int row,int col,int player){
          if(!(row>=0 & row<size & col>=0 & (col+1)<size)){
             return null;
         }
         if(square[row][col+1]==0){

             for (int i=1;(col-i)>=0;i++){
              if(square[row][col-i]==0){
                     return null;
                 }
                 if(square[row][col-i]==player){
                     return new Direction(0,1);
                    
             } 
         }}
         return null;
     }
       /**
      * Helper function for checking up right direction validity
      * @param row 
      * @param col
      * @param player
      * @return direction if valid else return null
      */
      private Direction CheckUpRight(int row,int col,int player){
           if(!((row-1)>=0 & row<size & col>=0 & (col+1)<size)){
             return null;
         }
        if(square[row-1][col+1]==0){
            
             for (int i=1;(col-i)>=0 & (row+i)<size;i++){
                 if(square[row+i][col-i]==0){
                     return null;
                 }
                 if(square[row+i][col-i]==player){
                   
                     return new Direction(-1,1);
                    
             } 
         }
         }
         return null;
     }
       /**
      * Helper function for checking up left direction validity
      * @param row 
      * @param col
      * @param player
      * @return direction if valid else return null
      */
     private Direction CheckUpLeft(int row,int col,int player){
        if(!((row-1)>=0 & row<size & (col-1)>=0 & col<size)){
             return null;
         }
        if(square[row-1][col-1]==0){
           
             for (int i=1;(col+i)<size & (row+i)<size;i++){
                if(square[row+i][col+i]==0){
                     return null;
                 }
                 if(square[row+i][col+i]==player){
                     
                    return new Direction(-1,-1);
                     
             } 
             }
         }
         return null;
     }
      /**
      * Helper function for checking Down left direction validity
      * @param row 
      * @param col
      * @param player
      * @return direction if valid else return null
      */
      private Direction CheckDownLeft(int row,int col,int player){
         if(!(row>=0 & (row+1)<size & (col-1)>=0 & col<size)){
             return null;
         }
               if(square[row+1][col-1]==0){
                    
            for (int i=1;(col+i)<size & (row-i)>=0;i++){
                 if(square[row-i][col+i]==0){
                     return null;
                 }
                 if(square[row-i][col+i]==player){
                     
                     return new Direction(1,-1);
                     
             }  
         }}
         return null;
     }
       /**
      * Helper function for checking right direction validity
      * @param row 
      * @param col
      * @param player
      * @return direction if valid else return null
      */
        private Direction CheckDownRight(int row,int col,int player){
            if(!(row>=0 & (row+1)<size & col>=0 & (col+1)<size)){
             return null;
         }
        if(square[row+1][col+1]==0){
            for (int i=1;(col-i)>=0 & (row-i)>=0;i++){
                 if(square[row-i][col-i]==0){
                     return null;
                 }
                 if(square[row-i][col-i]==player){
                     return new Direction(1,1);
                     
             } 
            }
         }
         return null;
     }
        //function for making move
     public void makeMove(int player, Move theMove)         {
         int row=theMove.getRowChange(); //getting row
         int col=theMove.getColumnChange();//getting colume
         int j=-1;
         
         square[row][col]=player; //setting value of player 
         
         DirectionList dl=theMove.getPossibleDirection(); //get directions of move
       
        int i=0;
        //setting value of player in the empty square
        square[row+dl.getDirection(i).getRowChange()][col+dl.getDirection(i).getColumnChange()]=player;
        
            while(true){//loop until not break 
                //flip all the possible values
            if( square[row+dl.getDirection(i).getRowChange()*j][col+dl.getDirection(i).getColumnChange()*j]!=player){
                 square[row+dl.getDirection(i).getRowChange()*j][col+dl.getDirection(i).getColumnChange()*j]=player;
                 j--;
            }else{
                
                 j=-1;
                break; 
            }
            
        }
         
    
}
     //function for saving state of game in text file
 public void saveFile(String fileName) throws FileNotFoundException{ 
     
      try {
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(fileName)); //opening text file
            out.write(size+"\n"+toString()); // witing in the text file
             out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
                    
 }
 //function for importing game state from text file
  public void importBoardSetup(String fileName) throws FileNotFoundException, IOException{
       FileReader fr = new FileReader(fileName);
         int i;     
        int row=0,col=0;
        int rowSize=0,ColSize=0;
        
        //checking the number of rows and column of file
        while ((i=fr.read()) != -1){
            if((char)i=='\n'){
                rowSize=0;
                ColSize++;
            
        }else{
               rowSize++;   
            }
            }
       
      fr.close();
        if(rowSize !=(ColSize+1)){//checking if The number of columns and rows doesn’t match
            throw new IOException("The number of columns and rows doesn’t match");
        }
        if(rowSize<2 || (ColSize+1)<2){//checking if number of rows/columns less than 2
            throw new IOException("number of rows/columns less than 2");
        }
         square=new int[rowSize][rowSize];//initializing square 
         size=rowSize; //setting size
        fr = new FileReader(fileName);//opening file
        
     while ((i=fr.read()) != -1){
        
        if((char)i=='.'){ //if . put 0
            square[row][col]=0;
            col++;
        } else if((char)i=='0'){ //if 0 put 2
            square[row][col]=2;
            col++;
        }  else if((char)i=='X'){ //if X put 1
            square[row][col]=1;
            col++;
        }  else if((char)i=='\n'){ //if line break 
            row++;
            col=0;
          
        }else{
            throw new IOException("“Unrecognized character"); // throw exception if invalid character
        }
        
  }
    
  }

  
    
}

