import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;

public class MissingPositive {

    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<Integer>();



        list.add(1967513926);
        list.add(1540383426);
        list.add(-130345573);
        list.add(-521595368);


/*
        //list.add(-6);
        list.add(2);
        list.add(12);
        list.add(-5);
        //list.add(9);
        list.add(-6);
        //list.add(99);*/

        //System.out.println(firstMissingPositive(list));
        System.out.println(maxset(list));
    }

    public static int firstMissingPositive(ArrayList<Integer> A) {

        int max = 0;
        int n = A.size();
        for(int i=0;i<n;i++){
            if(A.get(i) > 0 && A.get(i) > max){
                max = A.get(i);
            }
        }
        //If all numbers are negative or 0 return 1
        if(max < 1){
            return 1;
        }

        //Fill with 0
        for(int i=n;i<max+n;i++){
            A.add(i,0);
        }

        for(int i=0;i<n;i++){
            if(A.get(i) > 0){
                A.set(A.get(i)+n-1, A.get(i));
            }
        }

        for(int i=n;i<A.size();i++){
            if(A.get(i) == 0){
                return i-n+1;
            }
        }

        return max+1;

    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long currentSum = 0;
        int reset = 1;
        long maxSum = -1;
        int maxStartIndex = 0;
        int currentStartIndex = 0;
        int maxEndIndex = 0;

        for(int i=0; i<A.size();i++){
            if(A.get(i) > -1){
                if(reset == 1){
                    currentStartIndex = i;
                    reset = 0;
                }
                currentSum+= A.get(i);
            }else{
                if(currentSum > maxSum){
                    maxStartIndex = currentStartIndex;
                    maxEndIndex = i;
                    maxSum = currentSum;
                }
                //reset
                currentSum = 0;
                reset = 1;
            }
        }
        if(currentSum > maxSum){
            maxStartIndex = currentStartIndex;
            maxEndIndex = A.size();
        }

        System.out.println(maxEndIndex);
        return new ArrayList(A.subList(maxStartIndex, maxEndIndex));
    }

    //Rotate Matrix
    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int N=a.size();
        for (int x = 0; x < N/2; x++) {
            for (int y = x; y < N-x-1; y++) {
                // store current cell in temp variable
                int temp = a.get(x).get(y);

                // move values from right to top
                a.get(x).set(y, a.get(N-1-y).get(x));
                //mat[x][y] = mat[y][N-1-x];

                // move values from bottom to right
                a.get(N-1-y).set(x, a.get(N-1-x).get(N-1-y));
                //mat[y][N-1-x] = mat[N-1-x][N-1-y];

                // move values from left to bottom
                a.get(N-1-x).set(N-1-y, a.get(y).get(N-1-x));
                //mat[N-1-x][N-1-y] = mat[N-1-y][x];

                // assign temp to left
                a.get(y).set(N-1-x,temp);
                //mat[N-1-y][x] = temp;


            }
        }

    }

    //------------------------------------------------------------------

    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(a.size() < b.size()){
            return getMedian(a,b);
        }else{
            return getMedian(b,a);
        }
    }

    public double getMedian(final List<Integer> a,final List<Integer> b){
        int min_index = 0;
        int max_index = a.size();
        int i = 0;
        int j = 0;
        double median = 0.0;

        while(min_index <= max_index){

            i = (min_index + max_index) / 2;
            j = ((a.size() + b.size() + 1) / 2) - i;

            if (i < a.size() && j > 0 && b.get(j - 1) > a.get(i)) {
                min_index = i + 1;
            }else if(i > 0 && j < b.size() && b.get(j) < a.get(i - 1)) {
                max_index = i - 1;
            }else{
                if (i == 0){
                    median = (double)b.get(j - 1);
                }else if (j == 0){
                    median = (double)a.get(i - 1);
                }else{
                    median = (double)maximum(a.get(i - 1),b.get(j - 1));
                }
                break;
            }
        }

        if ((a.size() + b.size()) % 2 == 1){
            return (double)median;
        }
        if (i == a.size()){
            return (median + b.get(j)) / 2.0;
        }
        if (j == b.size()){
            return (median + a.get(i)) / 2.0;
        }
        return (median + minimum(a.get(i),b.get(j))) / 2.0;
    }

    static int maximum(int a, int b)
    {
        return a > b ? a : b;
    }

    // Function to find minimum
    static int minimum(int a, int b)
    {
        return a < b ? a : b;
    }

    public String intToRoman(int A) {
        String unit[] = {"","I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String hundreds[] = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String thousands[] = {"", "M", "MM", "MMM"};

        // Converting to roman
        String th = thousands[A/1000];
        String hh = hundreds[(A%1000)/100];
        String te = tens[(A%100)/10];
        String on = unit[A%10];

        return (th+hh+te+on);

    }

}

