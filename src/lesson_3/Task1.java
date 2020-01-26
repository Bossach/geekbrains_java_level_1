package lesson_3;

// 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        final int tryCount = 3; //счётчик попыток
        final int maxNumber = 9; //максимальное число
        int number;
        int userNumber;

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        do {

            number = rand.nextInt(maxNumber + 1 );
            System.out.println( "Начало игры" );



            for ( int i = 0; i < tryCount; i++ ) {

                System.out.printf( "Угадай число от 0 до %d (Попыток осталось: %d): " , maxNumber, tryCount - i );
                userNumber = scan.nextInt();

                if ( userNumber == number ) {
                    System.out.printf( "Победа! Попыток использовано: %d\n" , i + 1 );
                    break;
                } else if ( userNumber > number ) {
                    System.out.println( "Слишком большое" );
                } else {
                    System.out.println( "Слишком маленькое" );
                }
            }


            System.out.print( "Игра окончена. Повторить?(1/0) :" );
            userNumber = scan.nextInt();

        } while ( userNumber != 0 );


        scan.close();       // <--- Вопрос насколко это обязательно, нужно ли вообще, зачем нужно и на что влияет?

    }
}
