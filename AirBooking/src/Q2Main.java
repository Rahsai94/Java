import sudoku.Grid;
import sudoku.Solver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Q2Main {
    public static void main(String[] args) {
        Grid g = new Grid(generateGrid());
        System.out.println(g.toString());

        // checks if the sudoku puzzle has been solved without any errors
        if (!Solver.backtrack(Grid.getGrid())) {
            System.out.println("Sudoku puzzle is invalid!");
        } else {
            System.out.println("\n Solved after " + Solver.count + " iterations");
            System.out.println(g.toString());
        }
    }
    // Generate Grid from give File
    private static int[][] generateGrid(){
        int tempGrid[][] = new int[9][9];
        try{
            Scanner scanner = new Scanner(new FileReader("extensionPuzzle.txt"));
            while (scanner.hasNextLine()){
                for (int i = 0; i < tempGrid.length; i++) {
                    String line = scanner.nextLine();
                    String numbers[] = line.split(",");
                    for (int j = 0; j < numbers.length; j++) {
                        tempGrid[i][j] = Integer.parseInt(numbers[j]);
                    }
                }
            }
            scanner.close();
        }catch (FileNotFoundException ignored){
            System.out.println("File is Missing");
        }catch (ArrayIndexOutOfBoundsException ignored){

        }
        return tempGrid;
    }
}
