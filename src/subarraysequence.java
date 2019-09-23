import java.util.HashMap;

/**
 * Examples:
 *
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: Sum found between indexes 2 and 4
 *
 * Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
 * Ouptut: Sum found between indexes 0 to 3
 *
 * Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
 * Ouptut: No subarray with given sum exists
 */

public class subarraysequence {

    static boolean containsSequence(int[] array, int target){

        HashMap<Integer, Integer> sumIndex = new HashMap<Integer, Integer>();

        int currSum = 0;

        for(int i=0; i<array.length; i++){
            currSum+=array[i];
            if(currSum - target == 0 ){
                return true;
            }
            if(sumIndex.containsKey(currSum-target)){
                return true;
            }
            sumIndex.put(currSum, i);
        }
        return false;
    }

    public static void main(String args[]){
        int[] array = {3, 1, 4, 2, 9, 30, 7};
        System.out.println("Sequence " + (containsSequence(array, 11)?"exists":"not exists"));
    }
}
