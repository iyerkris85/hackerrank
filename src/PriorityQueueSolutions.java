import java.util.LinkedList;
import java.util.Queue;

public class PriorityQueueSolutions {

    public static void main(String[] args){

        Queue<String> commands = new LinkedList<>();

        commands.add("mkdir");
        commands.add("mkdir");
        commands.add("cd");
        commands.add("rmdir");
        commands.add("mkdir");

        while(!commands.isEmpty()){
            System.out.println(commands.remove());
        }
    }
}
