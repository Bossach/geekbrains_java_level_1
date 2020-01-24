package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeNew {
    private static final int SIZE_X = 3;
    private static final int SIZE_Y = 3;
    private static final int DOTS_TO_WIN = 3;

    private static final int PLAYERS_COUNT = 2;
    private static boolean[] IS_PLAYER_HUMAN = new boolean[PLAYERS_COUNT];  //All players is AI by default
    private static final char[] PLAYER_CHARS = { '•' , 'X' , 'O' } ;  //PLAYER_CHARS[ 0 ] is empty

    private static char[][] map = new char[SIZE_X][SIZE_Y];
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        IS_PLAYER_HUMAN[0] = true; //Make first player human

        playGame();

    }

    private static void playGame() {

        while ( true ) {
            for (int player = 1; player <= PLAYERS_COUNT; player++) {
                 if ( playerTurn( player ) ) return;
            }
        }
    }

    private static boolean playerTurn(int player) {

        if ( IS_PLAYER_HUMAN[ player - 1 ] ) {
            humanTurn( player );
        } else {
            aiTurn( player );
        }

        printMap();

        if ( checkWin( player ) ) {
            System.out.printf("Победил игрок \"%c\"!\n", PLAYER_CHARS[player] );
            return true;
        }
        if ( checkDraw() ) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static void aiTurn(int player) {
        int x;
        int y;

        System.out.printf("Ход компьютера \"%c\".\n" , PLAYER_CHARS[player] );
        do {
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        } while ( !isCellEmpty(x, y) );

        map[x][y] = PLAYER_CHARS[player];
    }

    private static void humanTurn(int player) {

        System.out.printf("Ход игрока \"%c\".\n" , PLAYER_CHARS[player] );

        String input;
        int x;
        int y;


        do {
            //Ввод строки
            while (true) {
                System.out.printf("Ведите строку ( %c - %c ) : ", 'a', (char) ((int) 'a' + SIZE_X - 1));
                input = scan.nextLine();

                if (input.length() == 1) {
                    int charNumber = (int) (input.toLowerCase().toCharArray()[0]);
                    if (charNumber >= (int) 'a' && charNumber <= (int) 'a' + SIZE_X - 1) {
                        x = charNumber - (int) 'a';
                        break;
                    }
                }
                System.out.println("Некорректный ввод");
            }
            //Ввод столбца
            while (true) {
                System.out.printf("Ведите столбец ( %d - %d ) : ", 1, SIZE_Y);
                input = scan.nextLine();
                int inputInt;
                try {
                    inputInt = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод");
                    continue;
                }
                if (inputInt > 0 && inputInt <= SIZE_Y) {
                    y = inputInt - 1;
                    break;
                }
                System.out.println("Некорректный ввод");
            }

            if ( isCellEmpty( x , y ) ) break;
            System.out.println("Клетка занята.");
        } while ( true );

        map[x][y] = PLAYER_CHARS[player];

    }

    private static boolean isCellEmpty(int x, int y) {
        return map[x][y] == PLAYER_CHARS[0];
    }

    private static boolean checkWin(int player) {
        char sym = PLAYER_CHARS[ player ];
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

    private static boolean checkDraw() {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if ( map[i][j] == PLAYER_CHARS[0] ) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void initMap () {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                map[i][j] = PLAYER_CHARS[0];
            }
        }
    }

    private static void printMap() {
        //head
        System.out.print("  ");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print(( i+1 ) + " " );
        }
        System.out.println();
        //body
        for (int i = 0; i < SIZE_X; i++) {
            System.out.print( (char)( (int)'a' + i ) + " " );
            for (int j = 0; j < SIZE_Y; j++) {
                System.out.print( map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
