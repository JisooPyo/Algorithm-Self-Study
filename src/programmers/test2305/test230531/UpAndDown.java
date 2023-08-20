package programmers.test2305.test230531;

import java.util.Scanner;

public class UpAndDown {
    public static void main( String[] args ) {
        int random = (int) ( Math.random() * 100 );
        Scanner sc = new Scanner( System.in );
        int count = 0;
        while ( true ) {
            int check = sc.nextInt();
            if ( check > random ) {
                System.out.println( "DOWN" );
                count++;
            } else if ( check < random ) {
                System.out.println( "UP" );
                count++;
            } else {
                System.out.println( "CORRECT" );
                count++;
                System.out.println( "숫자 입력한 횟수 : " + count + "회" );
                break;
            }
        }
    }
}
