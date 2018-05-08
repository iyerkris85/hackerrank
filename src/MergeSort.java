import java.util.*;
public class MergeSort {

    private static int length;
    private static int[] input;

    static void printSortedArray(){


    }



    public static void main(String args){

        Scanner in = new Scanner(System.in);
        length = in.nextInt();
        input = new int[length];
        for(int i=0; i<length; i++){
             input[i] = in.nextInt();
        }
        printSortedArray();
    }


}
