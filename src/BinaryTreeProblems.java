
import java.util.*;

class Node
{
    Node left,right;
    int value;
    public Node(int item)
    {
        this.value = item;
        this.left=this.right=null;
    }
}
class BinaryTreeProblems
{
    public static ArrayList<Integer> values = new ArrayList<Integer>();
    public static void main(String args[]){

//        Node head = null;
//        int numbers[] = {50,56,33,45,23,67,17,34,89,74,64,12,94};
//        for(int i=0;i<numbers.length;i++){
//            head = buildBinaryTree(numbers[i],head);
//        }
//        inOrderTraversal(head);
//        head = rotateRight(head);
//        System.out.println("After Rotation: ");
//        inOrderTraversal(head);
//        System.out.println("Height of Tree: "+heightofTree(head));
//        System.out.println("Lowest Ancestor : "+lowestAncestor(head,17,94));

        Node sampleTree = new Node(0);
        sampleTree.left = new Node(-1);
        sampleTree.right = new Node(15);
        Node right = sampleTree.right;
        right.left = new Node(6);
        right.right = new Node(20);

        System.out.println("The given tree "+ (isValidBST(sampleTree)?"is":"is not") +" binary");
    }

    /**
     * Check Valid BST
     * @param root
     * @return
     */
    public static boolean isValidBST(Node root){
        if(isValid(root, null, null)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isValid(Node root, Node l, Node r){
        if(root == null){
            return true;
        }

        if(l!=null && (root.value <= l.value)){
            return false;
        }

        if(r!=null && (root.value >= r.value)){
            return false;
        }

        return isValid(root.left, l, root) && isValid(root.right, root, r);
    }

    //Build a sample binary tree
    public static Node buildBinaryTree(int number,Node head){
         if( head == null){
             return new Node(number);
         }else{
             if(number <= head.value){
                 head.left = buildBinaryTree(number,head.left);
             }else{
                 head.right = buildBinaryTree(number,head.right);
             }
         }
         return head;
    }

    //Inorder Traversal
    public static void inOrderTraversal(Node tree){
        if(tree !=null){
            inOrderTraversal(tree.left);
            System.out.println(tree.value);
            values.add(tree.value);
            inOrderTraversal(tree.right);
        }
    }

    //Height of a tree
    public static int heightofTree(Node tree){
        if(tree == null){
            return 0;
        }else{
            return 1 + Math.max(heightofTree(tree.left),heightofTree(tree.right));
        }
    }

    public static int lowestAncestor(Node tree, int num1, int num2){

        while(tree.value != num1 && tree.value != num2)
            if(tree.value < num1 && tree.value < num2){
                tree = tree.left;
            }else if(tree.value > num1 && tree.value > num2){
                tree = tree.right;
            }else{
                return tree.value;
            }

        return tree.value;
    }

    public static Node rotateRight(Node head){

        Node newNode = head.left;
        head.left = newNode.right;
        newNode.right = head;
        return newNode;
    }

    public static Node rotateLeft(Node head){

        Node newNode = head.right;
        newNode.left = head;
        head.right = newNode.left;

        return newNode;
    }
}