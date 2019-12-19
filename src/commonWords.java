import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class commonWords {


    public String mostCommonWord(String paragraph, String[] banned) {
        String res = "";
        String[] para = paragraph.toLowerCase().split("\\W+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        int max = 0;
        for (String s : para) {
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                max = Math.max(max, map.get(s));
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                res = s;
            }
        }
        return res;
    }

    public static void main(String args[]){

        commonWords sample = new commonWords();
        String[] banned = {"hit"};
        System.out.println(sample.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",banned));
    }
}
