package programmers.test2305.test230524;

public class Lev1_17 {
    public static void main( String[] args ) {
        // aya, ye, woo, ma
        Lev1_17 lev = new Lev1_17();

        String[] t1 = { "aya", "yee", "u", "maa" };
        String[] t2 = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };

        System.out.println( lev.solution( t1 ) );
        System.out.println( lev.solution( t2 ) );

    }

    public int solution( String[] babbling ) {
        int answer = 0;
        for ( int i = 0 ; i < babbling.length ; i++ ) {
            babbling[i] = babbling[i].replaceAll( "ayaaya", "2" );
            babbling[i] = babbling[i].replaceAll( "yeye", "2" );
            babbling[i] = babbling[i].replaceAll( "woowoo", "2" );
            babbling[i] = babbling[i].replaceAll( "mama", "2" );
            babbling[i] = babbling[i].replaceAll( "aya", "1" );
            babbling[i] = babbling[i].replaceAll( "ye", "1" );
            babbling[i] = babbling[i].replaceAll( "woo", "1" );
            babbling[i] = babbling[i].replaceAll( "ma", "1" );
            babbling[i] = babbling[i].replaceAll( "1", "" );
            if ( babbling[i].length() == 0 ) {
                answer++;
            }
        }
        return answer;
    }
}
