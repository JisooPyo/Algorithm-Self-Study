package programmers.test2408;

public class Pcce8 {
    public static void main(String[] args) {
        Pcce8 p = new Pcce8();
        String[] storage1 = {"pencil", "pencil", "pencil", "book"};
        int[] num1 = {2, 4, 3, 1};
        String[] storage2 = {"doll", "doll", "doll", "doll"};
        int[] num2 = {1, 1, 1, 1};
        String[] storage3 = {"apple", "steel", "leaf", "apple", "leaf"};
        int[] num3 = {5, 3, 5, 3, 7};
        String[] storage4 = {"mirror", "net", "mirror", "net", "bottle"};
        int[] num4 = {4, 1, 4, 1, 5};
        System.out.println(p.solution(storage1, num1));     // pencil
        System.out.println(p.solution(storage2, num2));     // doll
        System.out.println(p.solution(storage3, num3));     // leaf
        System.out.println(p.solution(storage4, num4));     // mirror
    }

    public String solution(String[] storage, int[] num) {
        int num_item = 0;
        String[] clean_storage = new String[storage.length];
        int[] clean_num = new int[num.length];

        for (int i = 0; i < storage.length; i++) {
            int clean_idx = -1;
            for (int j = 0; j < num_item; j++) {
                if (storage[i].equals(clean_storage[j])) {
                    clean_idx = j;
                    break;
                }
            }
            if (clean_idx == -1) {
                clean_storage[num_item] = storage[i];
                clean_num[num_item] = num[i];
                num_item += 1;
            } else {
                clean_num[clean_idx] += num[i];
            }
        }

        // 아래 코드에는 틀린 부분이 없습니다.
        int num_max = -1;
        String answer = "";
        for (int i = 0; i < num_item; i++) {
            if (clean_num[i] > num_max) {
                num_max = clean_num[i];
                answer = clean_storage[i];
            }
        }
        return answer;
    }
}
