package leetcode.explore.array;

import java.util.Arrays;

public class LeetArray10 {
    public static void main(String[] args) {
        LeetArray10 la10 = new LeetArray10();

        int[] arr1 = {17, 18, 5, 4, 6, 1};
//					  0    1 2  3  4 5
//				     18   6 6  6  1 -1
        int[] arr2 = {400};

        System.out.println(Arrays.toString(la10.replaceElements(arr1)));
        System.out.println(Arrays.toString(la10.replaceElements(arr2)));
    }

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return new int[]{-1};
        }
        int[] answer = Arrays.copyOf(arr, len);    // [17, 18, 5, 4, 6, 1]
        int max = arr[len - 1];        // 1
        answer[len - 1] = -1;        // [17, 18, 5, 4, 6, -1]
        answer[len - 2] = max;        // [17, 18, 5, 4, 1, -1]
        if (len == 2) {
            return answer;
        }
        for (int i = len - 3; i >= 0; i--) {
            if (max < arr[i + 1]) {
                max = arr[i + 1];
            }
            answer[i] = max;
        }
        return answer;
    }

}
