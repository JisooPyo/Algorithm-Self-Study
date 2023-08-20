package programmers.test2304.test230412;

import java.util.Arrays;

public class CharStudy {

	public static void main(String[] args) {
		
		String str = "PYO JI SOO";
		
		char[] arr = str.toCharArray();
		System.out.println(Arrays.toString(arr));	// [P, Y, O,  , J, I,  , S, O, O]
		
		char[] reverseArr = new char[arr.length];
		
		for(int i=0; i<arr.length; i++){
            reverseArr[arr.length-1-i] = arr[i];
        }
		
		System.out.println(Arrays.toString(reverseArr));	// [O, O, S,  , I, J,  , O, Y, P]
		
		String reverseStr = new String(reverseArr);
		System.out.println(reverseStr); 			// OOS IJ OYP

	}

}
