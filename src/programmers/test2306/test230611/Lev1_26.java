// 개인정보 수집 유효기간
package programmers.test2306.test230611;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lev1_26 {
    public static void main( String[] args ) throws ParseException {
        Lev1_26 lev = new Lev1_26();

        String t1_1 = "2022.05.19";
        String[] t1_2 = { "A 6", "B 12", "C 3" };
        String[] t1_3 = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

        String t2_1 = "2020.01.01";
        String[] t2_2 = { "Z 3", "D 5" };
        String[] t2_3 = { "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z" };

        System.out.println( Arrays.toString( lev.solution( t1_1, t1_2, t1_3 ) ) );
        System.out.println( Arrays.toString( lev.solution( t2_1, t2_2, t2_3 ) ) );
    }


    public int[] solution( String today, String[] terms, String[] privacies ) throws ParseException {
        // checkDate = 개인정보 수집일자 배열
        // promise = 개인 약관 종류
        String[] checkDate = new String[privacies.length];
        String[] promise = new String[privacies.length];
        for ( int i = 0; i < privacies.length; i++ ) {
            String[] sp = privacies[i].split( " " );
            checkDate[i] = sp[0];
            promise[i] = sp[1];
        }

        // 약관 종류별 유효기간
        Map< String, Integer > promiseMonth = new HashMap<>();
        for ( int i = 0; i < terms.length; i++ ) {
            String[] sp = terms[i].split( " " );
            promiseMonth.put( sp[0], Integer.parseInt( sp[1] ) );
        }

        // 개인정보 수집일자에 유효기간을 더하여 배열로 만들기
        String[] addDate = new String[checkDate.length];
        for ( int i = 0; i < checkDate.length; i++ ) {
            addDate[i] = addDays( checkDate[i], promiseMonth.get( promise[i] ) );
        }

        // addDate와 today를 비교하여 버릴 인덱스만 list에 저장.
        List< Integer > away = new ArrayList<>();
        for ( int i = 0; i < addDate.length; i++ ) {
            if ( throwAway( today, addDate[i] ) ) {
                away.add( i + 1 );
            }
        }

        // list를 array로 변환.
        int[] answer = new int[away.size()];
        for ( int i = 0; i < away.size(); i++ ) {
            answer[i] = away.get( i );
        }
        return answer;
    }

    // date에 month를 더한 날을 String으로 출력해주세요.
    public String addDays( String date, int month ) {
        int y = Integer.parseInt( date.substring( 0, 4 ) );
        int m = Integer.parseInt( date.substring( 5, 7 ) );
        int d = Integer.parseInt( date.substring( 8 ) );

        m = m + month;
        d = d - 1;
        if ( d == 0 ) {
            d = 28;
            m = m - 1;
        }
        if ( m >= 13 ) {
            if ( m % 12 == 0 ) {
                // 24라면 m이 0이 된다!!
                y += m / 12 - 1;
                m = 12;
            } else {
                y += m / 12;
                m = m % 12;
            }
        }
        String y1 = "" + y;
        String m1 = m / 10 == 0 ? "0" + m : "" + m;
        String d1 = d / 10 == 0 ? "0" + d : "" + d;

        return y1 + "." + m1 + "." + d1;
    }

    // 폐기할까요?
    public boolean throwAway( String today, String expiration ) {
        String[] date = new String[] { today, expiration };
        Arrays.sort( date );
        return date[0].equals( today ) ? false : true;
    }
}

/*
테스트 1 〉	통과 (16.93ms, 80.4MB)
테스트 2 〉	통과 (14.44ms, 78.9MB)
테스트 3 〉	통과 (14.47ms, 78.1MB)
테스트 4 〉	통과 (14.23ms, 86.3MB)
테스트 5 〉	통과 (14.43ms, 80.1MB)
테스트 6 〉	통과 (21.27ms, 79.9MB)
테스트 7 〉	통과 (19.59ms, 81.3MB)
테스트 8 〉	통과 (17.35ms, 82.3MB)
테스트 9 〉	통과 (16.09ms, 84.8MB)
테스트 10 〉통과 (16.84ms, 85.3MB)
테스트 11 〉통과 (15.53ms, 78.6MB)
테스트 12 〉통과 (16.32ms, 73.6MB)
테스트 13 〉통과 (22.21ms, 78.8MB)
테스트 14 〉통과 (13.60ms, 72.6MB)
테스트 15 〉통과 (18.36ms, 85.7MB)
테스트 16 〉통과 (17.14ms, 81MB)
테스트 17 〉통과 (18.50ms, 78.8MB)
테스트 18 〉통과 (16.43ms, 83.9MB)
테스트 19 〉통과 (17.36ms, 83.8MB)
테스트 20 〉통과 (17.31ms, 85.5MB)
 */