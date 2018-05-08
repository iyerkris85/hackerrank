/**
 * Created by krishnandevarajan on 3/6/18.
 */
class FinalizeExample {
    public void finalize() {
        System.out.println("Finalize is called");
    }
    public static void main(String args[])
    {
        FinalizeExample f1=new FinalizeExample();
        FinalizeExample f2=new FinalizeExample();
        f1 = null;
        f2 = null;
        System.gc();
    }
}
