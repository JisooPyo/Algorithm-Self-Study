package programmers.test2304.test230425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic100 {

	public static void main(String[] args) {
		Basic100 b = new Basic100();

		String x = " i    love  you";
		String y = "    programmers  ";
		
		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public String[] solution(String my_string) {
		String[] arr1 = my_string.split(" ");
		List<String> list = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			if (!(arr1[i].equals(""))) {
				list.add(arr1[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}

}
/*

다른 사람의 풀이
str.trim() : String인 str 앞 뒤로 있는 공백 제거해주는 메소드

// https://codevang.tistory.com/114 참고

* 메타문자
  정규표현식 또는 정규식을 제어할 수 있는 문자. 특정 delimiter, 즉 메타문자는 split을 사용해 바로 나눌 수 없고, 특별한 처리를 해야 나눠진다.
  ^	: 문자열의 처음을 나타낸다.
  |	: or의 뜻으로 선택문에 사용된다.
  ?	: 앞의 문자가 없거나 하나이다.
  *	: 바로 앞의 문자가 없거나 하나 이상이다.
  (	: 괄호 안의 문자열은 하나로 묶어 취급한다.
  )	: 위와 내용 동일
  [	: 한 문자를 가리키고 묶음 안의 내용은 가리키는 문자의 범위를 나타낸다.
  ]	: 위와 내용 동일
  {	: 앞에 있는 문자의 개수를 나타내고 묶음 안에서 , 는 문자 개수의 범위를 나타낼때 사용한다.
  }	: 위와 내용 동일
  \	: 메타 문자의 성질을 없앨 때 붙인다.
  + : 하나 이상 있음.
  
		split("[ ]+")의 의미 : 띄어쓰기가 한 개 혹은 그 이상으로 되어 있는 것으로 구분해주세요.

    public String[] solution(String my_string) {
        return my_string.trim().split("[ ]+");
    }

*/