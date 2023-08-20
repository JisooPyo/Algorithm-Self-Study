package programmers.test2305.test230509;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Lev1_047 {

	public static void main(String[] args) {
		Lev1_047 lev = new Lev1_047();

		System.out.println(lev.solution(5, 24));

	}

	public String solution(int a, int b) {
		LocalDate date = LocalDate.of(2016, a, b);
		DayOfWeek dayOfWeek = date.getDayOfWeek();

		return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
	}

}

/*

다른 사람의 풀이

    public String getDayName(int a, int b) {
        String answer = "";
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int allDate = 0;
        for (int i = 0; i < a - 1; i++) {
            allDate += date[i];
        }
        allDate += (b - 1);
        answer = day[allDate % 7];

        return answer;
    }

*/