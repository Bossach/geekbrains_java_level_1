//8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

package lesson_1;

public class Task8 {
    public static void isVis( int year ) {
        if ( ( year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0 ) {
            System.out.println("Високосный");
        } else {
            System.out.println("Не високосный");
        }
    }
}
