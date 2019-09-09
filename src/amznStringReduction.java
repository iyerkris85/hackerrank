import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class amznStringReduction {

    static List<String> stringList = new ArrayList<String>();
    static StringBuilder combination = new StringBuilder();
    static ArrayList<Character> reducedString = new ArrayList<Character>();
    public static void main(String args[]){

        System.out.println(getCombinations("bccvfghyttrf",5));
    }

    public static List<String> getCombinations(final String givenString, final int num){


        boolean[] flags = new boolean[123];

        //If the String has lower length
        if(givenString.length() < num){
            return stringList;
        }

        //If num is less than length
        if(num < 1){
            return stringList;
        }

        // Reduce the String with non duplicates
        //1. Flag all characters
        for(int i=0;i<givenString.length();i++){
            int index = (int)givenString.charAt(i);
            flags[index] = true;
        }

        //collect all flagged smallcase characters
        for(int i=97;i<123;i++){
            if(flags[i]){
                reducedString.add((char)i);
            }
        }

        //2. Build unique combination of length num
        if(reducedString.size() < num){
            return stringList;
        }else if(reducedString.size() == num) {
            for(Character ch: reducedString) {
                combination.append(ch);
            }
            stringList.add(combination.toString());
            return stringList;
        }else{
            combine(0,num);
            return stringList;
        }

    }

    static void combine(int start, int num){
        for( int i = start; i < reducedString.size(); ++i ){
            combination.append( reducedString.get(i));
            if(combination.length() == num){
                stringList.add(combination.toString());
            }
            if(i < reducedString.size()){
                combine( i + 1,num);
            }
            combination.setLength( combination.length() - 1 );
        }
    }

}
