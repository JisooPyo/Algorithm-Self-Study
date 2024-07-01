package leetcode.al2407;

/**
 정수 배열 arr이 주어진다.
 만약 배열 안에 연속적으로 홀수가 세 개 있다면 true, 아니면 false를 return하라.
 */
public class Leet1550 {
    public static void main(String[] args) {
        Leet1550 l = new Leet1550();

        int[] arr1 = {2, 6, 4, 1};
        int[] arr2 = {1, 2, 34, 3, 4, 5, 7, 23, 12};

        System.out.println(l.threeConsecutiveOdds(arr1));   // false
        System.out.println(l.threeConsecutiveOdds(arr2));   // true
    }

    // 내 풀이

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
