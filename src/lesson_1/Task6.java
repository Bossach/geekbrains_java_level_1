//6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;

package lesson_1;

public class Task6 {
    public static boolean isNeg( int a ) {
        if ( a < 0 ) {
            return true;
        } else {
            return false;
        }
    }
}
