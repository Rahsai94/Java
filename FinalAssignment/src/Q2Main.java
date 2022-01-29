import sudoku.Grid;
import sudoku.Solver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Q2Main {
    public static void main(String[] args) {
        Grid g = new Grid(generateGrid());
        System.out.println(" \n \"*\": Represents Empty position \n RED: Not Editable \n PURPLE: EDITABLE \n"+g);
        //Check given sudoku grid is valid or Not
        if (!Solver.backTrack(Grid.getGrid())) {
            System.out.println("Sudoku puzzle is invalid!");
        } else {
            System.out.println(" \n**************** Solved Sudoku ****************  \n RED: Not Editable \n PURPLE: EDITABLE \n It took " + Solver.count + " iterations");
            System.out.println(g);
        }
    }
    // Generate Grid from give File
    private static int[][] generateGrid(){
        int[][] tempGrid = new int[9][9];
        try{
            Scanner scanner = new Scanner(new FileReader("extensionPuzzle.txt"));
            while (scanner.hasNextLine()){
                for (int i = 0; i < tempGrid.length; i++) {
                    String line = scanner.nextLine();
                    String[] numbers = line.split(",");
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
