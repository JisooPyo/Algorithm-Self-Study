package leetcode.explore.queueStack;

import java.util.Arrays;

public class Conclusion2 {
    public static void main(String[] args) {
        Conclusion2 c = new Conclusion2();
        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr1 = 1;
        int sc1 = 1;
        int color1 = 2;

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        int sr2 = 0;
        int sc2 = 0;
        int color2 = 0;

        System.out.println(Arrays.deepToString(c.floodFill(image1, sr1, sc1, color1)));
        System.out.println(Arrays.deepToString(c.floodFill(image2, sr2, sc2, color2)));
    }

    int fixedColor;
    boolean[][] visited;
    int compare;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];
        fixedColor = color;
        compare = image[sr][sc];
        color(image, sr, sc);
        return image;
    }

    private void color(int[][] image, int x, int y) {
        visited[x][y] = true;
        image[x][y] = fixedColor;
        if (x != 0 && !visited[x - 1][y] && image[x - 1][y] == compare) {
            color(image, x - 1, y);
        }
        if (y != 0 && !visited[x][y - 1] && image[x][y - 1] == compare) {
            color(image, x, y - 1);
        }
        if (x != image.length - 1 && !visited[x + 1][y] && image[x + 1][y] == compare) {
            color(image, x + 1, y);
        }
        if (y != image[0].length - 1 && !visited[x][y + 1] && image[x][y + 1] == compare) {
            color(image, x, y + 1);
        }
    }
}
