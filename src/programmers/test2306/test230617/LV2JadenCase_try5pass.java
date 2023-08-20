package programmers.test2306.test230617;

public class LV2JadenCase_try5pass {
    public static void main( String[] args ) {
        LV2JadenCase_try5pass lv = new LV2JadenCase_try5pass();
        String t1 = "  3people  unFollowed me p35o   ";
        String t2 = "for  the last week";
        String t3 = " ";
        String t4 = "a";
        String t5 = "A";
        String t6 = "    a   ";

        System.out.println( lv.solution( t1 ) );
        System.out.println( lv.solution( t2 ) );

        // 공백만 있는 경우
        System.out.println( lv.solution( t3 ) );

        // 단어가 하나만 있는 경우
        System.out.println( lv.solution( t4 ) );
        System.out.println( lv.solution( t5 ) );

        // 단어가 하나인데 양쪽에 공백이 있는 경우
        System.out.println( lv.solution( t6 ) );

    }

    public String solution( String s ) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        boolean flag = true;
        for ( int i = 0; i < s.length(); i++ ) {
            char temp = s.charAt( i );
            if ( temp == ' ' ) {
                flag = true;
            }
            if ( flag ) {
                if ( temp != ' ' ) {
                    if ( 97 <= temp && temp <= 122 ) {
                        temp = (char) ( temp - 32 );
                    }
                    flag = false;
                }
            }
            sb.append( temp );
        }
        return sb.toString();
    }

}

/*
엎어보자..
가운데 띄어쓰기가 두 개 있을 때는 리턴할 때도 두 개를 리턴해야 한다!
그렇다면 split을 이용하지 말고 해보자!

이전방법
통과 : 1, 3, 6, 7, 8, 10, 15, 16, 18
실패 : 2, 4, 5, 9, 11, 12, 13, 14, 17

이번 방법으로 맞았다!
어떻게 설명하지!

테스트 1 〉	통과 (0.04ms, 69.8MB)
테스트 2 〉	통과 (0.07ms, 72.5MB)
테스트 3 〉	통과 (0.04ms, 75.5MB)
테스트 4 〉	통과 (0.09ms, 76.8MB)
테스트 5 〉	통과 (0.05ms, 73.4MB)
테스트 6 〉	통과 (0.05ms, 75.1MB)
테스트 7 〉	통과 (0.05ms, 77.5MB)
테스트 8 〉	통과 (0.04ms, 74.2MB)
테스트 9 〉	통과 (0.05ms, 73.6MB)
테스트 10 〉통과 (0.04ms, 77.7MB)
테스트 11 〉통과 (0.05ms, 75.5MB)
테스트 12 〉통과 (0.05ms, 71.5MB)
테스트 13 〉통과 (0.05ms, 73.7MB)
테스트 14 〉통과 (0.06ms, 76.4MB)
테스트 15 〉통과 (0.05ms, 83.5MB)
테스트 16 〉통과 (0.03ms, 75.6MB)
테스트 17 〉통과 (0.04ms, 76.8MB)
테스트 18 〉통과 (0.02ms, 73.1MB)

 */