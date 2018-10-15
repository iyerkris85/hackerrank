import java.lang.Object;
public class googleInterview {

    static String pat = "bxyzca";
    static String str = "abcabcabc";
    static String output = "bbbcccaaa";
    static String generateoutput = "";
    static int[] apperances = new int[123];

    public static void main(String args[]){

        createApperanceCount();
        sortString();
        System.out.println(generateoutput);
    }

    /**
     * Create apperances index count
     */
    public static void createApperanceCount(){

        for(int i=0;i<str.length();i++){
            int index = (int) str.charAt(i);
            apperances[index]++;
        }
    }

    /**
     * Generate ordered output
     */
    public static void sortString(){
        for(int i=0;i<pat.length();i++){
            int index = (int) pat.charAt(i);
            //If the character exists
            if(apperances[index] !=0){
                for(int j=0;j<apperances[index];j++){
                    generateoutput += Character.toString(pat.charAt(i));
                }
            }
        }
    }

}
