package programmers.test2304.test230414;

public class AntArmyProblem {

	public static void main(String[] args) {

		AntArmyProblem aa = new AntArmyProblem();

		System.out.println(aa.solution(23));
		System.out.println(aa.solution(24));
		System.out.println(aa.solution(999));

	}

	public int solution(int hp) {
		int generalAnt = hp/5;
		int soldierAnt = (hp%5)/3;
		int workingAnt = (hp%5)%3;
		int answer = generalAnt+soldierAnt+workingAnt;
		return answer;
	}

}
