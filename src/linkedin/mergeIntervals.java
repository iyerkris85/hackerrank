package linkedin;
import java.util.*;


public class mergeIntervals {

    class Sortmerge implements Comparator<ArrayList<Integer>>
    {
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
            return a.get(1) - b.get(1);
        }
    }

    class SortTwoDimensionalArray implements Comparator<int[]>
    {
        public int compare(int[]a, int[]b)
        {
            return a[1]-b[1];
        }
    }

    public ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> intervals) {

        Collections.sort(intervals, new Sortmerge());
        //Collections.sort(intervals, new SortTwoDimensionalArray());
        ArrayList<ArrayList<Integer>> mergedList = new ArrayList<>();

        //for each
        for(ArrayList<Integer> inte : intervals){

            if(mergedList.isEmpty()){
                mergedList.add(inte);
            }else{
                ArrayList<Integer> lastItem = mergedList.get(mergedList.size()-1);
                if(lastItem.get(1) < inte.get(0)){
                    mergedList.add(inte);
                }else{
                    //merge
                    int end = Math.max(lastItem.get(1), inte.get(1));
                    int start = Math.min(lastItem.get(0), inte.get(0));
                    lastItem.set(1, end);
                    lastItem.set(0, start);
                }
            }

        }

        return mergedList;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();

        ArrayList<Integer> interval1 = new ArrayList<>();
        ArrayList<Integer> interval2 = new ArrayList<>();
        ArrayList<Integer> interval3 = new ArrayList<>();
        ArrayList<Integer> interval4 = new ArrayList<>();
        ArrayList<Integer> interval5 = new ArrayList<>();
        ArrayList<Integer> interval6 = new ArrayList<>();

        interval1.add(9);
        interval1.add(10);

        interval2.add(10);
        interval2.add(11);

        interval3.add(13);
        interval3.add(14);

        interval4.add(12);
        interval4.add(16);

        interval5.add(18);
        interval5.add(19);

        interval6.add(20);
        interval6.add(22);

        intervals.add(interval5);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval1);
        intervals.add(interval6);

        mergeIntervals randomObject = new mergeIntervals();
        System.out.println(randomObject.merge(intervals));

    }
}
