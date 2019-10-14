import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class commonWords {


    public String mostCommonWord(String paragraph, String[] banned) {
        String para = paragraph.toLowerCase();
        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> countWords = new HashMap();
        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: para.toCharArray()){
            if(Character.isLetter(c)){
                word.append(Character.toLowerCase(c));
            }else if(word.length() > 0){

            }
        }
        return ans;
    }

    public static void main(String args[]){

        commonWords sample = new commonWords();
        String[] banned = {"hit"};
        System.out.println(sample.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",banned));
    }
}
