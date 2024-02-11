package BasicClass.Department.Department1;

import java.util.Scanner;

class Dept {
    private int ministryBudget;
    private int eduFee;
    private int serviceFee;
    private int donation;

    Dept(int numEmployees, int numStudents) {
        this.computeIncome(numEmployees, numStudents);
    }

    void computeIncome(int numEmployees, int numStudents) {
        this.ministryBudget = (numEmployees * 500_000) + (numStudents * 3_000);
        this.eduFee = numStudents * 5_000;
        this.serviceFee = 300_000;
        this.donation = 100_000;
    }

    void printReport() {
        System.out.println("ministry budget = " + this.ministryBudget);
        System.out.println("education fee = " + this.eduFee);
        System.out.println("service fee = " + this.serviceFee);
        System.out.println("donation = " + this.donation);
    }
}

public class Department1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int K = sc.nextInt();
        (new Dept(N, K)).printReport();
        sc.close();
    }
}
