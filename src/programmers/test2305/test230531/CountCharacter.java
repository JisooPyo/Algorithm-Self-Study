package programmers.test2305.test230531;

public class CountCharacter {
    public static void main( String[] args ) {
        CountCharacter countCharacter = new CountCharacter();

        System.out.println( countCharacter.findAnswer( "abc" ) );
        System.out.println( countCharacter.findAnswer( "aaabbbc" ) );
        System.out.println( countCharacter.findAnswer( "abbbc" ) );
        System.out.println( countCharacter.findAnswer( "ahhhhz" ) );
        System.out.println( countCharacter.findAnswer( "acccdeee" ) );
    }

    public String findAnswer( String target ) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for ( int i = 0 ; i < target.length() - 1 ; i++ ) {
            if ( target.charAt( i ) == target.charAt( i + 1 ) ) {
                count += 1;
            } else {
                sb.append( target.charAt( i ) );
                sb.append( count + 1 );
                sb.append( " " );
                count = 0;
            }
        }
        sb.append( target.charAt( target.length() - 1 ) );
        sb.append( count + 1 );

        return sb.toString();
    }
}
