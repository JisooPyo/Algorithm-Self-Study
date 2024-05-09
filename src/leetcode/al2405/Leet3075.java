package leetcode.al2405;

import java.util.Arrays;

/**
 * 3075. Maximize Happiness of Selected Children
 *
 * Given
 * happiness: 길이 n의 정수 배열
 * k: 양의 정수
 *
 *
 */
public class Leet3075 {
    public static void main(String[] args) {
        Leet3075 l = new Leet3075();

        int[] happiness1 = {1, 2, 3};
        int[] happiness2 = {1, 1, 1, 1};
        int[] happiness3 = {2, 3, 4, 5};

        System.out.println(l.maximumHappinessSum(happiness1, 2));       // 4
        System.out.println(l.maximumHappinessSum(happiness2, 2));       // 1
        System.out.println(l.maximumHappinessSum(happiness3, 1));       // 5
    }

    // 내 풀이 : 33ms
    // 시간복잡도 : O(N log N)
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int index = happiness.length - 1;
        int minus = 0;
        long sum = 0;
        while (k > 0) {
            if (happiness[index] - minus <= 0) {
                break;
            } else {
                sum += happiness[index] - minus;
            }
            minus++;
            index--;
            k--;
        }
        return sum;
    }

    // 다른 사람 풀이 : 12ms
    // 직접 이진 탐색과 정렬을 구현하였다. 내 풀이와 시간복잡도는 O(n log n)으로 동일하다.
    public long maximumHappinessSum2(int[] happiness, int k) {

        int left = 0, right = k;
        while(left < right){
            int mid = left + right >> 1;
            if(check(happiness, mid))
                left = mid + 1;
            else
                right = mid;
        }

        k = left;
        int n = happiness.length;
        quickSort(happiness, 0, n - 1, n - k);
        long sum = -(long)k * (k - 1) >> 1;
        for(int i = n -1; k-- > 0; --i)
            sum += happiness[i];

        return sum;
    }

    public boolean check(int[] happiness, int mid) {
        int count = 0;
        for(int x:happiness){
            if(x < mid) continue;
            if(++count > mid)
                return true;
        }

        return false;
    }

    private void quickSort(int nums[], int low, int high, int k) {
        if (low == high)
            return;

        int left = low - 1, right = high + 1, mid = low + high >> 1;
        int x = nums[mid];
        while (left < right) {
            while (nums[++left] < x) continue;
            while (nums[--right] > x) continue;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        if (right < k)
            quickSort(nums, right + 1, high, k);
        else
            quickSort(nums, low, right, k);
    }
}
