package linkedin;

import java.util.PriorityQueue;

public class kthunsorted {

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < 1) {
            return -1;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int no: nums){
            heap.add(no);
            if(heap.size() > k){
                heap.poll();
            }
        }

        return heap.poll();
    }
    public static void main(String args[]){
        kthunsorted sample = new kthunsorted();
        int[] nos = {2,6,3,88,23,45};
        System.out.println(sample.findKthLargest(nos,4));
    }
}
