package programmers.test2304.test230416;

import java.util.Arrays;

public class SortingStringProblem {

	public static void main(String[] args) {
		
		SortingStringProblem ss = new SortingStringProblem();
		
		String x = "hi12392";
		String y = "p2o4i8gj2";
		String z = "abcde0";
		
		System.out.println(Arrays.toString(ss.solution(x)));
		System.out.println(Arrays.toString(ss.solution(y)));
		System.out.println(Arrays.toString(ss.solution(z)));
		
		
		
	}
	
    public int[] solution(String my_string) {
    	
        String string2 = my_string.replaceAll("[^0-9]", "");	// string2 = "12392"
        char[] arr = string2.toCharArray();	// arr = {"1","2","3","9","2"}
        int[] arr2 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Character.getNumericValue(arr[i]);
		}	//arr2 = {1,2,3,9,2};
		
		Arrays.sort(arr2);
        
        return arr2;
        
    }
}
