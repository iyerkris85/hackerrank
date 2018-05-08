import java.io.FileInputStream;

/**
 * Created by krishnandevarajan on 3/5/18.
 */
import java.io.*;
public class SerialEmployee implements Serializable{

    private String name;
    private int age;

    SerialEmployee(String name, int age){
        this.name = name;
        this.age = age;
    }

    void display(){
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
    }

    public static void main(String args[]){

        SerialEmployee emp = new SerialEmployee("Krishnan", 33);
        SerialEmployee reademp;

        try{
            FileOutputStream file = new FileOutputStream("a.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(file);
            objOut.writeObject(emp);
            objOut.close();
            file.close();

            FileInputStream fileIn = new FileInputStream("a.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            reademp = (SerialEmployee) in.readObject();
            reademp.display();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            System.out.println("Employee class not found");
            e.printStackTrace();
        }

    }
}
