package Method;

import java.util.Scanner;

public class CovidScreening {
    static void screenCovid(boolean insurance, int severity, int age, int vaccines) {
        if (insurance) {
            System.out.println("RT-PCR recommended");
        }

        boolean admit = (age >= 70) || (severity == 3);
        if (admit) {
            System.out.println("Hospital admission");
        } else {
            System.out.println("Home isolation");
        }

        boolean standard = (vaccines >= 2) && (severity == 1);
        if (standard) {
            System.out.println("Standard medicine package");
        } else {
            System.out.println("Favipiravia included");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean insurance = scan.nextInt() == 1;
        int severity = scan.nextInt();
        int age = scan.nextInt();
        int vaccines = scan.nextInt();
        scan.close();
        screenCovid(insurance, severity, age, vaccines);
    }
}
