package programmers.test2304.test230427;

import java.util.Arrays;
import java.util.List;

public class Basic125 {

	public static void main(String[] args) {
		Basic125 b = new Basic125();

		String[] x = { "u", "u", "l", "r" };
		String[] y = { "l" };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public String[] solution(String[] str_list) {
		String[] answer = {};
		List<String> list = Arrays.asList(str_list);
		
		int indexL = 0;
		int indexR = 0;
		
		for (int i = 0; i < str_list.length; i++) {
			if (str_list[i].equals("l")) {
				indexL = i;
				break;
			}
		}
		for (int i = 0; i < str_list.length; i++) {
			if (str_list[i].equals("r")) {
				indexR = i;
				break;
			}
		}

		if (list.contains("l") && list.contains("r")) {

			if (indexL < indexR) {
				answer = Arrays.copyOfRange(str_list, 0, indexL);
			} else {
				answer = Arrays.copyOfRange(str_list, indexR + 1, str_list.length);
			}

		} else if (list.contains("l")) {
			answer = Arrays.copyOfRange(str_list, 0, indexL);

		} else if (list.contains("r")) {
			answer = Arrays.copyOfRange(str_list, indexR + 1, str_list.length);

		}
		return answer;

	}

}

/*

다른 사람의 풀이

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] str_list) {
    
        return IntStream.range(0, str_list.length)
        				// 0에서 부터 str_list.length-1까지의 integer을 차례대로 스트림으로 방출
        				 
                .boxed()
                		// IntStream -> Stream<Integer>
                		 
                .filter(i -> str_list[i].equals("l") || str_list[i].equals("r"))
                		// i는 0에서부터 str_list.length-1까지의 integer
                		// i를 남기는데 이 조건에 부합하는 i만 남겨주세요(?)
                		 
                .findFirst()
                		// findFirst()는 filter 조건에 일치하는 element 1개를 Optional로 리턴.
                		   조건에 일치하는 요소가 없다면 empty가 리턴
                		// ** findAny()는 랜덤으로 찾는다..!
                		// ** Optional : NPE(NullPointerException)을 피하기 위한 클래스.
                		 				 null이 올 수 있는 값을 감싸는 Wrapper 클래스.
                		// 여기서 l이나 r이 담겨있는 index를 구할 수 있다.
                		 
                .map(i -> {
                    if (str_list[i].equals("l")) {
                        return Arrays.copyOfRange(str_list, 0, i);
                    }
                    return Arrays.copyOfRange(str_list, i + 1, str_list.length);
                })
                		// 요소들을 특정조건에 해당하는 값으로 변환. 요소들을 대,소문자 변형 등 의 작업을 하고 싶을떄 사용 가능.
                		// 이 index를 이렇게 바꿀거에요!
                		// 만약 str_list에서 이 인덱스의 값이 "l"이라면 이 배열을 리턴할거에요.
                		// 만약 그렇지 않다면 이 배열을 리턴할거에요.
                		                
                .orElseGet(() -> new String[]{});
                		// .orElse : Optional에서 olElse의 값이 null이 아닐 경우
                		  			 해당 값 반환, null일 경우 괄호 안(Type T) 반환
                		  	ex).orElse("orElse") : null일 경우 orElse이라는 스트링 반환
                		  						   null이 아닐 경우도 반환할 수도 있다..?(??)
                		  	
                		// .orElseGet : Optional에서의 값이 null이 아닐 경우 그 해당 값(Value)을 반환
                		  				null인 경우에는 Supplier Generice으로 넘겨받았을 때의 값을 반환한다.
                		    ex) .orElseGet("orElse") : 오류가 난다.
                		    						   -> Supplier Interface를 활용해야 한다.
                		    	.orElseGet(()->"orElseGet") : O
                		    		람다표현식 () -> "orElseGet"
                		    		Supplier Interface 객체를 넘기는 것을 확인할 수 있다.
                		  	
    }
}

*/
