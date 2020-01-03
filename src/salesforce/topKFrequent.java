package salesforce;
import java.util.*;
import java.util.Map.Entry;

public class topKFrequent {

    public List<String> getTopKFrequent(String[] words, int k) {
        HashMap<String,Integer> wordsCount = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(
                (w1,w2) -> wordsCount.get(w1) == wordsCount.get(w2)?w1.compareTo(w2):wordsCount.get(w2)-wordsCount.get(w1)
        );

        //O(n)
        for(String w:words){
            int count = wordsCount.getOrDefault(w,0) + 1;
            wordsCount.put(w, count);
        }

        //O(n log k)
        for (String word: wordsCount.keySet()) {
            queue.add(word);
            if (queue.size() > k){
                queue.poll();
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        //O(k)
        while(!queue.isEmpty()){
            answer.add(queue.poll());
        }

        Collections.reverse(answer); // O(k)

        return answer;
        //Collections.sort(answer, (w1,w2) -> wordsCount.get(w1).equals( wordsCount.get(w2))? w1.compareTo(w2):  wordsCount.get(w2)- wordsCount.get(w1)  );


    }



    public static void main(String args[]){

        topKFrequent frequent = new topKFrequent();
        String[] s= {"lovs", "love", "leetcode", "lovs", "love", "coding"};
        System.out.println(frequent.getTopKFrequent(s,2));
    }
}
