package leetcode.explore.array;

public class LeetArray8 {
    public static void main(String[] args) {
        LeetArray8 la = new LeetArray8();
        int[] arr = {7, 1, 14, 11};

        System.out.println(la.checkIfExist(arr));
    }

    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (arr[i] * 2 == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
