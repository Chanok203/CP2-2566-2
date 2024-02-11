package BasicClass.Department.Department2;

import java.util.Scanner;

class Dept {
    private int ministryBudget, eduFee, serviceFee, donation; // Incomes
    private int salary, elect, eduCost; // Expense

    Dept(int numEmployees, int numStudents) {
        int income = this.computeIncome(numEmployees, numStudents);
        int expense = this.computeExpense(numEmployees, numStudents);
        System.out.println("total income = " + income);
        System.out.println("total expense = " + expense);
        System.out.println("income - expense = " + (income - expense));
    }

    int computeIncome(int numEmployees, int numStudents) {
        this.ministryBudget = (numEmployees * 500_000) + (numStudents * 3_000);
        this.eduFee = numStudents * 5_000;
        this.serviceFee = 300_000;
        this.donation = 100_000;
        return this.ministryBudget + this.eduFee + this.serviceFee + this.donation;
    }

    int computeExpense(int numEmployees, int numStudents) {
        this.salary = numEmployees * 600_000;
        this.elect = (numEmployees + numStudents) * 2_000;
        this.eduCost = numStudents * 4_000;
        return this.salary + this.elect + this.eduCost;
    }

    void printReport() {
        System.out.println("ministry budget = " + this.ministryBudget);
        System.out.println("education fee = " + this.eduFee);
        System.out.println("service fee = " + this.serviceFee);
        System.out.println("donation = " + this.donation);
        System.out.println("salary = " + this.salary);
        System.out.println("electricity = " + this.elect);
        System.out.println("educational cost = " + this.eduCost);
    }
}

public class Department2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int K = sc.nextInt();
        (new Dept(N, K)).printReport();
        sc.close();
    }
}
