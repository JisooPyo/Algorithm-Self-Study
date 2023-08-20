package programmers.test2306.test230602;

import java.util.HashMap;
import java.util.Map;

public class Lev1_24 {
    public static void main( String[] args ) {
        Lev1_24 lev = new Lev1_24();

        String[] t1_1 = { "AN", "CF", "MJ", "RT", "NA" };
        int[] t1_2 = { 5, 3, 2, 7, 5 };

        String[] t2_1 = { "TR", "RT", "TR" };
        int[] t2_2 = { 7, 1, 3 };

        System.out.println( lev.solution( t1_1, t1_2 ) );
        System.out.println( lev.solution( t2_1, t2_2 ) );
    }

    public String solution( String[] survey, int[] choices ) {
        String answer = "";
        Map< String, Integer > score = new HashMap<>();
        score.put( "R", 0 );
        score.put( "T", 0 );
        score.put( "C", 0 );
        score.put( "F", 0 );
        score.put( "J", 0 );
        score.put( "M", 0 );
        score.put( "A", 0 );
        score.put( "N", 0 );
        for ( int i = 0 ; i < survey.length ; i++ ) {
            switch ( choices[i] ) {
                case 1:
                case 2:
                case 3: {
                    String key = Character.toString( survey[i].charAt( 0 ) );
                    Integer value = score.get( key );
                    Integer valuePlueScore = Integer.valueOf( value.intValue() + 4 - choices[i] );
                    score.put( key, valuePlueScore );
                    break;
                }
                case 5:
                case 6:
                case 7: {
                    String key = Character.toString( survey[i].charAt( 1 ) );
                    Integer value = score.get( key );
                    Integer valuePlueScore = Integer.valueOf( value.intValue() + choices[i] - 4 );
                    score.put( key, valuePlueScore );
                    break;
                }
                default: {
                    continue;
                }
            }
        }
        answer += score.get( "R" ).intValue() >= score.get( "T" ).intValue() ? "R" : "T";
        answer += score.get( "C" ).intValue() >= score.get( "F" ).intValue() ? "C" : "F";
        answer += score.get( "J" ).intValue() >= score.get( "M" ).intValue() ? "J" : "M";
        answer += score.get( "A" ).intValue() >= score.get( "N" ).intValue() ? "A" : "N";

        return answer;
    }
}

/*
테스트 1 〉	통과 (1.79ms, 72.5MB)
테스트 2 〉	통과 (2.50ms, 77.3MB)
테스트 3 〉	통과 (1.35ms, 83MB)
테스트 4 〉	통과 (1.71ms, 77.3MB)
테스트 5 〉	통과 (1.80ms, 83.3MB)
테스트 6 〉	통과 (1.86ms, 75.1MB)
테스트 7 〉	통과 (2.24ms, 81.9MB)
테스트 8 〉	통과 (1.38ms, 73.7MB)
테스트 9 〉	통과 (1.34ms, 79.1MB)
테스트 10 〉통과 (2.14ms, 102MB)
테스트 11 〉통과 (1.92ms, 80.5MB)
테스트 12 〉통과 (1.65ms, 75.8MB)
테스트 13 〉통과 (1.98ms, 76.4MB)
테스트 14 〉통과 (1.91ms, 80.1MB)
테스트 15 〉통과 (2.13ms, 78.4MB)
테스트 16 〉통과 (2.21ms, 76.8MB)
테스트 17 〉통과 (2.68ms, 68.9MB)
테스트 18 〉통과 (2.25ms, 75.7MB)
테스트 19 〉통과 (2.09ms, 75.3MB)
테스트 20 〉통과 (2.78ms, 70.5MB)
 */