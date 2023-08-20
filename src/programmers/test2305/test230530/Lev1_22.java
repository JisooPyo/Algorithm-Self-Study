// 둘만의 암호
package programmers.test2305.test230530;

public class Lev1_22 {
    public static void main( String[] args ) {
        Lev1_22 lev = new Lev1_22();
        long beforeTime = System.currentTimeMillis();
        System.out.println( lev.solution( "aukks", "wbqd", 5 ) );
        long afterTime = System.currentTimeMillis();
        long secDiffTime = afterTime - beforeTime;
        System.out.println( "시간차이 : " + secDiffTime );

    }

    public String solution( String s, String skip, int index ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "abcdefghijklmnopqrstuvwxyz" );
        for ( int i = 0 ; i < skip.length() ; i++ ) {
            String str = "" + skip.charAt( i );
            sb.deleteCharAt( sb.indexOf( str ) );
        }

        String answer = "";
        for ( int i = 0 ; i < s.length() ; i++ ) {
            String str = "" + s.charAt( i );
            if ( sb.length() - 1 < sb.indexOf( str ) + index ) {
                answer += sb.charAt( ( sb.indexOf( str ) + index ) % sb.length() );
            } else {
                answer += sb.charAt( sb.indexOf( str ) + index );
            }
        }
        return answer;
    }
}
// 알파벳 순서대로 미는 거니까 굳이 charAt과 indexOf을 쓰지 않고도 +,-연산으로 가능할 것이다.

/*

테스트 1 〉	통과 (15.21ms, 71.2MB)
테스트 2 〉	통과 (12.36ms, 82.9MB)
테스트 3 〉	통과 (10.89ms, 77.6MB)
테스트 4 〉	통과 (12.61ms, 71.3MB)
테스트 5 〉	통과 (10.80ms, 75.6MB)
테스트 6 〉	통과 (10.54ms, 73.1MB)
테스트 7 〉	통과 (11.75ms, 72.5MB)
테스트 8 〉	통과 (12.72ms, 76.2MB)
테스트 9 〉	통과 (11.85ms, 79.4MB)
테스트 10 〉 통과 (13.41ms, 78.5MB)
테스트 11 〉통과 (11.90ms, 77.2MB)
테스트 12 〉통과 (11.71ms, 77.7MB)
테스트 13 〉통과 (12.57ms, 90MB)
테스트 14 〉통과 (11.01ms, 77.7MB)
테스트 15 〉통과 (12.45ms, 81.1MB)
테스트 16 〉통과 (9.97ms, 77.3MB)
테스트 17 〉통과 (12.32ms, 87.2MB)
테스트 18 〉통과 (10.41ms, 79.5MB)
테스트 19 〉통과 (11.56ms, 91.4MB)
*/