//4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;

package lesson_1;

public class Task4 {
    public static boolean sumCheck ( double a , double b ) {
        if ( a + b >= 10 && a + b <= 20 ) {
            return true;
        } else {
            return false;
        }
    }
}
