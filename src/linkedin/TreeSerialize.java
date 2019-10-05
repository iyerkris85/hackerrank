package linkedin;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class TreeSerialize {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root, String result) {

       if(root == null){
           result += "null,";
       }else{
           result+= root.value+",";
           result = serialize(root.left, result);
           result = serialize(root.right, result);
       }
       return result;
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] values_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(values_array));
        return rdeserialize(data_list);
    }

    public static TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public static void main(String args[]){
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;
        System.out.println(serialize(one,""));

    }
}
