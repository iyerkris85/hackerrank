/**
 * Created by krishnandevarajan on 3/3/18.
 */
public class ByteShift {

    public static void main(String args[]){
        int a = 50;
        int b = 100;
        System.out.println(a);
        System.out.println(a>>>1);
        System.out.println(a>>>2);
        System.out.println(a<<1);
        System.out.println(a^b);

        System.out.println(countBits(7));
    }

    public static int countBits(int number){
        int noofBits = 0;

        while(number!=0){
            if((number & 1) == 1 ){
                noofBits++;
            }
            number = number>>>1;
        }
        return noofBits;
    }
}
