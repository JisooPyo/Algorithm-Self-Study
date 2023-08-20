package programmers.test2305.test230530;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SelfStudy {
    public static void main( String[] args ) {
        String str = "abcde";
        System.out.println( Arrays.toString( str.chars().toArray() ) );
        Set< Character > charSet;
        charSet = str.chars().mapToObj( character -> (char) character ).collect( Collectors.toSet() );
        System.out.println(charSet);

    }
}
