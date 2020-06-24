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

        while (checkOut) {
            int x = 0;
            int y = 0;
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            if (input.matches("\\d+\\s\\d++")) {
                x = Integer.parseInt(input.split(" ")[0]);
                y = Integer.parseInt(input.split(" ")[1]);
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (x < 1 || y < 1 || x > 3 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            int posX = size - y;
            int posY = x - 1;

            if (cells[posX][posY].equals("X") || cells[posX][posY].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
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
                checkOut = false;
            }else if(oWin(cells)){
                System.out.println("O wins");
                checkOut = false;
            }else if(!xWin(cells) && !oWin(cells) && hasSpace(cells)){
                System.out.println("Game not finished");
                checkOut = false;
            }else{
                System.out.println("Draw");
                checkOut = false;
            }
        }
    }

    public static Boolean hasSpace(String[][] cells){
        int find = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if(cells[i][j].equals("_") || cells[i][j].equals(" ")){
                    find++;
                }
            }
        }
        return find > 0 ? true : false;
    }

    public static boolean xWin(String[][] cells) {
        int counter = 0;
        //check rows
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (counter == 3)
                    break;
                if (cells[i][j].equals("X"))
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
                if (cells[j][i].equals("X"))
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
            if (cells[i][i].equals("X"))
                counter++;
            else
                counter = 0;
        }

        if (cells[0][2].equals("X") && cells[1][1].equals("X") && cells[2][0].equals("X"))
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
                if (cells[i][j].equals("O"))
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
                if (cells[j][i].equals("O"))
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
            if (cells[i][i].equals("O"))
                counter++;
            else
                counter = 0;
        }

        if (cells[0][2].equals("O") && cells[1][1].equals("O") && cells[2][0].equals("O"))
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

