package leetcode.al2405;

import java.util.Arrays;

/**
 * 506. Relative Ranks
 *
 * Given
 * score: size n의 정수 배열
 *        score[i]는 i번째 선수의 경기 점수
 *        모든 점수는 unique하다.
 *
 * 1등 선수는 "Gold Medal"
 * 2등 선수는 "Silver Medal"
 * 3등 선수는 "Bronze Medeal"
 * 4등 부터는 등수로 치환하여 반환한다.
 */
public class Leet506 {
    public static void main(String[] args) {
        Leet506 l = new Leet506();

        int[] score1 = {5, 4, 3, 2, 1};
        int[] score2 = {10, 3, 8, 9, 4};

        System.out.println(Arrays.toString(l.findRelativeRanks(score1)));
        System.out.println(Arrays.toString(l.findRelativeRanks(score2)));
        System.out.println(Arrays.toString(l.findRelativeRanksOther(score1)));
        System.out.println(Arrays.toString(l.findRelativeRanksOther(score2)));
    }

    // 내 풀이 -> Arrays.sort() 사용
    public String[] findRelativeRanks(int[] score) {
        int[][] indexes = new int[score.length][2];
        for (int i = 0; i < score.length; i++) {
            indexes[i][0] = i;
            indexes[i][1] = score[i];
        }
        Arrays.sort(indexes, (a, b) -> b[1] - a[1]);

        String[] ranks = new String[score.length];
        for (int i = 0; i < indexes.length; i++) {
            switch (i) {
                case 0:
                    ranks[indexes[i][0]] = "Gold Medal";
                    break;
                case 1:
                    ranks[indexes[i][0]] = "Silver Medal";
                    break;
                case 2:
                    ranks[indexes[i][0]] = "Bronze Medal";
                    break;
                default:
                    ranks[indexes[i][0]] = String.valueOf(i + 1);
            }
        }

        return ranks;
    }

    // 다른 사람의 풀이
    // 정렬을 사용하지 않고 최대점수만큼의 배열을 만들어 시간을 단축시켰다.
    //    -> 하지만 공간은 더 사용하였다.
    // Gold Medal, Sliver Medal, Bronze Medal의 값을 배열에 저장하여 사용하였다.

    // 점수 범위가 작다면 이 방법이, 점수 범위가 크다면 내 방법이 효율적이고,
    // 정해진 문자열의 경우 배열에 저장해 놓는것이 효율적인 것 같다.
    private int findMax(int[] score) {
        int maxScore = 0;
        for (int s : score) {
            if (s > maxScore) {
                maxScore = s;
            }
        }
        return maxScore;
    }

    public String[] findRelativeRanksOther(int[] score) {
        int N = score.length;

        // 최대 점수 + 1 만큼의 배열을 만들어 해당 점수가 index인 곳에 index를 기록해놓는다.
        // ex. score: [10, 3, 8, 9, 4]
        // scoreToIndex: [0, 0, 0, 2, 5, 0, 0, 0, 3, 4, 1]
        int M = findMax(score);
        int[] scoreToIndex = new int[M + 1];
        for (int i = 0; i < N; i++) {
            scoreToIndex[score[i]] = i + 1;
        }

        // String을 미리 저장해놓는다.
        final String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        String[] rank = new String[N];
        int place = 1;
        for (int i = M; i >= 0; i--) {
            if (scoreToIndex[i] != 0) {
                int originalIndex = scoreToIndex[i] - 1;
                if (place < 4) {
                    rank[originalIndex] = MEDALS[place - 1];
                } else {
                    rank[originalIndex] = String.valueOf(place);
                }
                place++;
            }
        }
        return rank;
    }
}
