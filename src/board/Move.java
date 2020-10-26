
package board;


public class Move {
    private int rowChange;
    private int columnChange;
    private DirectionList possibleDirection;
    
    
    public Move(int rowChange,int columnChange,DirectionList d){
        
        this.rowChange=rowChange;
        this.columnChange=columnChange;
        this.possibleDirection=d;
        
    }

    /**
     * @return the rowChange
     */
    public int getRowChange() {
        return rowChange;
    }

    /**
     * @return the columnChange
     */
    public int getColumnChange() {
        return columnChange;
    }

    /**
     * @return the possibleDirection
     */
    public DirectionList getPossibleDirection() {
        return possibleDirection;
    }
    /**
     * Function for getting flip direction
     * @return 
     */
     public String toString() {

         return "("+rowChange+","+columnChange+")"+" flips Direction "+this.possibleDirection.toString();
     }
}
