package programmers.test2306.test230601;

public class Lev1_23_Other {
    public static void main( String[] args ) {
        Lev1_23_Other lev = new Lev1_23_Other();

        int[] t1 = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
        int[] t2 = { 1, 3, 2, 1, 2, 1, 3, 1, 2 };

        System.out.println( lev.solution( t1 ) );
        System.out.println( lev.solution( t2 ) );
    }

    public int solution( int[] ingredient ) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for ( int i : ingredient ) {
            stack[sp++] = i;
            if ( sp >= 4 && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1 ) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}
// 당연히 스택을 써야 할 거 같은데 스택을 쓰지 않고 배열만으로도 쉽고 빠르게 풀린다!

/*
테스트 1 〉	통과 (0.01ms, 75.8MB)
테스트 2 〉	통과 (0.02ms, 82.9MB)
테스트 3 〉	통과 (7.66ms, 88.5MB)
테스트 4 〉	통과 (11.99ms, 115MB)
테스트 5 〉	통과 (12.26ms, 139MB)
테스트 6 〉	통과 (11.62ms, 105MB)
테스트 7 〉	통과 (10.14ms, 92.8MB)
테스트 8 〉	통과 (8.58ms, 91.4MB)
테스트 9 〉	통과 (7.89ms, 97.4MB)
테스트 10 〉통과 (0.33ms, 79.9MB)
테스트 11 〉통과 (9.46ms, 100MB)
테스트 12 〉통과 (12.62ms, 126MB)
테스트 13 〉통과 (0.02ms, 74MB)
테스트 14 〉통과 (0.01ms, 72MB)
테스트 15 〉통과 (0.02ms, 85.9MB)
테스트 16 〉통과 (0.02ms, 76MB)
테스트 17 〉통과 (0.03ms, 74.6MB)
테스트 18 〉통과 (0.03ms, 74.1MB)
 */
