package salesforce;
import java.util.ArrayList;
import java.util.List;

public class PhoneCombinations {
//
//    public static List<String> letterCombinations(String digits) {
//            List<String>answer = new ArrayList<String>();
//            if(digits.equals("")){
//                return answer;
//            }
//            answer.add("");
//            char [][]dp = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
//            for(int i=0;i<digits.length();i++){
//                char ch = digits.charAt(i);
//                ArrayList<String>temp = new ArrayList();
//                for(String a:answer){
//                    for(char c:dp[ch-'0']){
//                        temp.add(a + c);
//                    }
//
//                }
//                answer = temp;
//            }
//            return answer;
//    }

    public static List<String> letterCombinations(String digits){

        List<String> combinations = new ArrayList<String>();
        if(digits.equals("")){
            return combinations;
        }
        combinations.add("");
        char[][] mappings ={{},{},{'a', 'b', 'c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

        for(int i=0; i<digits.length(); i++){
            char c = digits.charAt(i);
            ArrayList<String> temp = new ArrayList<String>();
            for (String combine: combinations) {
                for(char add:mappings[c-'0']){
                    temp.add(combine+add);
                }
            }
            combinations = temp;
        }

        return combinations;
    }
    public static void main(String args[]){
        System.out.println(letterCombinations("23"));
    }

}
