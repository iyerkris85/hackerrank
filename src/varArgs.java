/**
 * Created by krishnandevarajan on 3/4/18.
 */

// Demonstrate variable-length arguments.
class varArgs implements Runnable{

    public Thread newThread;
    // vaTest() now uses a vararg.
    synchronized static void vaTest(int ... v) {
        System.out.println("-----------------------");
        try{
            System.out.println("Entering Wait Now");
            Thread.currentThread().wait();
        }catch(Exception e){

        }
        try{
            System.out.println("Entering Notify Now");
            if(Thread.currentThread().getState() == Thread.State.WAITING){
                Thread.currentThread().notify();
            }
        }catch(Exception e){

        }

        System.out.println("Enter sync: " + Thread.currentThread().getName());
        System.out.print("Number of args: " + v.length +
                " Contents: ");
        for(int x : v)
            System.out.print(x + " ");
        System.out.println("");

        System.out.println("Exit Sync: "+Thread.currentThread().getName());
    }

    varArgs(String threadName){
        this.newThread = new Thread(this, threadName);
        this.newThread.start();
    }
    public static void main(String args[])
    {
        Thread t = Thread.currentThread();
        varArgs oneObj = new varArgs("SecondThread");
        t.setName("varArgs");
        t.setPriority(1);
        vaTest(10); // 1 arg
        varArgs twoObj = new varArgs("ThirdThread");
        vaTest(); // no args
        try {
            System.out.println("Waiting for threads to finish.");
            oneObj.newThread.join();
            twoObj.newThread.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
    }

    public void run(){
        try{
            vaTest(1, 2, 3);
        }catch(Exception e){
            System.out.println("Exception Occured");
        }

    }
}
