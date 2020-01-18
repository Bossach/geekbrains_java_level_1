package lesson_2;

// 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		int[] arr = new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
		
		System.out.println( Arrays.toString( arr ) );
		
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			switch ( arr[i] ) {
				case 0:
					arr[ i ] = 1;
					break;
				case 1:
					arr[ i ] = 0;
			}
		}
		
		System.out.println( Arrays.toString( arr ) );		
		
	}
}