package from_c_to_java;
import java.util.Scanner;

public class NoDivideByZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();

        if (z == 0) {
            System.out.println("cannot divide by zero");
        } else {
            double ans = (x + y) / z;
            System.out.printf("%.6f", ans);
            System.out.println(); // new line
        }
    }
}
