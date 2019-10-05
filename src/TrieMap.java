import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
class TrieNodeMap{
    Map<Character, TrieNodeMap> level = new HashMap<>();
    int score;
    String rootWord;

    public boolean find(String word){
        TrieNodeMap curr = this;
        for(int i = 0 ; i < word.length();i++){
            if(word.charAt(i) == '.'){
                boolean ans = false;
                for(Map.Entry<Character, TrieNodeMap> level : curr.level.entrySet()){
                    ans = ans | level.getValue().find(word.substring(i+1));
                }
                return ans;

            }else{
                if(curr.level.containsKey(word.charAt(i))){
                    curr = curr.level.get(word.charAt(i));
                }else{
                    return false;
                }
            }
        }
        return curr.rootWord != null;
    }
}

public class TrieMap {
    private TrieNodeMap root;
    HashMap<String, Integer> map;

    public TrieMap(){
        root = new TrieNodeMap();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNodeMap cur = root;
        cur.score += delta;
        for (char c: key.toCharArray()) {
            cur.level.putIfAbsent(c, new TrieNodeMap());
            cur = cur.level.get(c);
            cur.score += delta;
        }
    }

    /**
     * Insert Words to Replace Word
     * @param key
     */
    public void insertWords(String key){
        TrieNodeMap cur = root;
        for (char c: key.toCharArray()) {
            cur.level.putIfAbsent(c, new TrieNodeMap());
            cur = cur.level.get(c);
        }
        cur.rootWord = key;
    }

    /**
     * Replace Word
     * @param key
     * @return
     */
    public String rootWord(String key){
        TrieNodeMap cur = root;
        for(char c: key.toCharArray()){
            if(!cur.level.containsKey(c) || cur.rootWord !=null){
                break;
            }
            cur = cur.level.get(c);
        }
        return cur.rootWord != null? cur.rootWord: key;
    }

    public int sum(String prefix) {
        TrieNodeMap cur = root;
        for (char c: prefix.toCharArray()) {
            cur = cur.level.get(c);
            if (cur == null) return 0;
        }
        return cur.score;
    }
    public static void main(String args[]){
        TrieMap Trie = new TrieMap();

        Trie.insert("apple",3);
        System.out.println(Trie.sum("ap"));
        Trie.insert("app",3);
        Trie.insert("appop",3);
        Trie.insert("aplop",3);
        Trie.insert("app",3);
        System.out.println(Trie.sum("ap"));

        List<String> roots = new ArrayList<>();
        roots.add("cat");
        roots.add("cate");
        roots.add("bat");
        roots.add("rat");
        System.out.println(replaceWords(roots,"the cattle was rattled by the battery and cater nelson bato"));
    }

    public static String replaceWords(List<String> dict, String sentence) {

        TrieMap replaceTrie = new TrieMap();
        //Insert all roots
        for(String root : dict){
            replaceTrie.insertWords(root);
        }

        String[] sentenceArray = sentence.split("\\s+");
        StringBuilder answer = new StringBuilder();
        for(String sent: sentenceArray){
            if(answer.length() > 0){
                answer.append(" ");
            }
            answer.append(replaceTrie.rootWord(sent));
        }
        return answer.toString();
    }
}
