package lesson_2;

// 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		int[] arr = new int[ 8 ];
		
		
		
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			arr[ i ] = 3 * i ;
		}
		
		System.out.println( Arrays.toString( arr ) );		
		
	}
}