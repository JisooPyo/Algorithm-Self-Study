package programmers.test2304.test230424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic087 {

	public static void main(String[] args) {

		Basic087 b = new Basic087();

		System.out.println(Arrays.toString(b.solution(5, 555)));
		System.out.println(Arrays.toString(b.solution(10, 20)));

	}

	public int[] solution(int l, int r) {

		List<Integer> list = new ArrayList<>();
		int[] answer = { -1 };

		for (int i = l; i <= r; i++) {
			String temp = "";
			temp += i;
			temp = temp.replace("5", "");
			temp = temp.replace("0", "");
			if (temp == "") {
				list.add(i);
			}

		}

		return list.size() == 0 ? answer : list.stream().mapToInt(i -> i).toArray();
	}

}

/*

다른 사람의 풀이

while문을 돌리는데 5로 나누어서 끝자리가 0아니면 5가 아니면 false, 맞으면 true인 i를 list에 담고 array로 변환시켜 answer에 담는다. 

import java.util.stream.IntStream;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = IntStream.rangeClosed(l, r).filter(i -> {
            while (i > 0) {
                if (i % 5 != 0) return false;
                i /= 10;
            }
            return true;
        }).toArray();

        return answer.length == 0 ? new int[]{-1} : answer;
    }
}

*/
