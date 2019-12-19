package linkedin;
import java.util.*;


public class mergeIntervals {

    class Sortmerge implements Comparator<ArrayList<Integer>>
    {
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
            return a.get(1) - b.get(1);
        }
    }

    public ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> intervals) {

        Collections.sort(intervals, new Sortmerge());
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
                    lastItem.set(1, end);
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

        interval1.add(9);
        interval1.add(10);

        interval2.add(10);
        interval2.add(11);

        interval3.add(13);
        interval3.add(14);

        interval4.add(14);
        interval4.add(15);

        interval5.add(14);
        interval5.add(16);

        intervals.add(interval5);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval1);

        mergeIntervals randomObject = new mergeIntervals();
        System.out.println(randomObject.merge(intervals));

    }
}
