import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int size = 3;

        String[][] cells = new String[size][size];

        System.out.print("Enter cells: ");

        String[] inLine = scanner.nextLine().split("");

        int index = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = inLine[index++];
            }

        }
        outPutCells(cells);
        boolean checkOut = true;

        while (checkOut){
            System.out.print("Enter the coordinates: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(x < 1 || y< 1 || x > 3 || y > 3){
                System.out.println("Coordinates should be from 1 to 3!");
            }
            
        }
    }

    public static void outPutCells(String[][] array) {
        System.out.println("---------");
        for (int i = 0; i < array.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < array.length; j++) {

                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }
}
