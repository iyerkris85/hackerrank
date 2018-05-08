/**
 * Created by krishnandevarajan on 3/6/18.
 */
public class CheckAnagram {

    public static boolean isAnagram(String first, String second){

        if(first.length() != second.length()){
            return false;
        }

        first = first.toLowerCase();
        second = second.toLowerCase();

        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);

        for(char ch : characters){
            int index = sbSecond.indexOf("" + ch);
            if(index != -1){
                sbSecond.deleteCharAt(index);
            }else{
                return false;
            }
        }

        return sbSecond.length()==0 ? true : false;

    }

    public static void main(String args[]){

        System.out.println("Mary and Army are anagrams : " + isAnagram("Mary","Army"));
        System.out.println("Maryp and Armyg are anagrams : " + isAnagram("Maryp","Armyg"));
        System.out.println("Marp and Armyg are anagrams : " + isAnagram("Marp","Armyg"));
    }
}
