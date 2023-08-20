package programmers.test2305.test230529;

import java.util.Arrays;

public class OtherSol21 {

    public int[] solution( String[] keymap, String[] targets ) {
        int[] minTouch = new int['Z' - 'A' + 1];
        // 'Z'-'A'+1 = 26;
        Arrays.fill( minTouch, 200 );
        // minTouch 배열을 200의 값으로 채울 것.


        for ( String key : keymap ) {
            // key = "ABACD", "BCEFD"
            for ( int i = 0 ; i < key.length() ; i++ ) {
                minTouch[key.charAt( i ) - 'A'] = Math.min( minTouch[key.charAt( i ) - 'A'], i + 1 );
                // minTouch['A' - 'A'] = Math.min( minTouch['A'-'A'], 1 )   // 'A'는 1번
                // minTouch['B' - 'A'] = Math.min( minTouch['B'-'A'], 2 )   // 'B'는 2번
                // minTouch['A' - 'A'] = Math.min( minTouch['A'-'A'], 3 )   // 이미 1번이 들어갔으므로 1번
                // minTouch['C' - 'A'] = Math.min( minTouch['C'-'A'], 4 )   // 'C'는 4번
                // minTouch['D' - 'A'] = Math.min( minTouch['D'-'A'], 5 )   // 'D'는 5번


                // minTouch['B' - 'A'] = Math.min( minTouch['B'-'A'], 1 )   // 들어간 2보다 작은 1이 들어가서 'B'는 1번
                // minTouch['C' - 'A'] = Math.min( minTouch['C'-'A'], 2 )   // 들어간 4보다 작은 2가 들어가서 'C'는 2번
                // minTouch['E' - 'A'] = Math.min( minTouch['E'-'A'], 3 )   // 'E'는 3번
                // minTouch['F' - 'A'] = Math.min( minTouch['F'-'A'], 4 )   // 'F'는 4번
                // minTouch['D' - 'A'] = Math.min( minTouch['D'-'A'], 5 )   // 'D'는 그대로 5번

            }
        }

        // minTouch -> 'A' : 1, 'B' : 1, 'C' : 4, 'D' : 5, 'E' : 3, 'F' : 4
        // 각 알파벳의 최소터치수를 구해 놓음.

        int[] answer = new int[targets.length];

        for ( int i = 0 ; i < targets.length ; i++ ) {
            String target = targets[i];
            int sum = 0;
            boolean canMake = true;
            // target : "ABCD", "AABB"
            for ( int j = 0 ; j < target.length() ; j++ ) {
                if ( minTouch[target.charAt( j ) - 'A'] == 200 ) {
                    // 하나라도 만들 수 없다면 false.
                    canMake = false;
                    break;
                }
                sum += minTouch[target.charAt( j ) - 'A'];
            }
            answer[i] = canMake ? sum : -1;
        }
        return answer;
    }

}

// 코드 리뷰
// 전체적으로 푸는 논리는 비슷하다. 나는 삼중 for문을 돌렸고 여기서는 for문, 이중for문을 돌려서 훨씬 더 시간이 빨랐던 것 같다.
// for문이 겹쳐 있다면 for문을 분리할 방법을 생각해 볼 것.