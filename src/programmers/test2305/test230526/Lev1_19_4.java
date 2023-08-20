package programmers.test2305.test230526;

public class Lev1_19_4 {
    public static void main( String[] args ) {
        Lev1_19_4 lev = new Lev1_19_4();

        System.out.println( lev.solution( "banana" ) );
        System.out.println( lev.solution( "abracadabra" ) );
        System.out.println( lev.solution( "aaabbaccccabba" ) );
    }

    public int solution( String s ) {
        int answer = 0;
        while ( s.length() > 0 ) {
            int a = s.length();
            char firstChar = s.charAt( 0 );
            int countFirst = 0;
            int countOther = 0;
            for ( int i = 0 ; i < s.length() ; i++ ) {
                if ( firstChar == s.charAt( i ) ) {
                    countFirst++;
                } else {
                    countOther++;
                }
                if ( countFirst == countOther ) {
                    s = s.substring( i + 1 );
                    answer++;
                    break;
                }
            }
            int b = s.length();
            if ( a == b ) {
                answer++;
                break;
            }
        }
        return answer;
    }
}
