package programmers.test2305.test230529;

import java.util.Arrays;

public class Lev1_21_other {
    public static void main( String[] args ) {

        OtherSol21 other = new OtherSol21();

        String[] t1_keymap = { "ABACD", "BCEFD" };
        String[] t1_targets = { "ABCD", "AABB" };
        String[] t2_keymap = { "AA" };
        String[] t2_targets = { "B" };
        String[] t3_keymap = { "AGZ", "BSSS" };
        String[] t3_targets = { "ASA", "BGZ" };

        System.out.println( Arrays.toString( other.solution( t1_keymap, t1_targets ) ) );
        System.out.println( Arrays.toString( other.solution( t2_keymap, t2_targets ) ) );
        System.out.println( Arrays.toString( other.solution( t3_keymap, t3_targets ) ) );

    }


}
