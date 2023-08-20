// 개인정보 수집 유효기간
package programmers.test2306.test230611;

import java.text.ParseException;
import java.util.*;

public class Lev1_26_3 {
    public static void main( String[] args ) throws ParseException {
        Lev1_26_3 lev = new Lev1_26_3();

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
        // 약관 종류별 유효기간
        Map< String, Integer > promiseMonth = new HashMap<>();
        for ( int i = 0; i < terms.length; i++ ) {
            String[] sp = terms[i].split( " " );
            promiseMonth.put( sp[0], Integer.parseInt( sp[1] ) );
        }

        // 개인정보 수집일자에 유효기간을 더하여 배열로 만들기
        String[] addDate = new String[privacies.length];
        for ( int i = 0; i < privacies.length; i++ ) {
            String[] sp = privacies[i].split( " " );
            addDate[i] = addDays( sp[0], promiseMonth.get( sp[1] ) );
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
        StringBuilder y1 = new StringBuilder();
        StringBuilder m1 = new StringBuilder();
        StringBuilder d1 = new StringBuilder();
        y1.append( y );
        if(m/10==0){
            m1.append( 0 );
            m1.append( m );
        } else {
            m1.append( m );
        }
        if(d/10==0){
            d1.append( 0 );
            d1.append( d );
        } else {
            d1.append( d );
        }

        StringBuilder allDate = new StringBuilder();
        allDate.append( y1 );
        allDate.append( '.' );
        allDate.append( m1 );
        allDate.append( '.' );
        allDate.append( d1 );

        return allDate.toString();
    }

    // 폐기할까요?
    public boolean throwAway( String today, String expiration ) {
        String[] date = new String[] { today, expiration };
        Arrays.sort( date );
        return date[0].equals( today ) ? false : true;
    }
}

/*
테스트 1 〉	통과 (0.36ms, 69.1MB)
테스트 2 〉	통과 (0.38ms, 72.3MB)
테스트 3 〉	통과 (0.33ms, 72.7MB)
테스트 4 〉	통과 (0.54ms, 76.7MB)
테스트 5 〉	통과 (0.59ms, 80.1MB)
테스트 6 〉	통과 (0.67ms, 73.5MB)
테스트 7 〉	통과 (0.68ms, 76.5MB)
테스트 8 〉	통과 (0.51ms, 76MB)
테스트 9 〉	통과 (1.38ms, 80.7MB)
테스트 10 〉통과 (1.02ms, 76.1MB)
테스트 11 〉통과 (1.11ms, 77.2MB)
테스트 12 〉통과 (1.69ms, 74.6MB)
테스트 13 〉통과 (2.37ms, 70.4MB)
테스트 14 〉통과 (1.52ms, 67.1MB)
테스트 15 〉통과 (1.25ms, 75.3MB)
테스트 16 〉통과 (1.71ms, 67.9MB)
테스트 17 〉통과 (1.75ms, 76.9MB)
테스트 18 〉통과 (2.06ms, 77MB)
테스트 19 〉통과 (1.71ms, 81MB)
테스트 20 〉통과 (1.56ms, 86.2MB)
 */

// 다른 사람의 풀이를 보고 느낀 것.
// 우리는 기존 날짜에서 6개월 지난 날짜를 알고 싶은게 아니라 지났는지 안 지났는지만 중요하다.
// 따라서 year, month, day에 *28을 해준 후 비교했으면 더 간단하게 끝났을 것!