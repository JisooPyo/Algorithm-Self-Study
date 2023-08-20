package programmers.test2304.test230418;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateCharactersProblem {

	public static void main(String[] args) {
		
		RemoveDuplicateCharactersProblem rdc = new RemoveDuplicateCharactersProblem();

		String x = "people";
		String y = "We are the world";
		
		System.out.println(rdc.solution(x));
		System.out.println(rdc.solution(y));
		

	}

	public StringBuilder solution(String my_string) {
		
		String[] split1 = my_string.split("");	// 스트링을 하나하나 나누어 스트링배열 split1 에 저장
		List<String> list1 = Arrays.asList(split1);	// 스트링배열 splilt1을 list1이라는 List로 변환 
		Set<String> set1 = new LinkedHashSet<String>(list1); // list1을 LinkedHashSet set1으로 변환
		List<String> reList1 = new ArrayList<String>(set1); // LinkedHashSet을 다시 List reList1으로 변환
		StringBuilder sb1 = new StringBuilder(); // StringBuilder sb1 선언

		for (String str : reList1) {	//reList1에 있는 str을 sb1에 append시키는 반복문.

			sb1.append(str);

		}
		
		return sb1;	// sb1 출력
	}

}

/*

다른 사람의 풀이

1.

import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }
}

2.

import java.util.*;
class Solution {
    public String solution(String my_string) {
        String[] answer = my_string.split("");
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(answer));

        return String.join("", set);
    }
}

*/
