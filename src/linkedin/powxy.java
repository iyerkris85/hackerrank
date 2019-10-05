package linkedin;

public class powxy {

    public static double myPow(double x, int n) {
        double temp;
        if(n == 0){
            return 1.0;
        }
        temp = myPow(x, n/2);

        if(n%2 == 0){
            return temp* temp;
        }else{
            if(n > 0){
                return x * temp * temp;
            }else{
                return (temp* temp)/x;
            }
        }

    }

    public static void main(String args[]){
        System.out.println(myPow(-2.0,1));
    }
}
