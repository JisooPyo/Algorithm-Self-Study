package programmers.test2304.test230425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic102 {

	public static void main(String[] args) {
		Basic102 b = new Basic102();

		String[] x = { "problemsolving", "practiceguitar", "swim", "studygraph" };
		boolean[] y = { true, false, true, false };
		
		System.out.println(Arrays.toString(b.solution(x, y)));

	}

	public String[] solution(String[] todo_list, boolean[] finished) {
		List<String> unfi = new ArrayList<>();
		for(int i=0;i<todo_list.length;i++) {
			if(finished[i]==false) {
				unfi.add(todo_list[i]);
			}
		}
		return unfi.toArray(new String[unfi.size()]);
	}

}

/*

다른 사람의 풀이

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] todoList, boolean[] finished) {
        return IntStream.range(0, todoList.length)
            .mapToObj(i -> new AbstractMap.SimpleEntry<>(todoList[i], !finished[i]))
            .filter(AbstractMap.SimpleEntry::getValue)
            .map(AbstractMap.SimpleEntry::getKey)
            .toArray(String[]::new);
    }
}

*/