package programmers.test2305.test230528;

public class Lev1_22 {
    public static void main( String[] args ) {
        Lev1_22 lev = new Lev1_22();

        System.out.println( lev.solution( "...!@BaT#*..y.abcdefghijklm" ) );
        System.out.println( lev.solution( "z-+.^." ) );
        System.out.println( lev.solution( "=.=" ) );
        System.out.println( lev.solution( "123_.def" ) );
        System.out.println( lev.solution( "abcdefghijklmn" ) );
    }

    public String solution( String new_id ) {

        //  소문자로 치환.
        String answer = new_id.toLowerCase();

        // 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        answer = answer.replaceAll( "[^a-z0-9-_\\.]", "" );

        // 온점이 연속된 부분을 하나로 줄이기
        answer = answer.replaceAll( "\\.+", "." );

        // 마침표가 처음이나 끝에 위치한다면 제거.
        if ( answer.charAt( 0 ) == '.' ) {
            answer = answer.substring( 1 );
        }
        if ( answer.length() >= 1 && answer.charAt( answer.length() - 1 ) == '.' ) {
            answer = answer.substring( 0, answer.length() - 1 );
        }

        // 빈 문자열이라면 a를 대입.
        if ( answer.length() == 0 ) {
            answer += "a";
        }

        // 16자 이상이면 앞의 15개의 문자를 제외한 나머지 문자들을 제거.
        if ( answer.length() >= 16 ) {
            answer = answer.substring( 0, 15 );
        }

        // 제거 후 마침표가 끝에 위치한다면 마침표 제거
        if ( answer.charAt( answer.length() - 1 ) == '.' ) {
            answer = answer.substring( 0, answer.length() - 1 );
        }

        // 길이가 2자 이하라면 new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙인다.
        if ( answer.length() <= 2 ) {
            while ( answer.length() < 3 ) {
                answer += answer.charAt( answer.length() - 1 );
            }
        }

        return answer;
    }
}
