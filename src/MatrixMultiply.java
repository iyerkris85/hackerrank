/**
 * Created by krishnandevarajan on 2/28/17.
 * Detect a Palindrome
 */


public class MatrixMultiply {

    int matixA[][] = {{ 2, 3, 4, 9, 5},{ 5, 6, 7, 6, 7}, {6, 5, 4, 5, 3}};
    int matixB[][] = {{ 5, 6, 7},{ 4, 5, 6}, {3, 4, 7}, { 4, 5, 6}, {5, 6, 7}};

    public static void main(String[] args){

        MatrixMultiply matrix = new MatrixMultiply();
        matrix.multiply();
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
