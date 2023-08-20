package programmers.test2305.test230530;

public class Lev1_22_Other {
    public static void main( String[] args ) {
        Lev1_22_Other lev = new Lev1_22_Other();
        long beforeTime = System.currentTimeMillis();
        System.out.println( lev.solution( "aukks", "wbqd", 5 ) );
        long afterTime = System.currentTimeMillis();
        long secDiffTime = afterTime - beforeTime;
        System.out.println( "시간차이 : " + secDiffTime );

    }

    public String solution( String s, String skip, int index ) {
        StringBuilder answer = new StringBuilder();

        for ( char letter : s.toCharArray() ) {
            // s.toCharArray() : { 'a', 'u', 'k', 'k', 's' }
            char temp = letter;
            // temp = 'a', 'u', 'k', 'k', 's'
            int idx = 0;
            while ( idx < index ) {
                // idx와 index가 같아지면 while 빠져 나옴.
                temp = temp == 'z' ? 'a' : (char) ( temp + 1 );
                // temp == 'z'인가? 'z'이면 'a'를 넣고, 아니면 temp 하나 뒤에 것을 넣어라.
                // temp에 temp 다음 것을 넣어라.
                if ( !skip.contains( String.valueOf( temp ) ) ) {
                    //skip이 temp를 포함하지 않는가? idx++해라.
                    idx += 1;
                }
//                'a' -> temp : 'b'-> contain -> temp : 'c' -> !contain -> idx=1
//                -> 'd' -> contain -> 'e' -> !contain -> idx=2
//                -> 'f' -> !contain -> idx=3
//                -> 'g' -> !contain -> idx=4
//                -> 'h' -> !contain -> idx=5 // 끝
            }
            answer.append( temp );
        }

        return answer.toString();
    }
}
