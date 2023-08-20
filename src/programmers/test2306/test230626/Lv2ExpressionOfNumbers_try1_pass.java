package programmers.test2306.test230626;

public class Lv2ExpressionOfNumbers_try1_pass {
    public static void main(String[] args) {
        Lv2ExpressionOfNumbers_try1_pass lv = new Lv2ExpressionOfNumbers_try1_pass();

        System.out.println(lv.solution(15));
        System.out.println(lv.solution(12));
        System.out.println(lv.solution(31));
        System.out.println(lv.solution(30));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        answer += 1;
        return answer;
    }
}

// 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는
// 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있다.
// 오... ㄴㅇㄱ...

/*
주어진 자연수를 x라 하고, a, b, c, d, k, n은 자연수라고 가정

1) x를 홀수개의 연속된 자연수의 합으로 표현할 수 있는 경우
- 1개 : b => 1*b [단, b >= 1]
- 3개 : b-1, b, b+1 => 3*b [단, b >= 2]
- 2a-1개 : b-(a-1), … b, …, b+(a-1) => (2a-1)*b [단, b >= a]

2) x를 짝수개의 연속된 자연수의 합으로 표현할 수 있는 경우
- 2개 : d-1, d => 1*(2d-1) [단, d >= 2]
- 4개 : d-2, d-1, d, d+1 => 2*(2d-1) [단, d >= 3]
- 2d개 : d-c, …, d, …, d+(c-1) => c*(2d-1) [단, d >= c+1]

3) 1)과 2)를 합쳐서 표현하면
- x = (2k-1)n [단, n>=k이면 홀수개, n
 */

/*
테스트 1 〉통과 (0.03ms, 74.3MB)
테스트 2 〉통과 (0.12ms, 72.9MB)
테스트 3 〉통과 (0.06ms, 75.5MB)
테스트 4 〉통과 (0.06ms, 73.4MB)
테스트 5 〉통과 (0.05ms, 70.1MB)
테스트 6 〉통과 (0.02ms, 76.9MB)
테스트 7 〉통과 (0.05ms, 82.6MB)
테스트 8 〉통과 (0.05ms, 76.7MB)
테스트 9 〉통과 (0.02ms, 72.3MB)
테스트 10 〉통과 (0.13ms, 64.6MB)
테스트 11 〉통과 (0.15ms, 81.2MB)
테스트 12 〉통과 (0.05ms, 75.7MB)
테스트 13 〉통과 (0.10ms, 70.9MB)
테스트 14 〉통과 (0.08ms, 76.6MB)
테스트 15 〉통과 (0.01ms, 73.8MB)
테스트 16 〉통과 (0.02ms, 71.4MB)
테스트 17 〉통과 (0.02ms, 77.4MB)
테스트 18 〉통과 (0.02ms, 73.5MB)

효율성  테스트
테스트 1 〉통과 (1.73ms, 52.7MB)
테스트 2 〉통과 (0.99ms, 52.5MB)
테스트 3 〉통과 (1.02ms, 51.8MB)
테스트 4 〉통과 (1.07ms, 52.3MB)
테스트 5 〉통과 (1.25ms, 51.9MB)
테스트 6 〉통과 (1.23ms, 52.1MB)
 */
