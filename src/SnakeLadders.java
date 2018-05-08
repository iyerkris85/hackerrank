import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by krishnandevarajan on 6/20/16.
 */
public class SnakeLadders {

    static HashMap<Integer,Integer> ladders = new HashMap<Integer, Integer>();
    static HashMap<Integer,Integer> snakes = new HashMap<Integer, Integer>();

    //Start Node and End Node will always be 1 and 100
    final int start_node = 1;
    final int end_node = 100;

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        //Get number of test cases
        int no_test = in.nextInt();

        int no_ladders;
        int no_snakes;

        //Scan and process all test cases
        for(int i=0; i<no_test;i++){
            //No of ladders
            no_ladders = in.nextInt();
            for(int j=0; j<no_ladders; j++){
                ladders.put(in.nextInt(), in.nextInt());
            }
            //No of Snakes
            no_snakes = in.nextInt();
            for(int k=0; k<no_snakes;k++){
                snakes.put(in.nextInt(), in.nextInt());
            }
            //Find out easiest way to get to 100
            snakesladders();
        }

    }

    //Process the ladders and snakes
    public static void snakesladders(){

        int solution = 0;

        System.out.println(solution);

        //Clearing out the Static HashMap
        ladders.clear();
        snakes.clear();
    }
}
