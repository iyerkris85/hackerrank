/**
 * Created by krishnandevarajan on 2/28/17.
 * Detect a Palindrome
 */
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(isPalindrome(input));
    }

    /**
     * Check if the input is a Palindrome
     * @param input
     * @return boolean
     */
    public static boolean isPalindrome(String input){

        boolean answer = true;

        //Length of the Sting
        int length = input.length();

        for(int i = 0; i<length/2; i++){

            if(input.charAt(i) == input.charAt(length-1-i)){
                answer = true;
            }else{
                answer = false;
                break;
            }
        }

        return answer;
    }
}
