import java.util.*;

class LinkedListSample
{
    static class Node{
        private Node next;
        private String value;

        Node(String value){
            this.value = value;
            //next = null;
        }
    }

    public static void main(String args[]){

        Node head = new Node("1");
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
        System.out.println("Length of list :- " + listLength(head));
        System.out.println("Print the List :- ");
        printList(head);
        System.out.println(" ");
        System.out.println("Swap concurrent list :- ");
        printList(swap(head));
        System.out.println(" ");
        System.out.println("Reversed Linked List :- ");
        printList(reverse(head));

        Node list1 = new Node("1");
        Node list12 = new Node("2");
        Node list13 = new Node("4");
        list1.next = list12;
        list12.next = list13;

        Node list2 = new Node("1");
        Node list21 = new Node("3");
        Node list22 = new Node("4");
        list2.next = list21;
        list21.next = list22;

        System.out.println(" ");
        System.out.println("Merged List");
        printList(mergeList(list1,list2));

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

    public static void printList(Node head){
        System.out.print(head.value + " => ");
        if(head.next != null){
            printList(head.next);
        }

    }
    public static Node swap(Node head){

          String temp = "";
          if(head != null && head.next!= null){
                temp = head.value;
                head.value = head.next.value;
                head.next.value = temp;
              if(head.next.next != null){
                  swap(head.next.next);
              }
          }
          return head;

    }

    public static int listLength(Node head){
        int length = 0 ;
        while(head!=null){
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * Reverse a Linked List
     * @param head
     * @return
     */
    public static Node reverse(Node head){
            if(head == null){
                return null;
            }else{
                if(head.next != null){
                    Node rest = reverse(head.next);
                    head.next.next = head;
                    head.next = null;
                    head = rest;
                }
                return head;
            }
    }

    public static Node mergeList(Node l1, Node l2){
       if(l1 == null){
           return l2;
       }
       if(l2 == null){
           return l1;
       }
       if(Integer.parseInt(l1.value) < Integer.parseInt(l2.value)){
           l1.next = mergeList(l1.next,l2);
           return l1;
       }else{
           l2.next = mergeList(l1, l2.next);
           return l2;
       }
    }
}