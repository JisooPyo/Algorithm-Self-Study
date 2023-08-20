package programmers.test2304.test230429;

/*
PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.

제한사항
spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
2 ≤ spell의 크기 ≤ 10
spell의 원소의 길이는 1입니다.
1 ≤ dic의 크기 ≤ 10
1 ≤ dic의 원소의 길이 ≤ 10
spell의 원소를 모두 사용해 단어를 만들어야 합니다.
spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
dic과 spell 모두 중복된 원소를 갖지 않습니다.
*/
public class Lev0_08 {

	public static void main(String[] args) {

		Lev0_08 l = new Lev0_08();

		String[] t1_s = { "p", "o", "s" };
		String[] t1_d = { "sod", "eocd", "qixm", "adio", "soo" };
		String[] t2_s = { "z", "d", "x" };
		String[] t2_d = { "def", "dww", "dzx", "loveaw" };
		String[] t3_s = { "s", "o", "m", "d" };
		String[] t3_d = { "moos", "dzx", "smm", "sunmmo", "som" };

		System.out.println(l.solution(t1_s, t1_d));
		System.out.println(l.solution(t2_s, t2_d));
		System.out.println(l.solution(t3_s, t3_d));

	}

	public int solution(String[] spell, String[] dic) {
		for (int i = 0; i < dic.length; i++) {
			int[] check = new int[spell.length];
			// dic[i]가 spell들이 포함된 단어인지 체크하는 array
			for (int j = 0; j < spell.length; j++) {
				if (!(dic[i].contains(spell[j]))) {
					check[j] = 1;
				}
			}
			// dic[i]가 spell[j]를 포함한다면 check[j]는 0, 하나라도 포함하지 않으면 1
			int checksum = 0;
			
			for (int k = 0; k < check.length; k++) {
				checksum+=check[k];
			}
			
			if(checksum == 0) {
				return 1;
			}	// dic[i]가 spell의 원소를 모두 포함한다면 checksum==0
		}
		return 2;
	}

}
