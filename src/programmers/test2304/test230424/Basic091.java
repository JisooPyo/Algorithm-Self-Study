package programmers.test2304.test230424;

public class Basic091 {

	public static void main(String[] args) {
		Basic091 b = new Basic091();

		String x = "rermgorpsam";
		int[][] y = { { 2, 3 }, { 0, 7 }, { 5, 9 }, { 6, 10 } };

		System.out.println(b.solution(x, y));

	}

	public String solution(String my_string, int[][] queries) {
		char[] c = my_string.toCharArray();
		char[] d = my_string.toCharArray();
		for (int i = 0; i < queries.length; i++) {
			int s = queries[i][0];
			int e = queries[i][1];
			for (int j = s; j <= e; j++) {
				d[j]=c[s+e-j];
			}
			c=new String(d).toCharArray();
		}
		return new String(d);
	}

}

/*

다른 사람의 풀이

class Solution {
    public String solution(String myString, int[][] queries) {
        for (int[] arr : queries) {
            myString =
            myString.substring(0, arr[0])
            + new StringBuilder(myString.substring(arr[0], arr[1] + 1)).reverse().toString()
            + myString.substring(arr[1] + 1);
        }
        return myString;
    }
}

*/