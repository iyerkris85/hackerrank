public class kthElement {

    public int findKthLargest(int[] nums, int k) {
//        return findKthSmallest(nums, nums.length-k+1);
        select(nums, 0, nums.length - 1, k -1);
        return nums[k-1];
    }

    public int findKthSmallest(int[] nums, int k) {
        //return smallestKNumber(nums, 0, nums.length-1,k );
        selectSmall(nums, 0, nums.length - 1, k -1);
        return nums[k-1];
    }

    public int smallestKNumber(int[] nums, int l, int r, int k ){

        if (k > 0 && k <= r - l + 1){

            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pivot = partition(nums, l, r);

            // If position is same as k
            if (pivot-l == k-1){
                return nums[pivot];
            }

            if(pivot-l > k-1){
                return smallestKNumber(nums, l, pivot -1 , k );
            }else{
                return smallestKNumber(nums, pivot+1, r, k-pivot+l-1 );
            }
        }

        return -1;
    }



    public static int partition(int [] arr, int l, int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                //Swapping arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        //Swapping arr[i] and arr[r]
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }

    public void select(int[] num, int start, int end, int k){
        if (start > end) {
            return;
        }
        int i= start;
        int j = end;
        int pivotNumber = num[(end-start)/2 + start];
        while(i < j){
            while(num[i] > pivotNumber){
                ++i;
            }
            while(num[j] < pivotNumber){
                --j;
            }
            if (i < j) {
                if (num[i] != num[j]) {
                    swap(num, i, j);
                }
                ++i;
                --j;
            }
        }
        if(i > k ){
            select(num, start, i-1,k);
        }else{
            select(num, i+1, end,k);
        }
    }

    public void selectSmall(int[] num, int start, int end, int k){
        if (start > end) {
            return;
        }
        int i= start;
        int j = end;
        int pivotNumber = num[(end-start)/2 + start];
        while(i < j){
            while(num[i] < pivotNumber){
                ++i;
            }
            while(num[j] > pivotNumber){
                --j;
            }
            if (i < j) {
                if (num[i] != num[j]) {
                    swap(num, i, j);
                }
                ++i;
                --j;
            }
        }
        if(i < k ){
            select(num, start, i-1,k);
        }else{
            select(num, i+1, end,k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        kthElement sample = new kthElement();
        int[] A={3,-7, 2,1,5,6,4, 7, 78, 22 };
        System.out.println(sample.findKthLargest(A,6));
        System.out.println(sample.findKthSmallest(A,5));
    }
}
