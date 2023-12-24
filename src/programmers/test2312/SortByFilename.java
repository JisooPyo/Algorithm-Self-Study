package programmers.test2312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortByFilename {
    public static void main(String[] args) {
        SortByFilename s = new SortByFilename();
        String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(Arrays.toString(s.solution(files1)));
        System.out.println(Arrays.toString(s.solution(files2)));
    }

    public String[] solution(String[] files) {
        File[] fileArray = new File[files.length];
        Map<File, String> fileNames = new HashMap<>();
        for (int i = 0; i < files.length; i++) {
            File file = getFile(files[i]);
            fileNames.put(file, files[i]);
            fileArray[i] = file;
        }
        Arrays.sort(fileArray);

        String[] answer = new String[files.length];
        int index = 0;
        for (File file : fileArray) {
            answer[index++] = fileNames.get(file);
        }
        
        return answer;
    }

    private File getFile(String file) {
        char[] chars = file.toCharArray();
        int numStart = 0;

        // HEAD 구하기
        StringBuilder head = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                numStart = i;
                break;
            } else {
                head.append(chars[i]);
            }
        }

        // NUMBER 구하기
        StringBuilder number = new StringBuilder();
        for (int i = numStart; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                number.append(chars[i]);
            } else {
                break;
            }
        }

        return new File(head.toString(), Integer.parseInt(number.toString()));
    }

    public class File implements Comparable<File> {
        private String head;
        private int number;

        public File(String head, int number) {
            this.head = head.toLowerCase();
            this.number = number;
        }

        @Override
        public int compareTo(File o) {
            int headCompare = this.head.compareTo(o.getHead());
            if (headCompare != 0) {
                return headCompare;
            }
            return this.number - o.getNumber();
        }

        public String getHead() {
            return head;
        }

        public int getNumber() {
            return number;
        }
    }
}
