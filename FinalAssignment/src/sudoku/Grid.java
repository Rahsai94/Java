package sudoku;

public class Grid {
    // Create 2d array for sudoku grid
    private static final Cell[][] grid = new Cell[9][9];

    // Parameter Constructor for Grid
    // Populates the 2d array
    public Grid(int[][] g){
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                Grid.grid[i][j] = g[i][j] == 0 ? new Cell(g[i][j], true ) :  new Cell(g[i][j], false);
            }
        }
    }

    //Getter and Setter Methods for grid
    public static Cell[][] getGrid() {
        return Grid.grid;
    }

    //Check any duplicates numbers in Column
    private static boolean isDuplicateInRow(int j, int cell) {
        for (int i = 0; i < Grid.grid.length; i++) {
            if(Grid.grid[j][i].getCell() == cell){
                return true;
            }
        }
        return false;
    }

    //Check any duplicates numbers in Column
    private static boolean isDuplicateInColumn(int j, int cell) {
        for (Cell[] cells : Grid.grid) {
            if (cells[j].getCell() == cell) {
                return true;
            }
        }
        return false;
    }

    //Check any duplicates numbers in 3 * 3 matrix
    private static boolean subGridDuplicates(int rowIndex, int colIndex, int cell){

        //Calculate the subgrid
        int subGridSize = (int)Math.sqrt(Grid.grid.length);
        int starRowIndex = rowIndex - rowIndex % subGridSize;
        int starColIndex = colIndex - colIndex % subGridSize;
        int endRowIndex = starRowIndex + subGridSize;
        int endColIndex = starColIndex + subGridSize;

        //Check the subGrid is number is present or not
        for (int i = starRowIndex; i < endRowIndex; i++) {
            for (int j = starColIndex; j < endColIndex; j++) {
                if(Grid.grid[i][j].getCell() == cell){
                    return true;
                }
            }
        }

        return false;
    }


    // method to check if all constraints are met to give a valid number
    public static boolean isValidCell(int i, int j, int cell){
        return (!isDuplicateInRow(i, cell) && !isDuplicateInColumn(j, cell) && !subGridDuplicates(i, j, cell));
    }

    // Get the empty position from sudoku
    public static int[] getEmptyPosition(Cell[][] Grid){
        int[] pos = new int[2];
        for (int i = 0; i < Grid.length; i++){
            for (int j = 0; j < Grid[i].length; j++) {
                if(Grid[i][j].getCell() == 0){
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }

        pos[0] = -1;
        pos[1] = -1;
        return pos;
    }

    @Override
    public String toString() {

        // Colors for Grid
        String WHITE = "\u001B[0m";
        String RED = "\u001B[41m";
        String PURPLE = "\u001B[45m";

        StringBuilder str = new StringBuilder();
        for (Cell[] cells : Grid.grid) {
            str.append("\n");
            str.append("  ");
            for (Cell value : cells) {
                String cell = value.getCell() == 0 ? " * " : " " + value.getCell() + " ";
                String color = value.isEditable() ? PURPLE + cell + WHITE : RED + cell + WHITE;
                str.append(color);
            }
        }
        return new String(str);
    }
}
