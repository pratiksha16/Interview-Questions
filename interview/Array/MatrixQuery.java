/*
Given a square matrix of integers a and  an array queries of q. Your task is to return
the given matrix after processing all the queries on it. There are three types of queries:
If q[i]=0, rotate 90 degrees clockwise.
If q[i]=1; reflect the matrix in its main diagonal.
If q[i]=2; reflect the matrix in its secondary diagonal;


For matrix a=[[1,2,3],[4,5,6],[7,8,9]];
q=[0,1,2]
Output= [[3,6,9],[2,5,8],[1,4,7]];


Three queries; three qns: 
*/

package interview.Array;

public class MatrixQuery {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotationClockWise(matrix);
        transposeMatrix(matrix);
        rotationClockWise(matrix);
        // reflectAlongSecDiag(matrix);
        printMatrix(matrix);

    }

    public static void rotationClockWise(int[][] matrix) {
        transposeMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            reverseMatrix(matrix[i]);
        }

    }

    public static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j && i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public static void reflectAlongSecDiag(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
                matrix[matrix.length - 1 - j][matrix.length - 1 - i] = temp;
            }
        }
    }

    public static void reverseMatrix(int[] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}