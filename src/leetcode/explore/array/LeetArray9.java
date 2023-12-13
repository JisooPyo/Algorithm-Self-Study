package leetcode.explore.array;

public class LeetArray9 {
    public static void main(String[] args) {
        LeetArray9 la = new LeetArray9();

        System.out.println(la.validMountainArray(new int[]{2, 1}));
        System.out.println(la.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(la.validMountainArray(new int[]{0, 3, 2, 1}));
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        if (arr[0] >= arr[1]) return false;
        int index = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                index = i;
                break;
            } else if (arr[i - 1] == arr[i]) {
                return false;
            }
        }
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i]) {
                return false;
            }
        }
        return true;
    }
}
