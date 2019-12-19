/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class mergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeSort(lists, 0, lists.length-1);
    }

    public static ListNode mergeSort(ListNode[] lists, int left, int right){
        if(left == right) {
            return lists[left];
        }else{
            int mid = left + (left+right) / 2;
            return mergeTwoLists(mergeSort(lists, left, mid),mergeSort(lists, mid+1, right));
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){

        ListNode head = new ListNode(-1);
        ListNode prehead = head;

        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                prehead.next = l1;
                l1 = l1.next;
            }else{
                prehead.next = l2;
                l2 = l2.next;
            }
            prehead = prehead.next;
        }

        prehead.next = l1==null?l2:l1;

        return head.next;
//        if(l1 == null && l2 == null){
//            return null;
//        }else if(l1 == null && l2 != null){
//            return l2;
//        }else if(l2 == null && l1 != null){
//            return l1;
//        }else{
//            if(l1.val < l2.val){
//                l1.next = mergeTwoLists(l1.next,l2);
//                return l1;
//            }else{
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
//        }

    }

    public static void main(String args[]){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] array = {node1, node4, node7};

        ListNode merged = mergeKLists(array);

        System.out.println(merged);
    }
}
