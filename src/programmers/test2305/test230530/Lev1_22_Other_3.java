package programmers.test2305.test230530;

import java.util.ArrayList;

public class Lev1_22_Other_3 {
    public static void main( String[] args ) {
        Lev1_22_Other_3 lev = new Lev1_22_Other_3();
        long beforeTime = System.currentTimeMillis();
        System.out.println( lev.solution( "aukks", "wbqd", 5 ) );
        long afterTime = System.currentTimeMillis();
        long secDiffTime = afterTime - beforeTime;
        System.out.println( "시간차이 : " + secDiffTime );

    }

    public String solution( String s, String skip, int index ) {
        char[] sArr = s.toCharArray();
        // {'a','u','k','k','s'}
        char[] skipArr = skip.toCharArray();
        // {'w','b','q','d'}
        ArrayList< Character > alphabet = new ArrayList<>();

        for ( int i = 0 ; i <= 25 ; i++ ) {
            alphabet.add( (char) ( i + 97 ) );
        }
        // alphabet = {'a','b','c',...,'z'}
        for ( char c : skipArr ) {
            alphabet.remove( Character.valueOf( c ) );
        }
        // alphabet에서 skip 제거.
        int size = alphabet.size();
        // 알파벳 26개에서 skip만큼 뺀 값
        for ( int c = 0 ; c < sArr.length ; c++ ) {
            int indexNum = alphabet.indexOf( sArr[c] ) + index;
            indexNum = indexNum % size;
            sArr[c] = alphabet.get( indexNum );
        }

        String answer = new String( sArr );

        return answer;
    }
}

// 나랑 로직은 비슷했는데 시간 복잡도가 잘 줄여진 거 같다!