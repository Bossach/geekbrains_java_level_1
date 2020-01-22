package lesson_2;

// 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.

import java.util.Arrays;

public class Task6 {
	public static void main(String[] args) {
		
		
		int[] emptyArr = new int[] {};
		
		int[] trueArr1 = new int[] { 3 , 3 };
		
		int[] trueArr2 = new int[] { 1 , 2 , 3 };
		
		int[] falseArr = new int [] { 2 , 2 , 3 , 3 };
		
		
		System.out.println( Arrays.toString( emptyArr ) );
		System.out.println( checkBalance( emptyArr ) + "\n");
		
		System.out.println( Arrays.toString( trueArr1 ) );
		System.out.println( checkBalance( trueArr1 ) + "\n");
		
		System.out.println( Arrays.toString( trueArr2 ) );
		System.out.println( checkBalance( trueArr2 ) + "\n");
		
		System.out.println( Arrays.toString( falseArr ) );
		System.out.println( checkBalance( falseArr ) + "\n");
				
	}
	
	
	public static boolean checkBalance( int[] arr ) {
		
		for( int i = 1 ; i < arr.length ; i++ ) {
			int leftSum = 0;
			int rightSum = 0;
			for( int j = 0 ; j < i ; j++ )
				leftSum += arr [ j ];
			for( int j = i ; j < arr.length ; j++ )
				rightSum += arr[ j ];
			if ( leftSum == rightSum )
				return true;
		}		
		return false;
	}
}