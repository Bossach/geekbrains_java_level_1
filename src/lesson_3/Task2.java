package lesson_3;

//2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
////При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
////сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//Для сравнения двух слов посимвольно, можно пользоваться:
//String str = "apple";
//str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//Играем до тех пор, пока игрок не отгадает слово
//Используем только маленькие буквы

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String answer;

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String word = words[ rand.nextInt( words.length ) ];
        System.out.println("Угадай слово");


        for (;;) {

            System.out.print("Слово: ");

            answer = scan.nextLine();

            if ( answer.equals( word ) ) {
                System.out.printf( "Порбеда! Слово %s\n", word );
                break;
            }


            for (int i = 0; i < 16; i++) {
                if ( i < word.length() && i < answer.length() ) {
                    if ( word.charAt( i ) == answer.charAt( i ) ) {
                        System.out.print( word.charAt( i ) );
                    } else {
                        System.out.print('#');
                    }
                } else {
                    System.out.print('#');
                }
            }

            System.out.println( "\nНеверно, попробуй ещё" );

        }

        scan.close();       // <--- Вопрос насколко это обязательно, нужно ли вообще, зачем нужно и на что влияет?

    }
}
