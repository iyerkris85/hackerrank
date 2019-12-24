package salesforce;
import java.util.HashMap;
import java.util.LinkedHashSet;
public class lfu {

    class Node{
        int value,frequency;
        Node(int value, int frequency){
            this.value = value;
            this.frequency = frequency;
        }
    }

    private int capacity;
    //Key Value Pair
    private HashMap<Integer, Node> cacheMap;
    //Order of elements in a given frequency
    private HashMap<Integer,LinkedHashSet<Integer>> frequencyMap;
    //Current minimum frequency
    int leastFrequency;


    //Initialize LFU
    lfu(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.leastFrequency = 1;
    }

    public int get(int key) {
       if(cacheMap.containsKey(key)){
           //Update
           update(key,cacheMap.get(key));
           return cacheMap.get(key).value;
       }else{
           return -1;
       }
    }

    public void update(int key, Node node){
        LinkedHashSet<Integer> map = frequencyMap.get(node.frequency);
        map.remove(key);
        if(leastFrequency == node.frequency && map.size() == 0){
            leastFrequency++;
        }
        //Update Frequency in Node
        node.frequency++;
        cacheMap.put(key, node);
        LinkedHashSet<Integer> newmap = frequencyMap.getOrDefault(node.frequency,new LinkedHashSet<>());
        newmap.add(key);
        frequencyMap.put(node.frequency, newmap);
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            node.value = value;
            //Update
            update(key, node);
        }else{
            cacheMap.put(key, new Node(value, 1));
            LinkedHashSet<Integer> newmap = frequencyMap.getOrDefault(1, new LinkedHashSet<>());
            newmap.add(key);
            frequencyMap.put(1,newmap);

            if(this.capacity == 0){
               //Get the keyMap
               LinkedHashSet<Integer> map = frequencyMap.get(leastFrequency);
               //Get Key
               int removeKey = map.iterator().next();
               //Remove Key from frequencyMap
               frequencyMap.get(leastFrequency).remove(removeKey);
               //Remove Key from cache
               cacheMap.remove(removeKey);
            }else{
                this.capacity--;
            }
        }

    }



    public static void main(String args[]){

        lfu cache = new lfu(2);
//        cache.put(3, 1);
//        cache.put(2, 1);
//        cache.put(2, 2);
//        cache.put(4, 3);
//        System.out.println(cache.get(2));
        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4); // evicts 3
        System.out.println(cache.get(2));       // returns 2
        cache.put(3, 3);    // evicts 4
        System.out.println(cache.get(2));       // returns 2 (not found)
        System.out.println(cache.get(3));       // returns 3
        cache.put(4, 4);    // evicts 3.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns -1
        System.out.println(cache.get(4));       // returns 4
    }


}
