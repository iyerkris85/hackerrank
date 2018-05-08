import java.io.*;
import java.util.*;

public class LargestPalindrome {


    /*
     * Complete the highestValuePalindrome function below.
     */
    static String highestValuePalindrome(String s, int n, int k) {
        /*
         * Write your code here.
         */
        return "-1";

    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        String[] nk = scan.nextLine().split(" ");
        int n = Integer.parseInt(nk[0].trim());
        int k = Integer.parseInt(nk[1].trim());
        String s = scan.nextLine();
        String result = highestValuePalindrome(s, n, k);
        bw.write(result);
        bw.newLine();
        bw.close();
    }
}
