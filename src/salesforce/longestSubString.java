package salesforce;
import java.util.HashMap;

//Longest non repeating substring using sliding window and HashMap

public class longestSubString {

    public static int lengthOfLongestSubstring(String s) {

        //Maintains the last position of the character
        HashMap<Character, Integer> charPosition = new HashMap<Character, Integer>();
        //current maxing length of no repeating character
        int answer = 0;

        for(int j=0,i=0; j< s.length(); j++){

            if(charPosition.containsKey(s.charAt(j))) {
                //If a character had repeated slide the window by moving i
                i = Math.max(charPosition.get(s.charAt(j)), i);
            }
            //Update answer if it is larger than the previous sliding window
            answer = Math.max(answer, j-i +1);
            //Update j's position
            charPosition.put(s.charAt(j),j+1);
        }
        return answer;

    }

    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("abcdvdolkb"));
    }
}
