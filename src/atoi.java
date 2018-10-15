public class atoi {

    public static void main(String args[]){

        String input = args[0];
        System.out.println(input.charAt(0));
        System.out.println(atoi(input));
    }

    public static int atoi(String input){
         int output = 0;
         int multiple = 1;
         if(input.length() > 0){
             for(int i=input.length()-1; i>=0; i--){
                 //If is a Number
                 if(isNumber(input.charAt(i))){
                     output += Character.getNumericValue(input.charAt(i)) * multiple;
                     multiple = multiple * 10;
                 }else{
                     //Corner Cases
                     if(i==0){
                         if(input.charAt(i) == '-'){
                            output = output * -1;
                         }else if(input.charAt(i) == '+'){
                             output = output * 1;
                         }
                     }else{
                         //If a whitespace or any other garbage then reset the output and multiple
                         output = 0;
                         multiple = 1;
                     }
                 }
             }
             return output;
         }else{
             return 0;
         }
    }

    public static boolean isNumber(char c){
        if((int)c >=48 && (int)c <=57){
            return true;
        }else{
            return false;
        }
    }
}
