
public class stringRemove {

    public static void main(String args[]){
        System.out.println(removeCharacters("Hello how are you doing?","aeiou"));
    }

    public static String removeCharacters(String sentence, String remove){

        char[] s = sentence.toCharArray();
        char[] r = remove.toCharArray();

        int dest=0;

        boolean flags[] = new boolean[128];

        //Change the remove characters to i O(m)
        for(int i=0; i<r.length;i++){
            flags[r[i]] = true;
        }

        for(int i=0; i<s.length;i++ ){
            if(!flags[s[i]]){
                //Copy
                s[dest] = s[i];
                dest++;
            }
        }

        return new String(s,0,dest);
    }
}
