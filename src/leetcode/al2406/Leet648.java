package leetcode.al2406;

import java.util.ArrayList;
import java.util.List;

import leetcode.explore.trie.Trie;

/**
 * Medium
 * 648. Replace Words
 *
 * 영어에서는 root 라는 개념이 있다. root 뒤에는 다른 단어가 붙어 다른 긴 단어를 형성할 수 있다.
 * 이를 derivative, 파생어라 한다. 예를 들어,
 * root "help" 뒤에 단어 "ful"이 붙어 파생어 "helpful"을 형성할 수 있다.
 *
 * Given
 * dictionary : 많은 root 로 이루어져 있는 List
 * sentence : 빈칸으로 나누어져 있는 단어들로 이루어진 문자열
 *
 *
 * Return
 * sentence 내의 모든 파생를 root 로 대체하고, 대체한 이후의 sentence 를 구하라.
 *
 * Note
 * 만약 파생어가 한 개 이상의 root 로 대체할 수 있다면, 더 짧은 길이의 root 로 대체하라.
 */
public class Leet648 {
    public static void main(String[] args) {
        Leet648 l = new Leet648();

        List<String> dictionary1 = new ArrayList<>();
        dictionary1.add("cat");
        dictionary1.add("bat");
        dictionary1.add("rat");
        String sentence1 = "the cattle was rattled by the battery";

        List<String> dictionary2 = new ArrayList<>();
        dictionary2.add("a");
        dictionary2.add("b");
        dictionary2.add("c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";

        List<String> dictionary3 = List.of("e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm",
            "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm",
            "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem",
            "xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz",
            "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref", "qbx",
            "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw");
        String sentence3 = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";

        System.out.println(l.replaceWords(dictionary1, sentence1));
        System.out.println(l.replaceWords(dictionary2, sentence2));
        System.out.println(l.replaceWords(dictionary3, sentence3));
    }

    // 내 풀이
    // Trie 구조를 구현하여 풀었다. 풀이 시간 : 1h 7m
    // 처음에는 배열이 아니라 List로 풀다가 배열이 빠를 것 같아서 다시 구현함.
    // 10ms로 해결.
    StringBuilder sb;

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie[] trieDictionary = new Trie[26];
        for (String str : dictionary) {
            saveDictionary(trieDictionary, str, 0);
        }
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            sb = new StringBuilder();
            findPrefix(trieDictionary, split[i], 0);
            if (!sb.isEmpty()) {
                split[i] = sb.toString();
            }
        }

        return splitToString(split);
    }

    private String splitToString(String[] split) {
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            sb.append(str);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void findPrefix(Trie[] trieDictionary, String str, int index) {
        if (index == str.length()) {
            sb = new StringBuilder();
            return;
        }
        Trie trie = trieDictionary[str.charAt(index) - 'a'];
        if (trie == null) {
            sb = new StringBuilder();
            return;
        }
        sb.append(trie.character);
        if (trie.isEnd) {
            return;
        }
        findPrefix(trie.alphabet, str, index + 1);
    }

    private void saveDictionary(Trie[] trieDictionary, String str, int index) {
        Trie trie = trieDictionary[str.charAt(index) - 'a'];
        if (trie == null) {
            trie = new Trie();
            trieDictionary[str.charAt(index) - 'a'] = trie;
            trie.character = str.charAt(index);
        }
        if (index == str.length() - 1) {
            trie.isEnd = true;
            return;
        }
        saveDictionary(trie.alphabet, str, index + 1);
    }

    public class Trie {
        char character;
        Trie[] alphabet;
        boolean isEnd;

        public Trie() {
            this.alphabet = new Trie[26];
        }
    }
}
