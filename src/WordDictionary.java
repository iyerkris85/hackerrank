import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private TrieNodeMap root;
     public WordDictionary(){
         root = new TrieNodeMap();
     }

     public void addWord(String word){
         TrieNodeMap curr = root;
         for(char c: word.toCharArray()){
             curr.level.putIfAbsent(c, new TrieNodeMap());
             curr = curr.level.get(c);
         }
         curr.rootWord = word;
     }

     public boolean search(String word){
         TrieNodeMap curr = root;
         return curr.find(word);
     }

     public static void main(String args[]){
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        obj.addWord("bag");
        obj.addWord("lop");
        System.out.println(obj.search("bad"));
     }
}
