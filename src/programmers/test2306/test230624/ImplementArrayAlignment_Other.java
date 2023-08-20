package programmers.test2306.test230624;

import java.util.Arrays;

public class ImplementArrayAlignment_Other {
    public static void main(String[] args) {
        ImplementArrayAlignment_Other iaa = new ImplementArrayAlignment_Other();
        int[] t1 = {4, 3, 7, 5, 0};
        int[] t2 = {3, 1, 9, 0, 8};

        iaa.quickSort(t1, 0, t1.length - 1);
        iaa.quickSort(t2, 0, t2.length - 1);

        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(t2));

    }

    public void quickSort(int[] arr, int left, int right) {
        int i, j, pivot, tmp;

        if (left < right) {
            i = left;
            j = right;
            pivot = arr[left];
            //분할 과정
            while (i < j) {
                while (arr[j] > pivot) j--;
                while (i < j && arr[i] <= pivot) i++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            arr[left] = arr[i];
            arr[i] = pivot;
            //정렬 과정
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}
