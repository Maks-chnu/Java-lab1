package Java_lab1;

import java.util.Scanner;

public class JavaTask1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double result = ((2 * Math.pow(x, 2) + x * y) / Math.pow((x * y), 2)) + ((3 * x * y - Math.pow(y, 3)) / (Math.pow(x, 2) + 2 * Math.pow(y, 2)));

        System.out.print("result = " + result);
    }
}
