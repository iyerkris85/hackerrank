import java.util.*;

class LinkedListSample
{
    static class Node{
        private Node next;
        private String value;

        Node(String value){
            this.value = value;
            next = null;
        }
    }

    public static void main(String args[]){

        Node head = new Node("Sample");
        Node two = new Node("2");
        Node three = new Node("3");
        Node four = new Node("4");
        Node five = new Node("5");
        Node six = new Node("6");
        Node seven = new Node("7");

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        //seven.next = four;

        System.out.println("Is the LinkedList Circular :- " + isCircular(head));
        System.out.println("Node value from m'th :- " + frommth(head,5));
    }

    /**
     * Determine if the list is circular
     * @param head
     * @return
     */
    public static boolean isCircular(Node head){

        Node slow = head;
        Node fast = head.next;

        while(true){
            if(fast==null || fast.next==null){
                return false;
            }else if(fast.next == slow){
                System.out.println("The list caught up at  :- " + slow.value);
                return true;
            }else{
                slow = slow.next;
                fast = fast.next.next;
            }
        }
    }

    /**
     * Determine of the node from the mth from the last node
     * @param head
     * @param m
     * @return
     */
    public static String frommth(Node head, int m){

        Node mnode = head;
        //Traverse till mth node
        for(int i=1;i<=m; i++){
            if(head.next != null){
                head = head.next;
            }else{
                return null;
            }
        }

        while(head.next != null){
            head = head.next;
            mnode = mnode.next;
        }

        return mnode.value;
    }
}