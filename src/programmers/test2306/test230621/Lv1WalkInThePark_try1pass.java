// 공원 산책
package programmers.test2306.test230621;

import java.util.Arrays;

public class Lv1WalkInThePark_try1pass {
	public static void main(String[] args) {
		Lv1WalkInThePark_try1pass lv = new Lv1WalkInThePark_try1pass();

		String[] t1_1 = {
			"SOO",
			"OOO",
			"OOO"
		};
		String[] t1_2 = {"E 2", "S 2", "W 1"};

		String[] t2_1 = {
			"SOO",
			"OXX",
			"OOO"};
		String[] t2_2 = {"E 2", "S 2", "W 1"};

		String[] t3_1 = {
			"OSO",
			"OOO",
			"OXO",
			"OOO"
		};
		String[] t3_2 = {"E 2", "S 3", "W 1"};

		System.out.println(Arrays.toString(lv.solution(t1_1, t1_2)));
		System.out.println(Arrays.toString(lv.solution(t2_1, t2_2)));
		System.out.println(Arrays.toString(lv.solution(t3_1, t3_2)));

	}

	public int[] solution(String[] park, String[] routes) {
		String[][] deepPark = new String[park.length][park[0].length()];
		int[] answer = new int[2];

		// park 2차원 배열 만들기 & 시작지점 찾기
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				deepPark[i][j] = Character.toString(park[i].charAt(j));
				if (deepPark[i][j].equals("S")) {
					answer[0] = i;
					answer[1] = j;
				}
			}
		}

		for (int i = 0; i < routes.length; i++) {
			char direction = routes[i].charAt(0);
			int move = routes[i].charAt(2) - '0';

			if (canGo(deepPark, answer, direction, move)) {
				switch (direction) {
					case 'E':
						answer[1] += move;
						break;
					case 'W':
						answer[1] -= move;
						break;
					case 'S':
						answer[0] += move;
						break;
					case 'N':
						answer[0] -= move;
						break;
				}
			}
		}
		return answer;
	}

	// 장애물 확인 & 공원을 벗어나는지 확인
	public boolean canGo(String[][] deepArr, int[] start, char direction, int move) {
		int width = deepArr[0].length;
		int height = deepArr.length;
		switch (direction) {
			case 'E': {
				if (start[1] + move >= width) {
					return false;
				}
				for (int i = start[1] + 1; i <= start[1] + move; i++) {
					if (deepArr[start[0]][i].equals("X")) {
						return false;
					}
				}
				break;
			}
			case 'W': {
				if (start[1] - move < 0) {
					return false;
				}
				for (int i = start[1] - 1; i >= start[1] - move; i--) {
					if (deepArr[start[0]][i].equals("X")) {
						return false;
					}
				}
				break;
			}
			case 'S': {
				if (start[0] + move >= height) {
					return false;
				}
				for (int i = start[0] + 1; i <= start[0] + move; i++) {
					if (deepArr[i][start[1]].equals("X")) {
						return false;
					}
				}
				break;
			}
			case 'N': {
				if (start[0] - move < 0) {
					return false;
				}
				for (int i = start[0] - 1; i >= start[0] - move; i--) {
					if (deepArr[i][start[1]].equals("X")) {
						return false;
					}
				}
				break;
			}
		}
		return true;
	}
}

/*
테스트 1 〉통과 (0.06ms, 75.3MB)
테스트 2 〉통과 (0.07ms, 78.2MB)
테스트 3 〉통과 (0.10ms, 77.9MB)
테스트 4 〉통과 (0.37ms, 76.3MB)
테스트 5 〉통과 (0.47ms, 78.2MB)
테스트 6 〉통과 (0.72ms, 74.7MB)
테스트 7 〉통과 (1.03ms, 73.9MB)
테스트 8 〉통과 (0.84ms, 79.3MB)
테스트 9 〉통과 (1.19ms, 81.1MB)
테스트 10 〉통과 (0.74ms, 77.4MB)
테스트 11 〉통과 (1.15ms, 82.1MB)
테스트 12 〉통과 (0.71ms, 72.7MB)
테스트 13 〉통과 (0.79ms, 76.2MB)
테스트 14 〉통과 (0.77ms, 76MB)
테스트 15 〉통과 (1.14ms, 77.5MB)
테스트 16 〉통과 (0.16ms, 75MB)
테스트 17 〉통과 (0.74ms, 81.1MB)
테스트 18 〉통과 (0.12ms, 72.9MB)
테스트 19 〉통과 (1.12ms, 70.3MB)
테스트 20 〉통과 (0.43ms, 75.1MB)
 */