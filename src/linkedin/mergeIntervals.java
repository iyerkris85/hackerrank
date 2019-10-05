package linkedin;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

class Sortbyindex implements Comparator<int[]>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(int[] a, int[] b)
    {
        return Integer.compare(a[0],b[0]);
    }
}

public class mergeIntervals {

    public static int[][] merge(int[][] intervals) {
        //Sort Array
        Arrays.sort(intervals, new Sortbyindex());
        List<int[]> merged = new ArrayList();
        for(int i=0; i<intervals.length; i++){
            if (merged.isEmpty()) {
                merged.add(intervals[i]);
            }else{
                int[] last = merged.get(merged.size() - 1);
                if(last[1] < intervals[i][0]){
                    merged.add(intervals[i]);
                }else{
                    last[1] = Math.max(last[1],intervals[i][1]);
                    merged.remove(merged.size() - 1);
                    merged.add(last);
                }
            }
        }
        int[][] arr = new int[merged.size()][];

        for(int i = 0; i < merged.size(); i++) {
            if (merged.get(i) != null) {
                arr[i] = merged.get(i);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] intervals={{1,3},{15,18},{8,10},{2,6}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
