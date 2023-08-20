package programmers.test2305.test230527;

public class Lev1_21 {
    public static void main( String[] args ) {
        Lev1_21 lev = new Lev1_21();
        int[] t1 = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        int[] t2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
        int[] t3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

        System.out.println( lev.solution( t1, "right" ) );
        System.out.println( lev.solution( t2, "left" ) );
        System.out.println( lev.solution( t3, "right" ) );
    }

    public String solution( int[] numbers, String hand ) {
        char[] answer = new char[numbers.length];
        int[][] keypad = {
                { 0, 0 }, { 0, 1 }, { 0, 2 },
                { 1, 0 }, { 1, 1 }, { 1, 2 },
                { 2, 0 }, { 2, 1 }, { 2, 2 },
                { 3, 0 }, { 3, 1 }, { 3, 2 }
        };
        int[] place = new int[] { 9, 11 };

        for ( int i = 0 ; i < numbers.length ; i++ ) {
            switch ( numbers[i] ) {
                case 1:
                case 4:
                case 7: {
                    place[0] = numbers[i] - 1;
                    answer[i] = 'L';
                    break;
                }
                case 2:
                case 5:
                case 8: {
                    int LD = Math.abs( keypad[place[0]][0] - keypad[numbers[i] - 1][0] )
                            + Math.abs( keypad[place[0]][1] - keypad[numbers[i] - 1][1] );
                    int RD = Math.abs( keypad[place[1]][0] - keypad[numbers[i] - 1][0] )
                            + Math.abs( keypad[place[1]][1] - keypad[numbers[i] - 1][1] );
                    if ( LD == RD ) {
                        if ( hand.equals( "left" ) ) {
                            answer[i] = 'L';
                            place[0] = numbers[i] - 1;
                        } else {
                            answer[i] = 'R';
                            place[1] = numbers[i] - 1;
                        }
                    } else if ( LD > RD ) {
                        answer[i] = 'R';
                        place[1] = numbers[i] - 1;
                    } else {
                        answer[i] = 'L';
                        place[0] = numbers[i] - 1;
                    }
                    break;
                }
                case 3:
                case 6:
                case 9: {
                    place[1] = numbers[i] - 1;
                    answer[i] = 'R';
                    break;
                }
                case 0: {
                    int LD = Math.abs( keypad[place[0]][0] - 3 )
                            + Math.abs( keypad[place[0]][1] - 1 );
                    int RD = Math.abs( keypad[place[1]][0] - 3 )
                            + Math.abs( keypad[place[1]][1] - 1 );
                    if ( LD == RD ) {
                        if ( hand.equals( "left" ) ) {
                            answer[i] = 'L';
                            place[0] = 10;
                        } else {
                            answer[i] = 'R';
                            place[1] = 10;
                        }
                    } else if ( LD > RD ) {
                        answer[i] = 'R';
                        place[1] = 10;
                    } else {
                        answer[i] = 'L';
                        place[0] = 10;
                    }
                    break;
                }
            }
        }
        return new String( answer );
    }
}
