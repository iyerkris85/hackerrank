package salesforce;
import java.util.Stack;

public class waterTrap {
    public int trap(int[] height) {
        int answer = 0;
        if(height == null){
            return answer;
        }

        Stack<Integer> st = new Stack<Integer>();

        int current = 0;
        while(current < height.length){
            while(!st.empty() && height[current] > height[st.peek()]){
                int top = st.peek();
                st.pop();
                if(st.empty()){
                    break;
                }
                int distance = current -st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                answer += distance * bounded_height;
            }
            st.push(current);
            current++;
        }
        return answer;
    }

    public static void main(String args[]){
        waterTrap obj = new waterTrap();
        int[] graph = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(graph));
    }
}
