package programmers.test2312;

import java.util.*;

public class OpenChatRoom {
    public static void main(String[] args) {
        OpenChatRoom o = new OpenChatRoom();
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(o.solution(record)));
    }

    public String[] solution(String[] record) {
        // id, nickname
        Map<String, String> nicknames = new HashMap<>();
        for (String str : record) {
            String[] recordSplit = str.split(" ");
            if (recordSplit[0].equals("Enter") || recordSplit[0].equals("Change")) {
                nicknames.put(recordSplit[1], recordSplit[2]);
            }
        }

        // 기록
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        List<String> recordList = new ArrayList<>();
        for (String str : record) {
            String[] recordSplit = str.split(" ");
            if (recordSplit[0].equals("Change")) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(nicknames.get(recordSplit[1]));
            if (recordSplit[0].equals("Enter")) {
                sb.append(enter);
                recordList.add(sb.toString());
                continue;
            }
            if (recordSplit[0].equals("Leave")) {
                sb.append(leave);
                recordList.add(sb.toString());
            }
        }

        // list -> array
        String[] answer = new String[recordList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = recordList.get(i);
        }
        
        return answer;
    }
}
