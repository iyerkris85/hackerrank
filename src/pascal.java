import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class pascal {

    public static Map<String, Integer> cache = new HashMap<>();

    public static void main(String args[]){
        System.out.println(generate(6));
        System.out.println(getRow(1));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTriangle  = new ArrayList<List<Integer>>();

        //For each Row
        for(int i=0; i< numRows; i++){
            List<Integer> row = new ArrayList<Integer>();
            for(int j=0; j<= i ; j++){
                //Calculate pascal and add to row
                if(j<=i/2){
                    //Add column to Row
                    row.add(pascal(i,j));
                }else{
                    row.add(row.get((i-j)));
                }

            }
            //Add Row to PascalTriangle
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        if(rowIndex == 0 ){
            return row;
        }else if(rowIndex == 1){
            row.add(1);
            return row;
        }else {
            for (int j = 1; j <= rowIndex; j++) {
                //Calculate pascal and add to row
                if (j <= rowIndex / 2) {
                    //Add column to Row
                    row.add(pascal(rowIndex, j));
                } else {
                    row.add(row.get((rowIndex - j)));
                }
            }
        }
        return row;
    }

    public static int pascal(int i, int j){
        String key = i+","+j;
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int result;
        if(j == 0){
            result = 1;
        }else if (j == i){
            result = 1;
        }else{
            result = pascal(i-1, j-1) + pascal(i-1, j);
        }
        cache.put(key,result);
        return result;
    }
}
