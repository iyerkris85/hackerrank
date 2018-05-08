import java.util.*;

public class HangMan {

    public static int maxAttempt = 5;
    public static String[] words = {"canada","australia","ireland","india","china","france","germany"};
    public static TreeMap<Character,List<Integer>> secretWordMap = new TreeMap<Character,List<Integer>>();
    public static StringBuffer wrong = new StringBuffer();
    public static StringBuffer correct = new StringBuffer();

    public static void main(String args[]){

        Random r = new Random();
        int index = r.nextInt()%(words.length-1);

        for(int i = 0 ; i<words[index].length(); i++){
            List<Integer> position = new ArrayList<Integer>();
            if(secretWordMap.containsKey(words[index].charAt(i))){
               position = secretWordMap.get(words[index].charAt(i));
               position.add(i);
               secretWordMap.put(words[index].charAt(i),position);
            }else{
                position.add(i);
                secretWordMap.put(words[index].charAt(i),position);
            }
            correct.append('_');
        }

        System.out.println("Guess the name of the country. You have 5 attempts");
        Scanner in = new Scanner(System.in);

        while(maxAttempt > 0){
            char c = in.next().charAt(0);
            if(secretWordMap.size() > 1){
                if(secretWordMap.containsKey(c)){
                    List<Integer> getpositions;
                    getpositions = secretWordMap.get(c);
                    for(Integer i : getpositions){
                        correct.setCharAt(i,c);
                    }
                    secretWordMap.remove(c);
                    System.out.println("Correct :)");
                    System.out.println("Correct Char List :- " + correct + " Attempts Remain:- " + maxAttempt);
                    System.out.println("Wrong Char List:- " + wrong + " Attempts Remain:- " + maxAttempt);
                }else{
                    maxAttempt--;
                    wrong.append(c);
                    System.out.println("Wong :(");
                    System.out.println("Correct Char List :- " + correct + " Attempts Remain:- " + maxAttempt);
                    System.out.println("Wrong Char List:- " + wrong + " Attempts Remain:- " + maxAttempt);
                }
            }else{
                break;
            }
        }

        if(maxAttempt < 1){
            System.out.println("You loose!! " + words[index]);
        }else{
            System.out.println("You win!! " + words[index]);
        }
    }
}