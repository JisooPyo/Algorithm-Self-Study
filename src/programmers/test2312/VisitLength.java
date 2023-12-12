package programmers.test2312;

import java.util.HashSet;
import java.util.Set;

public class VisitLength {
    public static void main(String[] args) {
        VisitLength v = new VisitLength();

        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";

        System.out.println(v.solution(dirs1));  // 7
        System.out.println(v.solution(dirs2));  // 7
    }

    public int solution(String dirs) {
        Set<String> routes = new HashSet<>();

        int cX = 0;
        int cY = 0;
        char[] moves = dirs.toCharArray();
        for (int i = 0; i < moves.length; i++) {
            int dX = moveX(cX, moves[i]);
            int dY = moveY(cY, moves[i]);
            if (cX == dX && cY == dY) {
                continue;
            }
            String route = appendCoordinate(cX, cY, dX, dY);
            routes.add(route);
            cX = dX;
            cY = dY;
        }

        return routes.size();
    }

    private String appendCoordinate(int cX, int cY, int dX, int dY) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.min(cX, dX));
        sb.append(Math.min(cY, dY));
        sb.append(Math.max(cX, dX));
        sb.append(Math.max(cY, dY));
        return sb.toString();
    }

    private int moveX(int cX, char move) {
        if (move == 'L') {
            return Math.max(cX - 1, -5);
        }
        if (move == 'R') {
            return Math.min(cX + 1, 5);
        }
        return cX;
    }

    private int moveY(int cY, char move) {
        if (move == 'U') {
            return Math.min(cY + 1, 5);
        }
        if (move == 'D') {
            return Math.max(cY - 1, -5);
        }
        return cY;
    }
}
