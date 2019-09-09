import java.util.Arrays;

/**
 * Created by krishnandevarajan on 2/28/17.
 * Detect a Palindrome
 */


public class MatrixMultiply {

    int matixA[][] = {{ 2, 3, 4, 9, 5},{ 5, 6, 7, 6, 7}, {6, 5, 4, 5, 3}};
    int matixB[][] = {{ 5, 6, 7},{ 4, 5, 6}, {3, 4, 7}, { 4, 5, 6}, {5, 6, 7}};
    static int matrixGiven[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

    public static void main(String[] args){

//        MatrixMultiply matrix = new MatrixMultiply();
//        matrix.multiply();
        int sample1[][] = new int[0][0];
        int sample2[][] = {{1, 3, 5}};
        int sample3[][] = {{1},{3},{5}};
        System.out.println(searchMatrix( sample3,2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        //If Matrix is empty return false
        if(matrix.length < 1 || (matrix.length == 1 && matrix[0].length == 0)){
            return false;
        }

        //If matrix has exactly one element
        if(matrix.length == 1 && matrix[0].length == 1) {
            if(matrix[0][0] == target){
                return true;
            }else{
                return false;
            }
        }

        //Check the corners of the matrix to get the range of number and check if the target exists in that range
        if(matrix[0][0] > target){
            return false;
        }

        if(matrix[matrix.length-1][matrix[0].length-1] < target){
            return false;
        }

        int midRow = 0;
        int midColumn = 0;
        if((matrix.length/2) == 0){
            midRow = 0;
        }else{
            midRow = (matrix.length/2)-1;
        }

        if( (matrix[0].length/2) == 0 ){
            midColumn = 0;
        }else{
            midColumn = (matrix[0].length/2) -1;
        }

        if(matrix[midRow][midColumn] >= target){
            return searchMatrix(partOfArray(matrix, 1 ), target);
        }else{
            return  (
                     searchMatrix(partOfArray(matrix, 2 ), target) ||
                     searchMatrix(partOfArray(matrix, 3 ), target) ||
                     searchMatrix(partOfArray(matrix, 4 ), target)
                    );
        }


    }


    public static int[][] partOfArray(int[][] matrix, int part){

        int [][] array;
        int midRow = 0;
        int midColumn = 0;
        if((matrix.length/2) == 0){
            midRow = 0;
        }else{
            midRow = (matrix.length/2)-1;
        }

        if( (matrix[0].length/2) == 0 ){
            midColumn = 0;
        }else{
            midColumn = (matrix[0].length/2) -1;
        }

        switch (part){
            case 1:
                array = new int[midRow][midColumn];
                for(int i=0; i<midRow; i++){
                    array[i] = Arrays.copyOfRange(matrix[i],0,midColumn);
                }
                return array;
            case 2:
                array = new int[midRow][ (matrix[0].length - midColumn)];
                for(int i=0; i<midRow; i++){
                    array[i] = Arrays.copyOfRange(matrix[i],midColumn,matrix[i].length);
                }
                return array;
            case 3:
                array = new int[matrix.length - midRow][midColumn];
                for(int i=0; i< (matrix.length - midRow); i++){
                    array[i] = Arrays.copyOfRange(matrix[midRow + i],0,midColumn);
                }
                return array;
            case 4:
                array = new int[matrix.length - midRow][(matrix[0].length - midColumn)];
                for(int i=0; i<(matrix.length - midRow); i++){
                    array[i] = Arrays.copyOfRange(matrix[midRow + i],midColumn,matrix[i].length);
                }
                return array;
            default:
                array = new int[0][0];
                return array;
        }
    }

    /**
     * Check if the input is a Palindrome

     */
     void multiply(){

        System.out.println(matixA.length + "  " + matixA[0].length);
        System.out.println(matixB.length + "  " + matixB[0].length);


        int matrixMultiply[][] = new int[matixA.length][matixB[0].length];

        if(matixA[0].length == matixB.length){

            for(int i=0; i< matixA.length ; i++){
                for(int j=0; j<matixB[0].length; j++){
                    for(int k=0 ; k< matixA[0].length ; k++){
                        matrixMultiply[i][j] += (matixA[i][k] * matixB[k][j]);
                    }
                }
            }

            for(int i=0; i<matrixMultiply.length; i++) {
                for(int j=0; j<matrixMultiply[i].length; j++)
                    System.out.print(matrixMultiply[i][j] + " ");
                System.out.println();
            }

            Runtime runtime = Runtime.getRuntime();
            System.out.println(runtime.availableProcessors());
            System.out.println(runtime.freeMemory());
            System.out.println(runtime.totalMemory());
            runtime.gc();
            System.out.println(runtime.freeMemory());
            System.out.println(runtime.freeMemory());
        }else{
            System.out.println("Multiplication is not possible");
        }

    }
}
