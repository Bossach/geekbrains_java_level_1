package lesson_2;

// 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

import java.util.Arrays;

public class Task5 {
	public static void main(String[] args) {
		
		int arrSize = 14;
		
		int[] arr = new int[ arrSize ];
		
		for ( int i = 0 ; i < arr.length ; i++ )
			arr[ i ] = (int) ( Math.random() * 100 - 50 );
		
		
		System.out.println( Arrays.toString( arr ) );
		
		
		int max = 0, min = 0;  // Компилятор ругался что переменная может быть не инициализирована, поэтому пришлось присваивать по 2 раза
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			 if ( i == 0 ) {
			 	max = arr [ 0 ];
			 	min = arr[ 0 ];
			 }
			 if ( arr[ i ] > max )
			 	max = arr[ i ];
			 if ( arr[ i ] < min )
			 	min = arr[ i ];
		}
		
		
		System.out.println("Max = " + max );
		System.out.println("Min  = " + min );
		
		
	}
}