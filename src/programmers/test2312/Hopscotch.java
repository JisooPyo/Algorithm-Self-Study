package programmers.test2312;

public class Hopscotch {
    public static void main(String[] args) {
        Hopscotch h = new Hopscotch();

        int[][] land1 = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(h.solution(land1));
    }

    int[][] sum;

    int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        sum = new int[land.length][4];
        for (int i = 0; i < 4; i++) {
            sum[0][i] = land[0][i];
        }
        getRowSum(land, sum.length - 1);
        for (int i = 0; i < 4; i++) {
            if (answer < sum[sum.length - 1][i]) {
                answer = sum[sum.length - 1][i];
            }
        }
        return answer;
    }

    private int[] getRowSum(int[][] land, int index) {
        if (index == 0) {
            return sum[0];
        }
        int[] previousRow = getRowSum(land, index - 1);
        for (int i = 0; i < 4; i++) {
            sum[index][i] = getMax(previousRow, i) + land[index][i];
        }
        return sum[index];
    }

    private int getMax(int[] row, int exclude) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row.length; i++) {
            if (i == exclude) {
                continue;
            }
            if (max < row[i]) {
                max = row[i];
            }
        }
        return max;
    }
}
