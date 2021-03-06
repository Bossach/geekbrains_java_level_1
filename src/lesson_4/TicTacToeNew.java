package lesson_4;

import lesson_8.GToeWindow;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeNew {
    private static final int SIZE_X = 3;
    private static final int SIZE_Y = 3;
    private static final int DOTS_TO_WIN = 3;

    private static final int PLAYERS_COUNT = 2; //!! Чтобы добавить более 4 игроков дописать вручную в массив PLAYER_CHARS символы
    private static final char[] PLAYER_CHARS = { '•' , 'X' , 'O' , '#' , 'Δ' } ;  //PLAYER_CHARS[ 0 ] is empty, 4 players available default

    private static boolean[] IS_PLAYER_HUMAN = new boolean[PLAYERS_COUNT];  //All players is AI by default
    private static final boolean IS_GRAPHICS = true;  //Флаг работы в графическом режиме
    private static GToeWindow window;
    private static boolean isGameEnd = false;

    private static char[][] map = new char[SIZE_X][SIZE_Y];
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {

        IS_PLAYER_HUMAN[0] = true; //Make first player human // закомментировать чтобы играл только ИИ
        //IS_PLAYER_HUMAN[1] = true; //Make second player human // раскомментировать чтобы играть вдвоём

        if (IS_GRAPHICS) {
            window = new GToeWindow(SIZE_X, SIZE_Y);
            while (true) {
                playGame();
            }
        }


        String input;

        do {
            playGame();

            System.out.print("Повторить? ( 0 - выход , что угодно - повторить игру) : ");
            input = scan.nextLine();
        } while ( !input.equals("0") );
    }

    private static void playGame() {
        initMap();
        printMap();
        isGameEnd = false;

        while ( true) {
            for (int player = 1; player <= PLAYERS_COUNT; player++) {

                if (!isGameEnd) {
                    isGameEnd = playerTurn(player);
                }
                if (IS_GRAPHICS) {                  //если графика ждём кнопки рестарт
                    if (window.getRestartFlag()) {
                        window.resRestartFlag();
                        return;
                    }
                } else if (isGameEnd) {
                    return;
                }       //если не графика и ира окончена рестартуем автоматом
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
            message("Победил игрок \"" + PLAYER_CHARS[player] + "\"!\n");
            return true;
        }
        if ( checkDraw() ) {
            message("Ничья!");
            return true;
        }
        return false;
    }

    private static void message(String mes) {
        if (IS_GRAPHICS) {
            window.GPrintMessage(mes);
        } else {
            System.out.println(mes);
        }
    }

    private static void aiTurn(int thisPlayer) {

        int[] pt; //точка с координатами

        message("Ход компьютера \"" + PLAYER_CHARS[thisPlayer] + "\".");

        try {
            Thread.sleep(600l);    //Искуственная задержка хода компьютера
        } catch (InterruptedException e) {
        }

        pt = winPoint( thisPlayer );  //ищем победный ход

        if ( pt[0] == -1 ) {  //если не нашли ищем кого заблокировать
            for (int player = ( thisPlayer + 1 ) % ( PLAYERS_COUNT + 1 ) ; player != thisPlayer ; player = ( player + 1 ) % ( PLAYERS_COUNT + 1) ) {  //пробегаемся по всем игрокам кроме себя, начиная с тех кто ходит следующим
                if ( player != 0 ) {  //пропускаем "нулевого" пустого игрока ( нечего блокировать ходы пустого места :) )
                    pt = winPoint( player );  //ищем победную позицию для соперника
                    if ( pt[0] != -1 ) break;  //если уже нашли выходим из цикла
                }
            }
        }

        if ( pt[0] == -1) {  //если никаких полезных позиций не найдено, ходим рандомно
            do {
                pt[0] = rand.nextInt(SIZE_X);
                pt[1] = rand.nextInt(SIZE_Y);
            } while (!isCellEmpty(pt[0], pt[1]));
        }


        map[ pt[0] ][ pt[1] ] = PLAYER_CHARS[thisPlayer];
    }

    private static int[] winPoint(int player) {  //Возвращает координатыы выигрышной точки в виде массива int[] { x , y } для игрока player. Если такой нет, то возвращается { -1 , -1 }

        int[] point = new int[] { -1 , -1 };


        char sym = PLAYER_CHARS[ player ];
        String line;

        String winLine = ""; //создаём образец выигрышной комбинации
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            winLine += sym;
        }

        //horisontal checks
        for (int i = 0; i < SIZE_X; i++) {
            line = "";
            for (int j = 0; j < SIZE_Y; j++) {
                //Превращаем линию в строку
                if ( isCellValid( i , j ) ) {
                    line += map[i][j];
                } else {
                    line += " ";
                }
                //
            }
            //ищем в линии выигрышный ход
            if ( line.trim().length() >= DOTS_TO_WIN ) { //если в этой линии вообще поместится выигрышная комбинация
                char[] lineArray = line.toCharArray();
                char[] tempArray;

                for (int j = 0; j < lineArray.length ; j++) { //пробегаемся по строке
                    if( isCellEmpty( i , j ) ) { //если сюда можно походить
                        tempArray = lineArray.clone();
                        tempArray[j] = sym ; //пробуем ходить
                        if ( String.valueOf(tempArray).contains(winLine) ) {  //если получилась выигрышная строка
                            point[0] = i;
                            point[1] = j;
                            return point;
                        }
                    }
                }
            }
            //
        }
        //vertical checks
        for (int i = 0; i < SIZE_Y; i++) {
            line = "";
            for (int j = 0; j < SIZE_X; j++) {
                //Превращаем линию в строку
                if ( isCellValid( j , i ) ) {
                    line += map[j][i];
                } else {
                    line += " ";
                }
                //
            }
            //ищем в линии выигрышный ход
            if ( line.trim().length() >= DOTS_TO_WIN ) { //если в этой линии вообще поместится выигрышная комбинация
                char[] lineArray = line.toCharArray();
                char[] tempArray;

                for (int j = 0; j < lineArray.length ; j++) { //пробегаемся по строке
                    if( isCellEmpty( j , i ) ) { //если сюда можно походить
                        tempArray = lineArray.clone();
                        tempArray[j] = sym ; //пробуем ходить
                        if ( String.valueOf(tempArray).contains(winLine) ) {  //если получилась выигрышная строка
                            point[0] = j;
                            point[1] = i;
                            return point;
                        }
                    }
                }
            }
            //
        }
        //diagonal one checks
        for (int i = 0 - SIZE_Y; i < SIZE_X; i++) {
            line = "";
            for (int j = 0; j < SIZE_Y; j++) {
                //Превращаем линию в строку
                if ( isCellValid( i + j , j ) ) {
                    line += map[i + j][j];
                } else {
                    line += " ";
                }
                //
            }
            //ищем в линии выигрышный ход
            if ( line.trim().length() >= DOTS_TO_WIN ) { //если в этой линии вообще поместится выигрышная комбинация
                char[] lineArray = line.toCharArray();
                char[] tempArray;

                for (int j = 0; j < lineArray.length ; j++) { //пробегаемся по строке
                    if( isCellEmpty( i + j , j ) ) { //если сюда можно походить
                        tempArray = lineArray.clone();
                        tempArray[j] = sym ; //пробуем ходить
                        if ( String.valueOf(tempArray).contains(winLine) ) {  //если получилась выигрышная строка
                            point[0] = i + j;
                            point[1] = j;
                            return point;
                        }
                    }
                }
            }
            //
        }
        //diagonal two checks
        for (int i = 0; i < SIZE_X + SIZE_Y; i++) {
            line = "";
            for (int j = 0; j < SIZE_Y; j++) {
                //Превращаем линию в строку
                if ( isCellValid( i - j , j ) ) {
                    line += map[i - j][j];
                } else {
                    line += " ";
                }
                //
            }
            //ищем в линии выигрышный ход
            if ( line.trim().length() >= DOTS_TO_WIN ) { //если в этой линии вообще поместится выигрышная комбинация
                char[] lineArray = line.toCharArray();
                char[] tempArray;

                for (int j = 0; j < lineArray.length ; j++) { //пробегаемся по строке
                    if( isCellEmpty( i - j , j ) ) { //если сюда можно походить
                        tempArray = lineArray.clone();
                        tempArray[j] = sym ; //пробуем ходить
                        if ( String.valueOf(tempArray).contains(winLine) ) {  //если получилась выигрышная строка
                            point[0] = i - j;
                            point[1] = j;
                            return point;
                        }
                    }
                }
            }
            //
        }


        return point;
    }

    private static void humanTurn(int player) {

        message("Ход игрока \"" + PLAYER_CHARS[player] + "\"");

        if (IS_GRAPHICS) {
            int[] pt = window.getPoint();

            while(true) {
                if (window.getRestartFlag()) return;
                if(pt[0] != -1 && isCellEmpty(pt[0], pt[1])) {
                    map[pt[0]][pt[1]] = PLAYER_CHARS[player];
                    window.resPoint();
                    return;
                }
                pt = window.getPoint();
            }
        }

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
        if ( isCellValid( x , y ) ) {
            return map[x][y] == PLAYER_CHARS[0];
        }
        return false;
    }

    private static boolean isCellValid( int x , int y ) {
        return x >= 0 && y >= 0 && x < SIZE_X && y < SIZE_Y;
    }

    private static boolean checkWin(int player) {
        char sym = PLAYER_CHARS[ player ];
        int counter;
        //horisontal checks
        for (int i = 0; i < SIZE_X; i++) {
            counter = 0;
            for (int j = 0; j < SIZE_Y; j++) {
                if ( map[i][j] == sym ) {
                    counter++;
                } else {
                    counter = 0;
                }
                if ( counter >= DOTS_TO_WIN ) return true;
            }
        }
        //vertical checks
        for (int i = 0; i < SIZE_Y; i++) {
            counter = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if ( map[j][i] == sym ) {
                    counter++;
                } else {
                    counter = 0;
                }
                if ( counter >= DOTS_TO_WIN ) return true;
            }
        }
        //diagonal one checks
        for (int i = 0 - SIZE_Y; i < SIZE_X; i++) {
            counter = 0;
            for (int j = 0; j < SIZE_Y; j++) {
                if ( i + j >= 0 && i + j < SIZE_X ) {
                    if ( map[i + j][j] == sym ) {
                        counter++;
                    } else {
                        counter = 0;
                    }
                    if ( counter >= DOTS_TO_WIN ) return true;
                }
            }
        }
        //diagonal two checks
        for (int i = 0; i < SIZE_X + SIZE_Y; i++) {
            counter = 0;
            for (int j = 0; j < SIZE_Y; j++) {
                if ( i - j >= 0 && i - j < SIZE_X ) {
                    if ( map[i - j][j] == sym ) {
                        counter++;
                    } else {
                        counter = 0;
                    }
                    if ( counter >= DOTS_TO_WIN ) return true;
                }
            }
        }

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

        if (IS_GRAPHICS) {
            for (int i = 0; i < SIZE_X; i++) {
                for (int j = 0; j < SIZE_Y; j++) {
                    window.GPrintField(map);
                }
            }
            return;
        }

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
