package programmers.test2304.test230421;

public class Basic060 {

	public static void main(String[] args) {
		Basic060 basic = new Basic060();

		String x = "banana";
		String a = "ana";
		String b = "nan";
		String c = "wxyz";
		String d = "abanana";

		System.out.println(basic.solution(x, a));
		System.out.println(basic.solution(x, b));
		System.out.println(basic.solution(x, c));
		System.out.println(basic.solution(x, d));
	}

	public int solution(String my_string, String is_suffix) {
		if (my_string.length() < is_suffix.length()) {
			return 0;
		}
		return my_string.substring(my_string.length() - is_suffix.length()).equals(is_suffix) ? 1 : 0;
	}

}

/*

다른 사람의 풀이

        if(my_string.endsWith(is_suffix)) {
            return 1;
        } else {
            return 0;
        }
        
String.startsWith(Str) : String이 Str로 시작하나요? -> boolean 타입
String.endsWith(Str) : String이 Str로 끝나나요? -> boolean 타입

----------------------------------------------------------------

        String strRev = new StringBuilder(my_string).reverse().toString();
        String sufRev = new StringBuilder(is_suffix).reverse().toString();
        return strRev.indexOf(sufRev)==0?1:0;

string을 뒤집고 suffix을 뒤집어서
suffix가 string의 0자리에 있니? 체크
-----------------------------------------------------------------

     if (!my_string.contains(is_suffix)) return 0;
        return my_string.lastIndexOf(is_suffix) == (my_string.length() - is_suffix.length()) ? 1 : 0;

string 안에 suffix가 없으면 0
string에서 suffix를 찾는데 오른쪽부터 찾아서 나온 index와
string길이에서 suffix 길이를 뺀 값이 같으면 1 아니면 0 리턴
 
*/