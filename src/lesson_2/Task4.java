package lesson_2;

// 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

import java.util.Arrays;

public class Task4 {
	public static void main(String[] args) {
		
		int squareArrSize = 8;
		
		int[][] squareArr = new int[ squareArrSize ][ squareArrSize ];
		
		for ( int i = 0 ; i < squareArr.length ; i++ )
			System.out.println( Arrays.toString( squareArr [ i ]) );
		System.out.println("------------------------");
		
		
		for ( int i = 0 ; i < squareArr.length ; i++ ) {
			 squareArr[ i ][ i ] = 1;
			 squareArr[ i ][ squareArr.length - i - 1 ] = 1;
		}
		
		for ( int i = 0 ; i < squareArr.length ; i++ )
			System.out.println( Arrays.toString( squareArr[ i ] ) );		
		
	}
}