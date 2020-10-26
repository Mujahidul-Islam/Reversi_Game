
package board;

import java.util.ArrayList;
import java.util.Random;

public class MoveList {
    
     ArrayList<Move> MoveArray;// list to store Move object
    
    public MoveList(){
        MoveArray = new ArrayList();//initializing arraylist
    }
    /**
     * Add move object to the list
     * @param m object to add
     */
    public void addMove(Move m){
        MoveArray.add(m);
    }
    /**
     * check if the list is empty or not
     * @return  true if empty and false if not
     */
    public boolean isEmpty(){
        
        if(MoveArray.isEmpty()){
            return true;
        }   
        return false;
    }
    /**
     * Getting random move from array
     * @return 
     */
     public Move randomMove(){
         if(isEmpty()){//if list is empty return null
             return null;
         }else{
             Random m = new Random();//Creating object of Random class
             return MoveArray.get(m.nextInt((MoveArray.size())-0) + 0); 
         }
         
     }
     /**
      * For getting string 
      * @return 
      */
     public String toString(){
         String str="\n";
         for(int i=0;i<MoveArray.size();i++){
             str=str + MoveArray.get(i)+"\n";
         }
         return str;
     }
    
}
