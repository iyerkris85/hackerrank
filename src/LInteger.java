import java.util.*;

public class LInteger {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /* Class will be named solution in pasted answer*/

        Scanner in = new Scanner(System.in);
        int _a_size = Integer.parseInt(in.nextLine());

        int _a_item;
        Integer getValue;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
                _a_item = Integer.parseInt(next_split[_a_i]);
                getValue = hm.get(_a_item);
                if(getValue != null){
                    hm.put(_a_item,getValue+1);
                }else{
                    hm.put(_a_item,1);
                }
        }

        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if( (int)(pair.getValue()) % 2 != 0){
                System.out.println(pair.getKey());
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
    }



}