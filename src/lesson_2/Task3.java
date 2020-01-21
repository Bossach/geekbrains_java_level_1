package lesson_2;

// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		int[] arr = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
		
		System.out.println( Arrays.toString( arr ) );
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			 if ( arr[ i ] < 6 )
			 arr [ i ] *= 2;
		}
		
		System.out.println( Arrays.toString( arr ) );		
		
	}
}