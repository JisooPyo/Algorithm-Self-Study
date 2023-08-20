package programmers.test2306.test230617;

import java.util.Arrays;

public class LV2JadenCase_try3 {
    public static void main( String[] args ) {
        LV2JadenCase_try3 lv = new LV2JadenCase_try3();
        String t1 = "  3people  unFollowed me p35o   ";
        String t2 = "for the last week";

        System.out.println( lv.solution( t1 ) );
        System.out.println( lv.solution( t2 ) );

    }

    public String solution( String s ) {
        // 앞 뒤 공백 제거
        String front = lengthFrontspace( s );
        String back = lengthBackspace( s );
        s = s.strip();
        String[] split = s.split( " +" );

        System.out.println( Arrays.toString( split ) );

        StringBuilder sb = new StringBuilder();
        if ( front.length() != 0 ) {
            sb.append( front );
        }
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
        if ( back.length() != 0 ) {
            sb.append( back );
        }
        return sb.toString();
    }

    public String lengthFrontspace( String str ) {
        int count = 0;
        for ( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt( i ) == ' ' ) {
                count++;
            } else {
                break;
            }
        }
        return " ".repeat( count );
    }

    public String lengthBackspace( String str ) {
        int count = 0;
        for ( int i = str.length() - 1; i >= 0; i-- ) {
            if ( str.charAt( i ) == ' ' ) {
                count++;
            } else {
                break;
            }
        }
        return " ".repeat( count );
    }

}

/*

앞뒤에 공백이 있을 경우를 생각하자.

이전방법
통과 : 1, 3, 6, 7, 10, 15, 16, 18
실패 : 2, 4, 5, 8, 9, 11, 12, 13, 14, 17

지금방법
통과 : 1, 3, 6, 7, 8, 10, 15, 16, 18
실패 : 2, 4, 5, 9, 11, 12, 13, 14, 17

 */
