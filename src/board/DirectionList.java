package board;


public class DirectionList {

    private Direction[] array; //array to store direction


    public DirectionList() {

        array = new Direction[8]; //initializing array of size 8

    }
/**
 * Function to add a direction to the list
 * @param d new Direction 
 */
    public void addDirection(Direction d) {
       if(length()==8){ //find if the length is full then return without adding the direction 
           return ;
       }
        this.array[length()]=d;//add direction at the end of array

    }
/*
    return the total number of directions stored in direction list
    */
    public int length() {
        
        int count=0;//count total number of values
        
        for(int i =0;i<array.length;i++){ //loop to the array size
            if(array[i]!=null){ //check if the array item is null or not
                count++; //increment count if the array iten is not null
            }
        }
        return count;
        
    }

/**
 * Function for getting direction at given index
 * @param i index of array
 * @return item at the given index
 */
    public Direction getDirection(int i) {
        return this.array[i];
        
    }
/**
 * Function for printing the total directions
 * @return 
 */
    public String toString() {

        String str = "{";

       for (int j = 0; j < length(); j++) {//loop till the size of array
           
           if((j+1)==length()){ //if the item is the last then removing , from end
                 str =str+ array[j].toString();
                 break;
            }
            str =str+ array[j].toString()+","; // adding , at the end of directions

        }
        str = str+"}";
        return str;
    }

/**
 * Function for getting all the possible directions
 * @return List of directions
 */

 public static DirectionList allDirections(){
     DirectionList  d2=new DirectionList();
      
          d2.addDirection(new Direction(1,1));
          d2.addDirection(new Direction(1,0));
          d2.addDirection(new Direction(1,-1));
          d2.addDirection(new Direction(-1,1));
          d2.addDirection(new Direction(-1,0));
          d2.addDirection(new Direction(-1,-1));
          d2.addDirection(new Direction(0,1));
          d2.addDirection(new Direction(0,-1));

    return d2;
  }

}