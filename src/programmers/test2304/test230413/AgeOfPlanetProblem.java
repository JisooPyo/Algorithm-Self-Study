package programmers.test2304.test230413;

public class AgeOfPlanetProblem {

	public static void main(String[] args) {

		AgeOfPlanetProblem aop = new AgeOfPlanetProblem();

		int a = 23;
		int b = 51;
		int c = 100;

		System.out.println(aop.solution(a));
		System.out.println(aop.solution(b));
		System.out.println(aop.solution(c));

	}

	public StringBuilder solution(int age) {

		StringBuilder answer = new StringBuilder();

		if (age == 1000) {
			answer = answer.append("baaa");
		} else if (100 <= age && age <= 999) {
			char x1 = (char) (age / 100 + 97); // 백의 자리
			char x2 = (char) (age % 100 / 10 + 97); // 십의 자리
			char x3 = (char) (age % 10 + 97); // 일의 자리
			answer = answer.append(x1).append(x2).append(x3);

		} else if (10 <= age && age <= 99) {
			char y1 = (char) (age / 10 + 97);
			char y2 = (char) (age % 10 + 97);
			answer = answer.append(y1).append(y2);

		} else {
			char z1 = (char) (age + 97);
			answer = answer.append(z1);

		}

		return answer;
	}

}

/*

    public String solution(int age) {
        String answer = "";
        String[] alpha = new String[]{"a","b","c","d","e","f","g","h","i","j"};

        while(age>0){
            answer = alpha[age % 10] + answer;
            age /= 10;
        }

        return answer;
    }
 
 -----------------------------------------------------------   
    
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();

        while(age > 0) {
            sb.insert(0, (char) ((age % 10) + (int)'a'));
            age /= 10;
        }

        return sb.toString();
    }

*/
