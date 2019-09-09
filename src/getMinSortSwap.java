import java.util.ArrayList;
public class getMinSortSwap {



    public int getMin(ArrayList list, int arg1, int arg2){

        int number1 = (int)list.get(arg1);
        int number2 = (int)list.get(arg2);

        if(Math.abs(arg1-arg2) <= 1){
            return Math.min(number1,number2);
        }else{
            int mid=(arg1+arg2)/2;
            int midnumber = (int)list.get(mid);
            if(number1 > number2){
                if(midnumber < number1 && midnumber < number2){
                   return getMin(list,arg1,mid);
                }else{
                   return getMin(list,mid,arg2);
                }
            }else{
               return number1;
            }
        }
    }

    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<Integer>();

        //Sorted array partitioned once and then stacked in any order
        list.add(18);
        list.add(28);
        list.add(84);
        list.add(96);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);


        getMinSortSwap sample = new getMinSortSwap();

        System.out.println(sample.getMin(list, 0, list.size()-1));

    }

}
