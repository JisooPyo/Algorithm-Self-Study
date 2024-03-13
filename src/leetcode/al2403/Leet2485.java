package leetcode.al2403;

public class Leet2485 {
    public static void main(String[] args) {
        Leet2485 l = new Leet2485();
        System.out.println(l.pivotInteger(8));  // 6
        System.out.println(l.pivotInteger(1));  // 1
        System.out.println(l.pivotInteger(4));  // -1
    }

    public int pivotInteger(int n) {
        double x = Math.sqrt((double)(n * n + n) / 2);
        int answer = (int)x;
        return answer == x ? answer : -1;
    }
}
