package bookStudy.study2409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 프로그래머스 lv.3
 * 22. 베스트 앨범
 */
public class Problem22 {
    public static void main(String[] args) {
        Problem22 p = new Problem22();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        // [4, 1, 3, 0]
        System.out.println(Arrays.toString(p.solution(genres, plays)));
    }

    // 내 풀이
    // 책 풀이도 구현 방식은 내 풀이와 비슷한데 Stream API를 써서 따로 class를 정의해주지 않고 풀었다.
    public int[] solution(String[] genres, int[] plays) {
        // 장르당 재생 수
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르당 재생 수 별로 정렬
        List<SongCount> list = new ArrayList<>();
        for (String genre : count.keySet()) {
            list.add(new SongCount(genre, count.get(genre)));
        }
        list.sort((a, b) -> b.plays - a.plays);

        // 장르당 곡 저장 => TreeSet에 저장하여 저장하면서 조건에 맞게 정렬
        Map<String, TreeSet<Song>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (map.get(genres[i]) == null) {
                TreeSet<Song> set = new TreeSet<>((o1, o2) -> {
                    if (o1.plays != o2.plays) {
                        return Integer.compare(o2.plays, o1.plays);
                    } else {
                        return Integer.compare(o1.index, o2.index);
                    }
                });
                set.add(new Song(i, plays[i]));
                map.put(genres[i], set);
            } else {
                map.get(genres[i]).add(new Song(i, plays[i]));
            }
        }

        // 장르 별 노래 두 개씩 모으기
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int index = 0;
            for (Song song : map.get(list.get(i).genre)) {
                if (index == 2) {
                    break;
                }
                result.add(song.index);
                index++;
            }
        }

        // List -> array
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    class SongCount {
        String genre;
        int plays;

        public SongCount(String genre, int plays) {
            this.genre = genre;
            this.plays = plays;
        }
    }

    class Song {
        int index;
        int plays;

        Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
}
/*
테스트 1 〉	통과 (1.85ms, 76.6MB)
테스트 2 〉	통과 (1.62ms, 77MB)
테스트 3 〉	통과 (1.77ms, 77.3MB)
테스트 4 〉	통과 (1.67ms, 74.8MB)
테스트 5 〉	통과 (1.91ms, 75.3MB)
테스트 6 〉	통과 (1.96ms, 76.2MB)
테스트 7 〉	통과 (1.62ms, 73.3MB)
테스트 8 〉	통과 (1.97ms, 69.8MB)
테스트 9 〉	통과 (1.57ms, 73.7MB)
테스트 10 〉	통과 (1.88ms, 74MB)
테스트 11 〉	통과 (1.84ms, 75.1MB)
테스트 12 〉	통과 (1.74ms, 70.4MB)
테스트 13 〉	통과 (2.72ms, 76.1MB)
테스트 14 〉	통과 (2.06ms, 72.4MB)
테스트 15 〉	통과 (1.64ms, 72.5MB)
 */
