package programmers.test2304.test230425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic104 {

	public static void main(String[] args) {
		Basic104 b = new Basic104();

		String[] x = { "and", "notad", "abcd" };
		String[] y = { "there", "are", "no", "a", "ds" };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public String[] solution(String[] strArr) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < strArr.length; i++) {
			if (!(strArr[i].contains("ad"))) {
				list.add(strArr[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}

}

/*

다른 사람의 풀이

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = Arrays.stream(strArr)
        	.filter(m -> !m.contains("ad"))
        	.collect(Collectors.toList());
        
        String[] answer  = new String[list.size()];
        
        list.toArray(answer);
        
        return answer;
    }
}

*/