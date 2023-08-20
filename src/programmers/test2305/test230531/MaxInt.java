package programmers.test2305.test230531;

public class MaxInt {
    public static void main( String[] args ) {
        MaxInt maxInt = new MaxInt();
        int[] arr = { 3, 5, 6, 1, 2, 4 };
        System.out.println( maxInt.findMax( arr ) );
    }

    public int findMax( int[] array ) {
        int max = Integer.MIN_VALUE;
        for ( int i = 0 ; i < array.length ; i++ ) {
            if ( max < array[i] ) {
                max = array[i];
            }
        }
        return max;
    }
}
