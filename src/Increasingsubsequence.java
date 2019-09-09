import java.util.List;
import java.util.ArrayList;

public class Increasingsubsequence {

    public int lis(final List<Integer> A){

        int n = A.size();
        return getLIS(A,n);
    }

    public int getLIS(List<Integer> arr, int n){

        if(n == 1){
            return 1;
        }else{
            int temp_max = 1;
            int res;
            for(int i=1;i<n; i++){
                res = getLIS(arr,i);
                if(arr.get(i-1) < arr.get(n-1) && res+1 > temp_max){
                    temp_max = res+1;
                }
            }

            return temp_max;
        }
    }

    public static void main(String args[]){

        Increasingsubsequence obj = new Increasingsubsequence();

        List<Integer> A = new ArrayList<Integer>();
        // [50, 3, 10, 7, 80]
        A.add(50);
        A.add(3);
        A.add(10);
        A.add(7);
        A.add(70);
        A.add(80);

        List<Integer> B = new ArrayList<Integer>();
        // [50, 3]
        B.add(50);
        B.add(3);

        List<Integer> C = new ArrayList<Integer>();
        // [3, 50]
        C.add(3);
        C.add(50);

        List<Integer> D = new ArrayList<Integer>();
        // [10, 22, 33, 50, 60, 80]
        D.add(10);
        D.add(22);
        D.add(33);
        D.add(50);
        D.add(60);
        D.add(80);

        System.out.println(obj.lis(A));
        System.out.println(obj.lis(B));
        System.out.println(obj.lis(C));
        System.out.println(obj.lis(D));
    }
}
