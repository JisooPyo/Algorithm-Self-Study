package programmers.test2304.test230422;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basic066 {

	public static void main(String[] args) {

		Basic066 b = new Basic066();

		int[] x = { 2, 1, 6 };
		int[] y = { 5, 2, 1, 7, 5 };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public int[] solution(int[] num_list) {

		int last = num_list[num_list.length - 1]; // 마지막 값
		int last2 = num_list[num_list.length - 2]; // 마지막 앞의 값

		List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());

		if (last > last2) {
			list.add(last - last2);
		} else {
			list.add(last * 2);
		}

		int[] answer = list.stream().mapToInt(i -> i).toArray();

		return answer;
	}

}

/*

다른 사람의 풀이

    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];

        for(int i=0; i<num_list.length; i++){
            answer[i] = num_list[i];
        }

        answer[num_list.length] = num_list[num_list.length-1] > num_list[num_list.length-2] ?
        num_list[num_list.length-1]-num_list[num_list.length-2]:num_list[num_list.length-1]*2;
        return answer;
    }

*/