/**
 * Kth Largest implementation using Heap
 */
public class kthLargestHeap {

    /**
     * Returns the Kth Largest Number
     * @param number
     * @param k
     * @return
     */
    public int kthLargest(int[] number, int k){

        int[] heapArray = new int[k];
        //copy first k numbers to a heap array
        for(int i=0; i< k; i++){
            heapArray[i] = number[i];
        }

        //build a min heap on the heapArray
        buildMinHeap(heapArray);

        for(int i=k; i< number.length; i++){
            if(number[i] > heapArray[0]){
                heapArray[0] = number[i];
                //heapify
                heapify(heapArray, heapArray.length, 0);
            }
        }

        return heapArray[0];
    }

    /**
     * Build a Min HeapArray
     * @param heapArray
     */
    public void buildMinHeap(int[] heapArray){
        for(int i=heapArray.length/2; i>=0 ; i--){
            heapify(heapArray, heapArray.length, i);
        }
    }

    /**
     * Heapify the given index
     * @param heapArray
     * @param size
     * @param i
     */
    public void heapify(int[] heapArray, int size, int i){

        int l = 2*i +  1;
        int r = 2*i + 2;
        int minimum = i;
        if(l < size && heapArray[l] < heapArray[minimum]){
            minimum = l;
        }
        if(r < size && heapArray[r] < heapArray[minimum]){
            minimum = r;
        }

        if(minimum != i){
            int temp = heapArray[minimum];
            heapArray[minimum] = heapArray[i];
            heapArray[i] = temp;
            heapify(heapArray,size,minimum);
        }
    }

    public static void main(String args[]){

        int numbers[] = {3,2,3,1,2,4,5,5,6};
        kthLargestHeap largestElement = new kthLargestHeap();
        System.out.println(largestElement.kthLargest(numbers, 4));
    }
}
