package programmers.test2304.test230423;

import java.util.Arrays;

public class Basic076 {

	public static void main(String[] args) {
		Basic076 b = new Basic076();

		int[] x = { 1, 8, 3 };
		int[] y = { 9, 10, 11, 8 };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public int[] solution(int[] array) {
		int[] answer = new int[2];
		answer[0] = array[0];
		answer[1] = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > answer[0]) {
				answer[0] = array[i];
				answer[1] = i;
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이

    public int[] solution(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        //array를 list로 변환
        
        int max = list.stream().max(Integer::compareTo).orElse(0);
        // int max에 list내의 0과 비교하여..? 최대값 넣기 
        
        int index = list.indexOf(max);
        // int index에 max 인덱스 넣기
        
        return new int[] {max, index};
    }



*/
