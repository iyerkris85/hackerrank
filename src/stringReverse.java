public class stringReverse {

    public static void main(String args[]){
        String input = "Hello How are you doing.";
        System.out.println(input + " : " + reverseString(input));
        StringBuffer sample = new StringBuffer(input);
        System.out.println(sample.reverse());
    }

    public static String reverseString(String input){

        /*
        char inp[] = input.toCharArray();
        int pointer = inp.length-1;
        StringBuilder reversedString = new StringBuilder();
        for(int i=inp.length-1; i > 0;){
            while(inp[i] != ' ' && i > 0){
                 i--;
            }
            if(i==0){
                reversedString.append(' ');
            }
            for(int j=i; j<=pointer; j++){
                 reversedString.append(inp[j]);
            }
            pointer = --i;
        }

        return reversedString.toString();*/

        String[] arrays = input.split("\\s");
        String result = "";
        for (int x=arrays.length-1; x>=0; x--) {
            result += arrays[x];
            if (x != 0) {
                result += " ";
            }
        }
        return result;
    }
}
