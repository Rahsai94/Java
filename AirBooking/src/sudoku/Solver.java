package sudoku;

public class Solver {

    public static int count = 0;
    //Implement backTracking Algorithm
    public static boolean backtrack(Cell[][] grid) {

        //Get empty cell position
        int[] position = Grid.getEmptyPosition(grid);
        int rowPos = position[0];
        int colPos = position[1];

        //if there is no empty position return
        if (rowPos == -1) return true;

        for (int cell = 1; cell <= grid.length; cell++) {
            if (Grid.isValidCell(rowPos, colPos, cell)){
                grid[rowPos][colPos].setCell(cell);
                if (backtrack(grid)) {
                    return true;
                } else {
                    grid[rowPos][colPos].setCell(0);
                    count++;
                }
            }
        }

        return false;
    }
}
