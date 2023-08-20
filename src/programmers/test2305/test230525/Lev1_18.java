package programmers.test2305.test230525;

import java.util.HashMap;
import java.util.Map;

public class Lev1_18 {
    public static void main( String[] args ) {
        Lev1_18 lev = new Lev1_18();

        String[] t1_1 = { "leo", "kiki", "eden" };
        String[] t1_2 = { "eden", "kiki" };

        String[] t2_1 = { "marina", "josipa", "nikola", "vinko", "filipa" };
        String[] t2_2 = { "josipa", "filipa", "marina", "nikola" };

        String[] t3_1 = { "mislav", "stanko", "mislav", "ana" };
        String[] t3_2 = { "stanko", "ana", "mislav" };

        System.out.println( lev.solution( t1_1, t1_2 ) );
        System.out.println( lev.solution( t2_1, t2_2 ) );
        System.out.println( lev.solution( t3_1, t3_2 ) );

        Map< Integer, String > map = new HashMap<>();
        for ( Map.Entry entry : map.entrySet() ) {
            Object key = entry.getKey();
            Object value = entry.getValue();
        }

    }

    public String solution( String[] participant, String[] completion ) {
        Map< String, Integer > partMap = new HashMap<>();
        for ( String part : participant ) {
            partMap.put( part, partMap.getOrDefault( part, 0 ) + 1 );
        }
        for ( String comp : completion ) {
            partMap.replace( comp, partMap.get( comp ) - 1 );
        }
        for ( Map.Entry entry : partMap.entrySet() ) {
            if ( entry.getValue().equals( 1 ) ) {
                return entry.getKey().toString();
            }
        }
        return "";
    }
}

// List에 add 하고 remove하여 get(0)를 가져온다.

// 정확성 테스트 다 통과
// 효율성 테스트 1, 2, 3, 4, 5 실패.


// 빨리 하려면 Map을 쓰는 것이 좋을 것 같다.
// 동명이인 처리는 어떻게 할 것인가?
