package Method;

import java.util.Scanner;

public class AQIMeaning {
    static void aqimeaning(int air) {
        if (air <= 50) {
            System.out.println("Good");
            return;
        }

        if (air <= 100) {
            System.out.println("Moderate");
            return;
        }

        if (air <= 150) {
            System.out.println("Unhealthy for Sensitive Groups");
            return;
        }

        if (air <= 200) {
            System.out.println("Unhealthy");
            return;
        }

        if (air <= 300) {
            System.out.println("Very Unhealthy");
            return;
        }

        System.out.println("Hazardous");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int air = sc.nextInt();
        aqimeaning(air);
        sc.close();
    }
}
