public class Direction {
    private int rowChange;
    private int columnChange;

public Direction ( int rowChange, int columnChange){

    this.rowChange = rowChange;
    this.columnChange = columnChange;
}

    public int getColumnChange() {
        return columnChange;
    }

    public int getRowChange() {
        return rowChange;
    }

    @Override
    public String toString() {
        
    }
}