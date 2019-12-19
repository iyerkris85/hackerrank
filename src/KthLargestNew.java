public class KthLargestNew {

    public int findKthLargest(int[] nums, int k) {
        KthLargest(nums, 0, nums.length-1, k-1);
        return nums[k-1];
    }

    public void KthLargest(int[] num, int low, int high, int k){

        if(low < high){
            int pivot = num[high];
            int i =low;
            for(int j=low; j<=high; j++){
                if(num[j] > pivot){

                    int temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                    i++;
                }
            }

            int temp = num[i];
            num[i] = num[high];
            num[high] = temp;

            if(i-low == k){
                return;
            }
            // Recursively sort elements before
            // partition and after partition
            if(i-low > k){
                KthLargest(num, low, i-1,k);
            }else{
                KthLargest(num, i+1, high,k-i-low-1);
            }


        }


    }



    public static void main(String args[]){
        KthLargestNew sample = new KthLargestNew();
        int[] A={3,2,3,1,2,4,5,5,6 };
        System.out.println(sample.findKthLargest(A,9));
    }
}
