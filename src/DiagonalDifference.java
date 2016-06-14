/**
 * Created by krishnandevarajan on 6/13/16.
 */

import java.io.*;
import java.util.*;

public class DiagonalDifference {

        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner in = new Scanner(System.in);
            int _a_size = Integer.parseInt(in.nextLine());


            String next;
            int sum = 0;
            int sum2 = 0;
            for(int i=0,j=_a_size-1;i<_a_size;i++,j--){
                next = in.nextLine();
                String[] next_split = next.split(" ");
                sum += Integer.parseInt(next_split[i]);
                sum2 += Integer.parseInt(next_split[j]);
            }
            System.out.println(Math.abs(sum-sum2));
        }
}

