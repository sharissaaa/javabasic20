import java.io.*;

public class MatrixMultiplication {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the number of rows for the first matrix:");
            int m1 = Integer.parseInt(br.readLine());
            System.out.println("Enter the number of columns for the first matrix / rows for the second matrix:");
            int n1 = Integer.parseInt(br.readLine());
            System.out.println("Enter the number of columns for the second matrix:");
            int m2 = Integer.parseInt(br.readLine());

            int[][] firstMatrix = new int[m1][n1];
            int[][] secondMatrix = new int[n1][m2];
            int[][] resultMatrix = new int[m1][m2];

            System.out.println("Enter the elements of the first matrix:");
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    firstMatrix[i][j] = Integer.parseInt(br.readLine());
                }
            }

            System.out.println("Enter the elements of the second matrix:");
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    secondMatrix[i][j] = Integer.parseInt(br.readLine());
                }
            }

            // Multiplying matrices
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < m2; j++) {
                    for (int k = 0; k < n1; k++) {
                        resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }

            // Displaying the result
            System.out.println("The result of matrix multiplication is:");
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < m2; j++) {
                    System.out.print(resultMatrix[i][j] + " ");
                }
                System.out.println();
            }

            br.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
