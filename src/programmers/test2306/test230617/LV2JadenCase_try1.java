package programmers.test2306.test230617;

public class LV2JadenCase_try1 {
    public static void main( String[] args ) {
        LV2JadenCase_try1 lv = new LV2JadenCase_try1();
        String t1 = "3people  unFollowed me";
        String t2 = "for the last week";

        System.out.println( lv.solution( t1 ) );
        System.out.println( lv.solution( t2 ) );

    }

    public String solution( String s ) {
        String[] split = s.split( " " );

        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < split.length; i++ ) {
            StringBuilder temp = new StringBuilder();

            temp.append( split[i].toLowerCase() );

            if ( 97 <= temp.charAt( 0 ) && temp.charAt( 0 ) <= 122 ) {
                temp.setCharAt( 0, (char) ( temp.charAt( 0 ) - 32 ) );
            }

            sb.append( temp );
            sb.append( " " );
        }

        sb.deleteCharAt( sb.length() - 1 );
        return sb.toString();
    }

}

/*

통과 : 1, 3, 6, 7, 10, 15, 16, 18
런타임 에러 : 2, 4, 5, 9, 11, 12, 13, 14, 17
실패 : 8

 */