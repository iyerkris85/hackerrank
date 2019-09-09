import java.util.ArrayList;
public class amazonstack {

    public ArrayList<Integer> stack;
    public int min;

    amazonstack(){
        stack = new ArrayList<Integer>();
        min = -1;
    }

    public void push(int x) {
        if(stack.isEmpty()){
            min = x;
            stack.add(x);
        }else if(x > min){
            stack.add(x);
        }else{
            stack.add(2*x - min);
            min = x;
        }

    }

    public void pop() {
        if(!stack.isEmpty()){
           if(stack.get(stack.size()-1) < min){
               min = 2*min - stack.get(stack.size()-1);
           }
           stack.remove(stack.size()-1);
        }else{
            min = -1;
        }

        if(stack.isEmpty()){
            min = -1;
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            int t = stack.get(stack.size()-1);
            if(t < min){
                return min;
            }else{
                return t;
            }
        }else{
            return -1;
        }

    }

    public int getMin() {
        return min;
    }

    public static void main(String args[]){

        amazonstack obj = new amazonstack();
        obj.push(10);
        obj.push(9);
        System.out.println(obj.getMin());
        obj.push(8);
        System.out.println(obj.getMin());
        obj.push(7);
        System.out.println(obj.getMin());
        obj.push(6);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());

    }
}
