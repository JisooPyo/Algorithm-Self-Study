package leetcode.al2407;

/**
 Easy
 2582. Pass the Pillow

 1부터 n까지 라벨링되어 있는 선에 서 있는 n명의 사람들이 있다.
 선에 서 있는 첫 번째 사람은 베개를 가지고 있다.
 매 초에 베개를 가지고 있는 사람은 선에 서 있는 다음 사람에게 베개를 넘긴다.
 베개가 줄의 끝에 도착하면 방향이 바뀌고 사람들은 반대 방향으로 베개를 넘기는 것을 계속한다.
 (예를 들어, n번째 사람에개 베개가 도착하면 이 베개는 다시 n-1, n-2 번째 사람에게 차례로 전해진다.)
 n과 time 두 양의 정수가 주어진다. time seconds 이후 pillow를 들고 있는 사람의 index를 구하여라.
 */
public class Leet2582 {
    public static void main(String[] args) {
        Leet2582 l = new Leet2582();

        System.out.println(l.passThePillow(4, 5));  // 2
        System.out.println(l.passThePillow(3, 2));  // 3
    }

    // 1 2 3 4 3 2 / 1 2 3 4 3 2
    // 0 1 2 3 4 5 / 6 7 8 9 10 11
    // 1. time 을 n*2-1-1 로 나눈 나머지를 구한다.
    // - 나머지가 n보다 크거나 같다면
    //   - 5, 4 => n-(r-n+1) return
    //             2n-r-1 return
    // - 나머지가 n보다 적다면
    //   - 0,1,2,3 => 나머지 + 1 리턴.
    // 내 풀이 : 12m
    // runtime : 0ms
    public int passThePillow(int n, int time) {
        int remainder = time % (2 * n - 2);
        if (remainder >= n) {
            return 2 * n - remainder - 1;
        } else {
            return remainder + 1;
        }
    }
}
