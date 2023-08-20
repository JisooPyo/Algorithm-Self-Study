package programmers.test2306.test230627;

public class Lv2NextBigNumber_try1_pass {
    public static void main(String[] args) {
        Lv2NextBigNumber_try1_pass lv = new Lv2NextBigNumber_try1_pass();

        System.out.println(lv.solution(78));
        System.out.println(lv.solution(15));

    }

    public int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int countOneOfN = countOneOfStr(binaryN);
        int temp = 0;
        while (temp != countOneOfN) {
            n++;
            temp = countOneOfStr(Integer.toBinaryString(n));
        }
        return n;
    }

    public int countOneOfStr(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}

// Integer.bitCount() : 이진수로 변환시켰을 때, 1의 개수를 세어주는 메서드.


/*
정확성  테스트
테스트 1 〉통과 (0.04ms, 77MB)
테스트 2 〉통과 (0.04ms, 76MB)
테스트 3 〉통과 (0.04ms, 81.3MB)
테스트 4 〉통과 (0.04ms, 75MB)
테스트 5 〉통과 (0.04ms, 76.8MB)
테스트 6 〉통과 (0.04ms, 83.2MB)
테스트 7 〉통과 (0.06ms, 72.4MB)
테스트 8 〉통과 (0.03ms, 78.1MB)
테스트 9 〉통과 (0.05ms, 77.5MB)
테스트 10 〉통과 (0.04ms, 74.6MB)
테스트 11 〉통과 (0.03ms, 76.8MB)
테스트 12 〉통과 (0.03ms, 79.2MB)
테스트 13 〉통과 (0.04ms, 71.3MB)
테스트 14 〉통과 (0.04ms, 77.4MB)

효율성  테스트
테스트 1 〉통과 (0.04ms, 52.3MB)
테스트 2 〉통과 (0.04ms, 52.2MB)
테스트 3 〉통과 (0.04ms, 68MB)
테스트 4 〉통과 (0.04ms, 52.1MB)
테스트 5 〉통과 (0.06ms, 52.3MB)
테스트 6 〉통과 (0.03ms, 51.6MB)
 */