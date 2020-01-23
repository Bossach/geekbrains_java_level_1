package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;


    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private  static char[][] map;
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        playGame();
    }

    private static void playGame() {
        while (true) {

            humanTurn();
            printMap();

            if (checkEnd("Игрок победил!", DOT_X)) break;

            aiTurn();
            printMap();

            if (checkEnd("Компьютер победил!", DOT_O)) break;
        }
    }

    private static boolean checkEnd(String winMessage, char sym) {
        if (checkWin(sym)) {

            System.out.println(winMessage);
            return true;
        }

        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ( map[i][j] == DOT_EMPTY ) return false;
            }
        }

        return true;
    }

    private static boolean checkWin(char sym) {
        if ( map[0][0] == sym && map[0][1] == sym && map [0][2] == sym ) return true;
        if ( map[1][0] == sym && map[1][1] == sym && map [1][2] == sym ) return true;
        if ( map[2][0] == sym && map[2][1] == sym && map [2][2] == sym ) return true;

        if ( map[0][0] == sym && map[1][0] == sym && map [2][0] == sym ) return true;
        if ( map[0][1] == sym && map[1][1] == sym && map [2][1] == sym ) return true;
        if ( map[0][2] == sym && map[1][2] == sym && map [2][2] == sym ) return true;

        if ( map[0][0] == sym && map[1][1] == sym && map [2][2] == sym ) return true;
        if ( map[0][2] == sym && map[1][1] == sym && map [2][0] == sym ) return true;

        return false;
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("Ход игрока");

        do {
            System.out.print("Введите номер строки: ");
            rowNumber = scan.nextInt();
            System.out.print("Введите номер столбца: ");
            colNumber = scan.nextInt();
        } while ( !isCellValid(rowNumber, colNumber) );

        map[rowNumber - 1][ colNumber - 1] = DOT_X;
    }

    private static void aiTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("Ход компьютера");
        do {
            rowNumber = rand.nextInt(SIZE) + 1;
            colNumber = rand.nextInt(SIZE) + 1;
        } while ( !isCellValid(rowNumber, colNumber) );

        map[rowNumber - 1][ colNumber - 1] = DOT_O;
    }

    private static boolean isCellValid(int rowNumber, int colNumber) {
        if (rowNumber < 1 || rowNumber > SIZE )
            return false;
        if (colNumber < 1 || colNumber > SIZE )
            return false;

        return  map[rowNumber - 1][colNumber - 1] == DOT_EMPTY;
    }

    private static void initMap() {

        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE ; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    private static void printMap() {

        printMapHeader();
        printMapRows();

    }

    private static void printMapHeader() {

        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
        }
        System.out.println();

    }

    private static void printMapRows() {

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

}
