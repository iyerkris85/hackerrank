/**
 * Created by krishnandevarajan on 3/7/18.
 */

import java.util.*;
public class Sherlock {

    static String isValid(String s){
        // Complete this function
        char stringChars[] = s.toCharArray();
        Map<Character,Integer> countHashMap = new HashMap<Character, Integer>();
        int noofHighFrequency = 0;
        int uniqueChars = 0;
        int highestFrequency = 1;
        for(char c: stringChars){
            if(countHashMap.containsKey(c)){
                countHashMap.put(c, countHashMap.get(c) + 1);
                if(countHashMap.get(c) > highestFrequency){
                    highestFrequency = countHashMap.get(c);
                }
            }else{
                countHashMap.put(c,1);
                uniqueChars++;
            }
        }

        //Get no of characters that have the highestFrequency of appearance
        for(Map.Entry<Character,Integer> entry: countHashMap.entrySet()){
            if(entry.getValue() == highestFrequency){
                noofHighFrequency++;
            }
            //System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        //System.out.println("HighFrequency : " + highestFrequency);
        //System.out.println("No of HighFrequency : " +  noofHighFrequency);
        //System.out.println("Length : " +  uniqueChars);

        //If all characters in the string have highestFrequency of Appearance
        if( noofHighFrequency == uniqueChars){
            return "YES";
        }else if(noofHighFrequency == (uniqueChars-1)){
            //If all characters have the highest frequency except for one
            for(Map.Entry<Character,Integer> entry: countHashMap.entrySet()){
                if(entry.getValue() < highestFrequency && entry.getValue() != 1){
                    return "NO";
                }
            }
            return "YES";
        }else if(noofHighFrequency == 1){
            //If only one character has a higher Frequency
            int count = 0;
            for(Map.Entry<Character,Integer> entry: countHashMap.entrySet()){
                if(entry.getValue() != (highestFrequency-1)){
                    count++;
                }
            }
            if(count != 1){
                return "NO";
            }else{
                return "YES";
            }
        }else{
            return "NO" ;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
