package ru.spbstu.telematics.java;
import java.util.*;

public class App {
    public static int[][] snake(int[][] arr, int n){
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(matrix[i], Integer.MAX_VALUE);
        int[] numbers = new int[n];
        int k = n/2 + 1;
        numbers[0] = 0;
        int c = 1;
        for(int i = 1; i < k; i++){
            numbers[c++] = n-i;
            if(i < k-1)
                numbers[c++] = i;
        }
        int arr_i = 0;
        int arr_j = 0;
        for(int i = 0; i < ((n%2 == 0) ? n : n-1); i += 2) {
            int j = i + 1;
            for(int p = 0; p < n; p++) {
                if(matrix[numbers[i]][p] == Integer.MAX_VALUE) {
                    matrix[numbers[i]][p] = arr[arr_i%n][arr_j%n];
                    if(++arr_j%n == 0) arr_i++;
                }
            }
            for(int p = 0; p < n; p++) {
                if(matrix[p][numbers[j]] == Integer.MAX_VALUE) {
                    matrix[p][numbers[j]] = arr[arr_i%n][arr_j%n];
                    if(++arr_j%n == 0) arr_i++;
                }
            }
            for(int p = n - 1; p > -1; p--) {
                if(matrix[numbers[j]][p] == Integer.MAX_VALUE) {
                    matrix[numbers[j]][p] = arr[arr_i%n][arr_j%n];
                    if(++arr_j%n == 0) arr_i++;
                }
            }
            for(int p = n - 1; p > -1; p--) {
                if(matrix[p][numbers[i]] == Integer.MAX_VALUE) {
                    matrix[p][numbers[i]] = arr[arr_i%n][arr_j%n];
                    if(++arr_j%n == 0) arr_i++;
                }
            }
        }
        if(n%2 != 0) matrix[k - 1][k - 1] = arr[arr_i%n][arr_j%n];
        return matrix;
    }

    public static void print(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println("\n");
        }
    }

    public static void main( String[] args ) {
        System.out.println( "Enter array size: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n <= 0) {
            System.out.println("It must be positive!");
            n = in.nextInt();
        }
        System.out.println("Choose a way to fill the matrix\n1) manually\n2) automatically");
        int ans = in.nextInt();
        while(ans != 1 && ans != 2) {
            System.out.println("Wrong input!");
            ans = in.nextInt();
        }
        int[][] array = new int[n][n];

        if(ans == 1) {
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++) {
                    System.out.println("Enter number");
                    int elem = in.nextInt();
                    array[i][j] = elem;
                }
        }
        else {
            int number = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) array[i][j] = number++;
        }

        App.print(array, n);
        App.print(App.snake(array, n), n);
    }
}
