package programmers.test2306.test230617;

public class LV2JadenCase_try4 {
    public static void main( String[] args ) {
        LV2JadenCase_try4 lv = new LV2JadenCase_try4();
        String t1 = "  3people  unFollowed me p35o   ";
        String t2 = "for the last week";
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
        String front = lengthFrontspace( s );
        if(front.equals( s )){
            return s;
        }
        String back = lengthBackspace( s );
        s = s.strip();
        String[] split = s.split( " +" );

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

단어가 공백만 있다면?

이전방법
통과 : 1, 3, 6, 7, 8, 10, 15, 16, 18
실패 : 2, 4, 5, 9, 11, 12, 13, 14, 17

지금방법
통과 : 1, 3, 6, 7, 8, 10, 15, 16, 18
실패 : 2, 4, 5, 9, 11, 12, 13, 14, 17

 */