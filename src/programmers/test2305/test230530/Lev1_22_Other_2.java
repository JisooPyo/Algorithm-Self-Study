package programmers.test2305.test230530;

import java.util.Set;
import java.util.stream.Collectors;

public class Lev1_22_Other_2 {
    public static void main( String[] args ) {
        Lev1_22_Other_2 lev = new Lev1_22_Other_2();
        long beforeTime = System.currentTimeMillis();
        System.out.println( lev.solution( "aukks", "wbqd", 5 ) );
        long afterTime = System.currentTimeMillis();
        long secDiffTime = afterTime - beforeTime;
        System.out.println( "시간차이 : " + secDiffTime );

    }

    public String solution( String s, String skip, int index ) {
        return new StringGenerator( index, skip ).generate( s );
    }

    private static class StringGenerator {
        private final Integer offsetIndex;  // 여기에 index가 들어가고
        private final Set< Character > skipCharacters; // 스킵할 char가 Set으로 되어 들어간다.

        public StringGenerator( Integer offsetIndex, String skipCharacters ) {
            this( offsetIndex, parseSkipCharacters( skipCharacters ) );
            // ok
        }

        public StringGenerator( Integer offsetIndex, Set< Character > skipCharacters ) {
            this.offsetIndex = offsetIndex;
            this.skipCharacters = skipCharacters;
        }

        public String generate( String base ) {
            return base.chars()
                    .mapToObj( character -> (char) character )
                    // base가 되는 것들의 char의 스트림.
                    // [a,u,k,k,s]
                    .map( this::applyOffset )
                    // [h,a,p,p,y]
                    .map( String::valueOf )
                    // Stream<Character> -> Stream<String>
                    .collect( Collectors.joining() );
                    // Stream에서 작업한 결과를 1개의 String으로 이어붙이기를 원하는 경우 쓴다.
                    // 위의 경우는 String "happy" 리턴.
        }

        private Character applyOffset( Character character ) {
            int count = 0;
            Character applied = character;

            while ( count < offsetIndex ) {
                applied++;

                if ( applied > 'z' ) {
                    applied = 'a';
                }

                if ( skipCharacters.contains( applied ) ) {
                    continue;
                }

                count++;
            }

            return applied;
        }

        private static Set< Character > parseSkipCharacters( String skipCharacters ) {
            // 여기에 skip이 들어가고..
            return skipCharacters.chars()
                    // chars() : 각 인덱스의 char의 값을 intstream으로 리턴.
                    .mapToObj( character -> (char) character )
                    // IntStream -> Stream<Character>
                    .collect( Collectors.toSet() );
                    // 스트림을 컬렉션 Set<Character>으로 반환 {a,b,c,d,e}
                    // 왜 toCharArray 안 쓰고.. 복잡하게..
        }
    }
}
