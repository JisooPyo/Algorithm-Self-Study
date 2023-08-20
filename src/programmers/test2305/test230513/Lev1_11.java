package programmers.test2305.test230513;

public class Lev1_11 {
    public static void main( String[] args ) {
        Lev1_11 lev = new Lev1_11();

        System.out.println( lev.solution( "1S2D*3T" ) );
        System.out.println( lev.solution( "1D2S#10S" ) );
        System.out.println( lev.solution( "1D2S0T" ) );
        System.out.println( lev.solution( "1S*2T*3S" ) );
        System.out.println( lev.solution( "1D#2S*3S" ) );
        System.out.println( lev.solution( "1T2D3D#" ) );
        System.out.println( lev.solution( "1D2S3T*" ) );
    }

    public int solution( String dartResult ) {
        String num = dartResult.replaceAll( "[A-Z]", " " );
        num = num.replaceAll( "[*|#]", "" );
        int[] fin_score = new int[3];
        String[] sp = num.split( " " );
        for ( int i = 0 ; i < sp.length ; i++ ) {
            int score = Integer.parseInt( sp[i] );
            dartResult = dartResult.replaceFirst( sp[i], "" );
            switch ( dartResult.charAt( 0 ) ) {
                case 'D' -> {
                    score = score * score;
                }
                case 'T' -> {
                    score = score * score * score;
                }
            }
            dartResult = dartResult.substring( 1 );
            if ( dartResult.length() == 0 ) {
                fin_score[i] = score;
                break;
            }
            if ( dartResult.charAt( 0 ) == '*' || dartResult.charAt( 0 ) == '#' ) {
                if ( i == 0 && dartResult.charAt( 0 ) == '*' ) {
                    score = score * 2;
                } else if ( dartResult.charAt( 0 ) == '*' ) {
                    score = score * 2;
                    fin_score[i - 1] = fin_score[i - 1] * 2;
                } else if ( dartResult.charAt( 0 ) == '#' ) {
                    score = score * ( -1 );
                }
                dartResult = dartResult.substring( 1 );
            }
            fin_score[i] = score;
        }

        return fin_score[0] + fin_score[1] + fin_score[2];
    }

}

//    Pattern p = Pattern.compile( "^([0-9]*)[A-Z][*|#]?$" );
//        String str = "1S";
//        Matcher matcher = p.matcher( str );
//        System.out.println(matcher.find());

// ^([0-9]*)[A-Z]$  10D true
// ^([0-9]*)[A-Z][*|#]$     10D false
// ^([0-9]*)[A-Z][*|#]?$    10D true
