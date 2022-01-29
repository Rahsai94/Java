package sudoku;
public class Cell {

    //Private instance variables for cell
    private int cell;
    private final boolean editable;

    //Parameter Constructor for Cells
    public Cell(int cell, boolean editable) {
        this.cell = cell;
        this.editable = editable;
    }

    //Getter and Setter Methods for Cell
    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public boolean isEditable() {
        return editable;
    }
}
