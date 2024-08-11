package programmers.test2408;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.crypto.Data;

public class Pcce10 {
    public static void main(String[] args) {
        Pcce10 pcce10 = new Pcce10();
        // 코드 번호, 제조일, 최대 수량, 현재 수량
        int[][] data = {
            {1, 20300104, 100, 80},
            {2, 20300804, 847, 37},
            {3, 20300401, 10, 8}
        };
        // [[3,20300401,10,8],[1,20300104,100,80]]
        System.out.println(
            Arrays.deepToString(
                pcce10.solution(data, "date", 20300501, "remain")
            )
        );
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> list = new ArrayList<>();
        int index = -1;
        switch (ext) {
            case "code":
                index = 0;
                break;
            case "date":
                index = 1;
                break;
            case "maximum":
                index = 2;
                break;
            case "remain":
                index = 3;
                break;
            default:
                break;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i][index] < val_ext) {
                list.add(new Data(
                    data[i][0],
                    data[i][1],
                    data[i][2],
                    data[i][3]
                ));
            }
        }
        switch (sort_by) {
            case "code":
                list.sort((a, b) -> a.code - b.code);
                break;
            case "date":
                list.sort((a, b) -> a.date - b.date);
                break;
            case "maximum":
                list.sort((a, b) -> a.max - b.max);
                break;
            case "remain":
                list.sort((a, b) -> a.cur - b.cur);
                break;
            default:
                break;
        }
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).code;
            answer[i][1] = list.get(i).date;
            answer[i][2] = list.get(i).max;
            answer[i][3] = list.get(i).cur;
        }
        return answer;
    }

    class Data {
        int code;
        int date;
        int max;
        int cur;

        public Data(int code, int date, int max, int cur) {
            this.code = code;
            this.date = date;
            this.max = max;
            this.cur = cur;
        }
    }
}
