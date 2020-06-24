package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int size = 3;

        String[][] cells = new String[size][size];

        System.out.print("Enter cells: ");

        int countX = 0;
        int countO = 0;

        String[] inLine = scanner.nextLine().split("");

        for (String unit : inLine) {
            if (unit.equals("X")) {
                countX++;
            } else if (unit.equals("O")) {
                countO++;
            }
        }

        int index = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = inLine[index++];
            }

        }
        outPutCells(cells);
        boolean checkOut = true;
        int x = 0;
        int y = 0;
        while (checkOut) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            if (input.matches("\\d+\\s\\d++")) {
                x = Integer.parseInt(input.split(" ")[0]);
                y = Integer.parseInt(input.split(" ")[1]);
            } else {
                System.out.println("You should enter numbers!");
            }
            if (x < 1 || y < 1 || x > 3 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            int posX = size - y;
            int posY = x - 1;

            if (cells[posX][posY].equals("X") || cells[posX][posY].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
            } else if (countX == countO) {
                cells[posX][posY] = "X";
                countX++;
                outPutCells(cells);
            } else if (countX > countO) {
                cells[posX][posY] = "O";
                countO++;
                outPutCells(cells);
            }

            if(xWin(cells)){
                System.out.println("X wins");
            }else if(oWin(cells)){
                System.out.println("O wins");
            }

        }
    }

    public static boolean xWin(String[][] cells) {
        int counter = 0;
        //check rows
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (counter == 3)
                    break;
                if (cells[i][j] == "X")
                    counter++;
                else
                    counter = 0;
            }
            if (counter != 3)
                counter = 0;
        }
        //check columns
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (counter == 3)
                    break;
                if (cells[j][i] == "X")
                    counter++;
                else
                    counter = 0;
            }
            if (counter != 3)
                counter = 0;
        }

        //check diagonal
        for (int i = 0; i < cells.length; i++) {
            if (counter == 3)
                break;
            if (cells[i][i] == "X")
                counter++;
            else
                counter = 0;
        }

        if (cells[0][2] == "X" && cells[1][1] == "X" && cells[2][0] == "X")
            counter = 3;
        if (counter == 3)
            return true;
        else
            return false;
    }

    public static boolean oWin(String[][] cells) {
        int counter = 0;
        //checkrows
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (counter == 3)
                    break;
                if (cells[i][j] == "O")
                    counter++;
                else
                    counter = 0;
            }
            if (counter != 3)
                counter = 0;
        }

        //check columns
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (counter == 3)
                    break;
                if (cells[j][i] == "O")
                    counter++;
                else
                    counter = 0;
            }
            if (counter != 3)
                counter = 0;
        }

        //check diagonal
        for (int i = 0; i < cells.length; i++) {
            if (counter == 3)
                break;
            if (cells[i][i] == "O")
                counter++;
            else
                counter = 0;
        }

        if (cells[0][2] == "O" && cells[1][1] == "O" && cells[2][0] == "O")
            counter = 3;

        if (counter == 3)
            return true;
        else
            return false;

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
