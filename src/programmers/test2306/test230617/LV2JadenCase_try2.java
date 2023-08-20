package programmers.test2306.test230617;

public class LV2JadenCase_try2 {
    public static void main( String[] args ) {
        LV2JadenCase_try2 lv = new LV2JadenCase_try2();
        String t1 = "3people  unFollowed me";
        String t2 = "for the last week";

        System.out.println( lv.solution( t1 ) );
        System.out.println( lv.solution( t2 ) );

    }

    public String solution( String s ) {
        // 공백이 여러개일 수도 있으니 정규식을 이용하여 구분해 준다.
        String[] split = s.split( " +" );

        // return할 StringBuilder를 하나 만든다.
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < split.length; i++ ) {
            // split의 원소(단어 하나)를 넣어줄 temp
            StringBuilder temp = new StringBuilder();

            // 소문자로 만들어 temp에 넣어준다.
            temp.append( split[i].toLowerCase() );

            // temp의 첫 index가 소문자라면 대문자로 바꾸기(아스키코드 이용)
            // 조건식 사용하는 이유 : 첫 index가 숫자일 수도 있기 때문.
            if ( 97 <= temp.charAt( 0 ) && temp.charAt( 0 ) <= 122 ) {
                temp.setCharAt( 0, (char) ( temp.charAt( 0 ) - 32 ) );
            }

            // 최종 답이 될 sb에 temp와 공백을 더해준다.
            sb.append( temp );
            sb.append( " " );
        }

        // 마지막 스페이스는 빼준다.
        sb.deleteCharAt( sb.length() - 1 );
        return sb.toString();
    }

}

/*
공백문자가 연속해서 나올수도 있다고 해서 split 구분자에 " +"로 + 추가
런타임에러는 없어졌지만 실패가 보임.

이전 방법
통과 : 1, 3, 6, 7, 10, 15, 16, 18
런타임 에러 : 2, 4, 5, 9, 11, 12, 13, 14, 17
실패 : 8

지금방법
통과 : 1, 3, 6, 7, 10, 15, 16, 18
실패 : 2, 4, 5, 8, 9, 11, 12, 13, 14, 17

 */