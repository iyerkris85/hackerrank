import java.util.Stack;

public class decodeString {

    public String decodeStringAnswer(String s) {
        Stack<String> text = new Stack();
        Stack<Integer> multiplier = new Stack();

        int multiplierno = 0;
        String answer = "";

        for(char c : s.toCharArray()){
            switch (c){
                case '0' :
                case '1' :
                case '2' :
                case '3' :
                case '4' :
                case '5' :
                case '6' :
                case '7' :
                case '8' :
                case '9' :
                    multiplierno = multiplierno * 10 + Character.getNumericValue(c);
                    break;
                case '[':
                    multiplier.push(multiplierno);
                    multiplierno = 0;
                    text.push(answer);
                    answer="";
                    break;
                case ']':
                    int no = multiplier.pop();
                    String poppedsolution = text.pop();
                    answer = poppedsolution + repeat(answer,no);
                    break;
                default:
                    answer += c;
                    break;
            }
        }
        return answer;
    }

    //Repeat the String
    public String repeat(String toRepeat, int count){
        StringBuilder result = new StringBuilder();
        for(int i=0; i< count; i++){
            result.append(toRepeat);
        }
        return result.toString();
    }

    public static void main(String args[]){
        decodeString sample = new decodeString();
        System.out.println(sample.decodeStringAnswer("3[aa6[hb]]"));
    }
}
