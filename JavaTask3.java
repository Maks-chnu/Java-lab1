package Java_lab1;

import java.util.Random;
import java.util.Scanner;

public class JavaTask3 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        final double MIN = -10.0;
        final double MAX = 10.0;

        System.out.print("Введіть n (від 1 до 15): ");
        int n = in.nextInt();
        while (n < 1 || n > 15) {
            System.out.print("Помилка: n має бути від 1 до 15. Введіть ще раз: ");
            n = in.nextInt();
        }

        //Заповнення матриці випадковими дійсними числами
        double[][] A = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double value = MIN + (MAX - MIN) * random.nextDouble();
                A[i][j] = Math.round(value * 10) / 10.0; 
            }
        }

        //Максимум серед елементів нижче головної діагоналі (i > j)
        double maxBelow = Double.NEGATIVE_INFINITY;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][j] > maxBelow) {
                    maxBelow = A[i][j];
                }
            }
        }

        //Сума елементів на діагоналі та вище (i <= j), більших за maxBelow
        double sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (A[i][j] > maxBelow) {
                    sum += A[i][j];
                    count++;
                }
            }
        }

        //Виведення матриці (* — елементи, що увійшли в суму)
        System.out.println("\nМатриця A(" + n + "x" + n + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean counted = (i <= j) && (A[i][j] > maxBelow);
                System.out.printf("%7.1f%s", A[i][j], counted ? "*" : " ");
            }
            System.out.println();
        }

        //Виведення результату
        System.out.println();
        if (n == 1) {
            System.out.println("Елементів нижче головної діагоналі немає.");
        } else {
            System.out.printf("Максимум нижче головної діагоналі: %.1f%n", maxBelow);
        }

        if (count == 0) {
            System.out.println("Елементів на головній діагоналі та вище неї, "
                    + "які перевищують усі елементи нижче діагоналі, немає.");
        } else {
            System.out.println("Кількість таких елементів: " + count);
            System.out.printf("Сума: %.1f%n", sum);
        }

        in.close();
    }
}

