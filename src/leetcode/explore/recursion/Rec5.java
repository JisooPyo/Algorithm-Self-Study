package leetcode.explore.recursion;

import java.util.ArrayList;
import java.util.List;

public class Rec5 {
    public static void main(String[] args) {
        Rec5 r = new Rec5();
        System.out.println(r.getRow(3));
        System.out.println(r.getRow(0));
        System.out.println(r.getRow(1));
    }

    int[][] record;

    public List<Integer> getRow(int rowIndex) {
        record = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(getNumber(rowIndex, i));
        }
        return list;
    }

    public int getNumber(int i, int j) {
        if (record[i][j] != 0) {
            return record[i][j];
        }
        if (j == 0 || i == j) {
            record[i][j] = 1;
            return 1;
        }
        if (record[i - 1][j - 1] == 0) {
            record[i - 1][j - 1] = getNumber(i - 1, j - 1);
        }
        if (record[i - 1][j] == 0) {
            record[i - 1][j] = getNumber(i - 1, j);
        }
        record[i][j] = record[i - 1][j - 1] + record[i - 1][j];
        return record[i][j];
    }
}
