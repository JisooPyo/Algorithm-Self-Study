package programmers.test2312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ParkingFeeCalculation {
    public static void main(String[] args) {
        ParkingFeeCalculation p = new ParkingFeeCalculation();
        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        int[] fees1 = {180, 5000, 10, 600};
        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        // [14600, 34400, 5000]

        int[] fees2 = {120, 0, 60, 591};
        String[] records2 = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        // [0, 591]

        int[] fees3 = {1, 461, 1, 10};
        String[] records3 = {"00:00 1234 IN"};
        // [14841]

        System.out.println(Arrays.toString(p.solution(fees1, records1)));
        System.out.println(Arrays.toString(p.solution(fees2, records2)));
        System.out.println(Arrays.toString(p.solution(fees3, records3)));
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> saveRecord = new HashMap<>();
        TreeMap<String, Integer> parkingFee = new TreeMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");
            int time = getMinuteFromTime(split[0]);
            if (split[2].equals("IN")) {
                saveRecord.put(split[1], time);
                continue;
            }
            parkingFee.put(
                    split[1],
                    parkingFee.getOrDefault(split[1], 0) + time - saveRecord.get(split[1]));
            saveRecord.remove(split[1]);
        }

        int defaultEnd = 23 * 60 + 59;
        for (String key : saveRecord.keySet()) {
            parkingFee.put(
                    key,
                    parkingFee.getOrDefault(key, 0) + defaultEnd - saveRecord.get(key)
            );
        }

        int[] answer = new int[parkingFee.size()];

        int index = 0;
        for (String key : parkingFee.keySet()) {
            int time = parkingFee.get(key);
            int fee = fees[1];
            if (time > fees[0]) {
                fee += getAdditionalFee(fees, time);
            }
            answer[index] = fee;
            index++;
        }
        return answer;
    }

    private int getAdditionalFee(int[] fees, int time) {
        int additionalTime = time - fees[0];
        int multiple = additionalTime % fees[2] == 0 ? additionalTime / fees[2] : (additionalTime / fees[2]) + 1;
        return multiple * fees[3];
    }

    private int getMinuteFromTime(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        int minute = Integer.parseInt(s.substring(3, 5));
        return hour * 60 + minute;
    }
}
