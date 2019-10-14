import java.util.Arrays;

public class waveSort {

    public void wiggleSortEquals(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    public void wiggleSort(int[] nums){

        Arrays.sort(nums);
        int len = nums.length;

        int[] res = new int[len];
        res = nums.clone();

        int m = (len-1)/2;
        for (int i = 0, j= len-1; i < len; i++) {
            nums[i] = (i % 2 == 0) ? res[m--] : res[j--];
        }
    }

    public void swap(int[] nums, int original, int next){
        int temp = nums[original];
        nums[original] = nums[next];
        nums[next] = temp;
    }

    public static void main(String args[]){

        int[] nums = {1, 5, 1, 1,1, 6, 4,7};

        waveSort sample = new waveSort();
        sample.wiggleSort(nums);

        System.out.println(Arrays.toString(nums));
    }

}
