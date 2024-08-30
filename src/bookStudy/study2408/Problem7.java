package bookStudy.study2408;

/**
 * 프로그래머스 lv.2
 * 방문 길이
 */
public class Problem7 {
    public static void main(String[] args) {
        Problem7 p = new Problem7();
        System.out.println(p.solution("ULURRDLLU"));            // 7
        System.out.println(p.solution("LULLLLLLU"));            // 7
        System.out.println(p.solution("LLLLLLUURRRDDLURL"));    // 14
        System.out.println(p.solution("UDLRDURL"));             // 4
        System.out.println(p.solution("LLLLRLRLRLL"));          // 5
        System.out.println(p.solution("UUUUDUDUDUUU"));         // 5
    }

    // 시간복잡도: O(N)
    public int solution(String dirs) {
        // 세로는 밑, 가로는 왼쪽이 출발점
        boolean[][] seroVisited = new boolean[11][10];
        boolean[][] garoVisited = new boolean[10][11];

        // L: 도착한 좌표, R: 출발한 좌표, U: 출발한 좌표, D: 도착한 좌표
        int answer = 0;
        int coorX = 0;
        int coorY = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            if (ch == 'L' && -5 < coorX) {
                coorX -= 1;
                if (!garoVisited[coorX + 5][coorY + 5]) {
                    answer++;
                    garoVisited[coorX + 5][coorY + 5] = true;
                }
            } else if (ch == 'R' && coorX < 5) {
                if (!garoVisited[coorX + 5][coorY + 5]) {
                    answer++;
                    garoVisited[coorX + 5][coorY + 5] = true;
                }
                coorX += 1;
            } else if (ch == 'U' && coorY < 5) {
                if (!seroVisited[coorX + 5][coorY + 5]) {
                    answer++;
                    seroVisited[coorX + 5][coorY + 5] = true;
                }
                coorY += 1;
            } else if (ch == 'D' && -5 < coorY) {
                coorY -= 1;
                if (!seroVisited[coorX + 5][coorY + 5]) {
                    answer++;
                    seroVisited[coorX + 5][coorY + 5] = true;
                }
            }
        }
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.04ms, 75.4MB)
테스트 2 〉	통과 (0.03ms, 73.9MB)
테스트 3 〉	통과 (0.03ms, 71.9MB)
테스트 4 〉	통과 (0.03ms, 70.4MB)
테스트 5 〉	통과 (0.06ms, 74.5MB)
테스트 6 〉	통과 (0.05ms, 83.7MB)
테스트 7 〉	통과 (0.04ms, 76.6MB)
테스트 8 〉	통과 (0.06ms, 74.7MB)
테스트 9 〉	통과 (0.04ms, 81.3MB)
테스트 10 〉	통과 (0.04ms, 72.9MB)
테스트 11 〉	통과 (0.04ms, 77.3MB)
테스트 12 〉	통과 (0.05ms, 72MB)
테스트 13 〉	통과 (0.04ms, 74.7MB)
테스트 14 〉	통과 (0.04ms, 66.1MB)
테스트 15 〉	통과 (0.04ms, 82.2MB)
테스트 16 〉	통과 (0.06ms, 73.2MB)
테스트 17 〉	통과 (0.06ms, 70.6MB)
테스트 18 〉	통과 (0.07ms, 77.9MB)
테스트 19 〉	통과 (0.11ms, 77.2MB)
테스트 20 〉	통과 (0.06ms, 77.6MB)
 */
