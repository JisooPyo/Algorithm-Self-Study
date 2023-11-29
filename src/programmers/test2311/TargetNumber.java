// 타겟 넘버
package programmers.test2311;

public class TargetNumber {
    public static void main(String[] args) {
        TargetNumber tn = new TargetNumber();

        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};

        System.out.println(tn.solution(numbers1, 3));
        System.out.println(tn.solution(numbers2, 4));
    }

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }
}
