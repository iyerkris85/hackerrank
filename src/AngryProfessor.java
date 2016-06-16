import java.util.Scanner;

/**
 * Created by krishnandevarajan on 6/14/16.
 */
public class AngryProfessor {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int no_test = in.nextInt();

        int K;
        int N;
        //For Each test case
        for(int i=0;i<no_test;i++){
            // Get students and Treshold
            N = in.nextInt();
            K= in.nextInt();

            //In Time Count
            int count = 0;
            //Get arrival times of students
            for(int j=0;j<N;j++){
                int temp = in.nextInt();
                if(temp <= 0){
                    count ++;
                }
            }
            // if count is less than threshold then cancelled
            if(count >= K){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }

        }

    }
}
