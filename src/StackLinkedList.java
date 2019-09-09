public class StackLinkedList {
    static class Elem{
        private Elem next;
        private Elem prev;
        private Elem child;
        private String value;

        Elem(String value){
            this.value = value;
        }
    }

    public static Elem head;
    public static void main(String args[]){

        push("1");
        push("2");
        push("3");
        push("4");
        push("5");
        push("6");
        push("7");
        printStack(head);
        System.out.println(mthNode(3).value);
//        printStack(reverseList(head));
//        printStack(head);
    }

    /**
     * Push Data
     * @param data
     * @return
     */
    public static void push(String data){

        Elem node = new Elem(data);
        node.next = head;
        head = node;
    }

    public static void pop(){
        head = head.next;
    }

    public static void printStack(Elem stack){
        while(stack != null) {
            System.out.println(stack.value);
            stack = stack.next;
        }
    }

    public static Elem reverseList(Elem list){
       if(list == null){
           return list;
       }else{
           if(list.next != null){
               Elem node = reverseList(list.next);
               list.next.next = list;
               list.next = null;
               list = node;
           }
       }
       return list;
    }

    public static Elem mthNode(int m){
        Elem temp = head;
        Elem mthnode = head;
        if(m > 0){
            int i = 0;
            while( i < m){
                temp = temp.next;
                i++;
            }
        }

        while(temp != null){
            temp = temp.next;
            mthnode = mthnode.next;
        }

        return mthnode;
    }
}


