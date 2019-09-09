import java.util.Arrays;
public class reversekpermute {

    public static void main(String args[]){

        System.out.println(findRank("DTNGJPURFHYEW"));
    }

    public static int findRank(String A) {


         if(A.length() == 1){
             return 1;
         }else{
             String sortedString = sortString(A);
             int pos = sortedString.indexOf(A.charAt(0));

             if((factorial((A.length()-1))*pos) + findRank(A.substring(1)) > Integer.MAX_VALUE){
                 return ((factorial((A.length()-1))*pos) + findRank(A.substring(1))) % 1000003;
             }else{
                 return (factorial((A.length()-1))*pos) + findRank(A.substring(1)) % 1000003;
             }
         }

    }

    public static String sortString(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    static int factorial(int n) {

        if ((n == 0) || (n == 1))
        {

            return (1);

        }
        if (n < 0)
        {

            n = -n;

        }
        int f = 1;
        while (n > 0)
        {

            f = (f * n) % 1000003;
            n -= 1;

        }
        return (f);
    }

}
