package lesson_2;

// 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
				
		int[] arr = new int[] { 1 , 2 , 3 , 4 , 5 , 6 , 7 };
		
		int n = 4 ;
		
		System.out.println( Arrays.toString( arr ) );
		
		arr = shiftArrayN( arr , n );
		
		System.out.println( Arrays.toString( arr ) );
		
	}
	
	public static int[] shiftArrayN ( int[] arr , int n ) {
		
		if ( arr.length == 0 || arr.length == 1 )
			return arr;
		
		if ( n > 0 ) {
			for( int i = 0 ; i < n ; i++ )
				arr = shiftRight( arr );
		} else if ( n < 0 ) {
			for( int i = 0 ; i > n ; i-- )
				arr = shiftLeft( arr );
		}
		
		return arr;
	}
	
	static int[] shiftLeft( int[] arr ) {
		int temp = arr[0];
		for( int i = 0 ; i < arr.length - 1 ; i++ )
			arr[ i ] = arr[ i + 1 ];
		arr[ arr.length - 1 ] = temp;
		return arr;
	}
	
	static int[] shiftRight( int[] arr ) {
		int temp = arr[ arr.length - 1 ];
		for ( int i = arr.length - 1 ; i > 0 ; i-- )
			arr[ i ] = arr[ i - 1 ];
		arr[ 0 ] = temp;
		return arr;
	}
	
}