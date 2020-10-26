package board;

public class Direction {
    private int rowChange;
    private int columnChange;

public Direction ( int rowChange, int columnChange){

    this.rowChange = rowChange;
    this.columnChange = columnChange;
}


    public int getRowChange() {
        return rowChange;
    }
    public int getColumnChange() {
        return columnChange;
    }



    @Override
    public String toString() {

    String str ;
        if(rowChange == -1 && columnChange == 0){
            str ="<up>";

        }
      else  if(rowChange == 1 && columnChange == 0){
            str ="<down>";

        }

      else if(rowChange == 0 && columnChange == 1){
            str ="<right>";

        }

      else if(rowChange == 0 && columnChange == -1){
            str ="<left>";

        }

      else if(rowChange == -1 && columnChange == 1){
        str ="<up right>";

      }
      else if (rowChange == -1 && columnChange == -1){
        str = "<up left>";
      }

      else if(rowChange == 1 && columnChange == 1){
        str = "<down right>";

        }
      else if(rowChange == 1 && columnChange == -1) {

        str = "<down left>";
        }
      else{
        str="Invalid direction";
          
      }
        
     return str;
    }
}