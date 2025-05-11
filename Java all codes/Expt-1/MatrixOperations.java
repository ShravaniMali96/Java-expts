import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = new int[2][2];
        System.out.println("Enter elements for first matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter elements for second matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter choice (1: Multiplication, 2: Addition, 3: Transpose):");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                int[][] product = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        product[i][j] = 0;
                        for (int k = 0; k < 2; k++) {
                            product[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                    }
                }
                System.out.println("Matrix Product:");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(product[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                int[][] sum = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        sum[i][j] = matrix1[i][j] + matrix2[i][j];
                    }
                }
                System.out.println("Matrix Sum:");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(sum[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 3:
                int[][] transpose = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        transpose[i][j] = matrix1[j][i];
                    }
                }
                System.out.println("Transpose of First Matrix:");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(transpose[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
        }
        sc.close();
    }
}
