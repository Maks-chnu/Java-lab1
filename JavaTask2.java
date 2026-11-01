package Java_lab1;

import java.util.Arrays;
import java.util.Scanner;

public class JavaTask2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть n (від 1 до 200): ");
        int n = in.nextInt();
        while (n < 1 || n > 200) {
            System.out.print("Помилка: n має бути від 1 до 200. Введіть ще раз: ");
            n = in.nextInt();
        }

        int[] A = new int[n];
        System.out.println("Введіть " + n + " елементів масиву:");
        for (int i = 0; i < A.length; i++) {
            System.out.print("A[" + i + "] = ");
            A[i] = in.nextInt();
        }

        System.out.print("Введіть k: ");
        int k = in.nextInt();
        int shift = ((k % n) + n) % n;

        int[] lastA = new int[n];
        for (int i = 0; i < A.length; i++) {
            if (i + shift < A.length) {
                lastA[i + shift] = A[i];
            } else {
                lastA[i + shift - A.length] = A[i];
            }
        }

        System.out.println("Масив A до зсуву:              " + Arrays.toString(A));
        System.out.println("Масив A після зсуву на k = " + k + ": " + Arrays.toString(lastA));

        in.close();
    }
}