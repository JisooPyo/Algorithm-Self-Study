// 카드 뭉치
package programmers.test2305.test230512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lev1_10 {
    public static void main( String[] args ) {
        Lev1_10 lev = new Lev1_10();

        String[] t1_1 = { "i", "drink", "water" };
        String[] t1_2 = { "want", "to" };
        String[] t1_3 = { "i", "want", "to", "drink", "water" };

        String[] t2_1 = { "i", "water", "drink" };
        String[] t2_2 = { "want", "to" };
        String[] t2_3 = { "i", "want", "to", "drink", "water" };

        String[] t3_1 = { "i", "drink", "water", "java" };
        String[] t3_2 = { "want", "to", "and", "water" };
        String[] t3_3 = { "i", "want", "to", "drink", "water", "and", "water" };

        String[] t4_1 = { "i", "see", "to" };
        String[] t4_2 = { "you", "now", "me" };
        String[] t4_3 = { "i", "see", "now", "me" };
//        기댓값 : "No"

        System.out.println( lev.solution( t1_1, t1_2, t1_3 ) );
        System.out.println( lev.solution( t2_1, t2_2, t2_3 ) );
        System.out.println( lev.solution( t3_1, t3_2, t3_3 ) );
        System.out.println( lev.solution( t4_1, t4_2, t4_3 ) );
    }

    public String solution( String[] cards1, String[] cards2, String[] goal ) {
        List< String > list1 = new ArrayList<>( Arrays.asList( cards1 ) );
        List< String > list2 = new ArrayList<>( Arrays.asList( cards2 ) );
        List< String > list_goal = new ArrayList<>( Arrays.asList( goal ) );

        while ( list_goal.size() > 0 ) {
            String str1 = list1.size() == 0 ? "A" : list1.get( 0 );
            String str2 = list2.size() == 0 ? "A" : list2.get( 0 );
            String str_g = list_goal.get( 0 );
            if ( str_g.equals( str1 ) ) {
                list1.remove( str1 );
                list_goal.remove( str_g );
            } else if ( str_g.equals( str2 ) ) {
                list2.remove( str2 );
                list_goal.remove( str_g );
            } else {
                return "No";
            }
        }
        return "Yes";

    }
}

// 14, 15, 16, 17, 20, 21, 25 틀림.
// 아마 goal에 같은 문자가 두 개 들어가는 문제 때문에 그렇다고 판단. 다시 다른 방법으로 풀어보자.

// goal에 같은 문자가 두 개 들어가면 하나를 빼면 된다고 생각해서 하나를 뺐는데 20, 21, 25가 틀림
// 문제를 다시 읽어보니 goal의 길이 <= cards1의 길이 + cards2의 길이
// 즉 다른 단어도 섞여 있을 수 있다는 뜻..!

// 위를 고려하여 if ( list.indexOf( cards2[i] ) == -1 ) continue; 를 넣었는데 25가 틀림.

// 애초에 순서는 다 맞더라도 덜 들어가있을 수 있는 경우를 생각해서 마지막에 return list.size() == 0 ? "Yes" : "No";
// 를 넣어주었다. -> 또 틀림.

// 카드를 순서대로 꺼내야 해서 처음부터 다시 했다. 반례를 푸는 것을 목적으로! >> 끝

/*

다른 사람의 풀이

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardIdx1 = 0;
        int cardIdx2 = 0;

        for(int i=0; i<goal.length; i++){
            String target = goal[i];

            if(cardIdx1 < cards1.length && target.equals(cards1[cardIdx1]))
                cardIdx1 ++;
            else if (cardIdx2 < cards2.length && target.equals(cards2[cardIdx2]))
                cardIdx2++;
            else
                return "No";
        }


        return "Yes";
    }

 */



