package BasicClass;

import java.util.Scanner;

class CookiePlanner {
    private final int F, B;
    private int flour, butter, bags;

    CookiePlanner(int F, int B) {
        this.F = F;
        this.B = B;
    }

    int calculate() {
        int f = this.flour / F;
        int b = this.butter / B;
        if (f < b) {
            return f;
        }
        return b;
    }

    boolean produce(int R) {
        int C = calculate();
        if (C < R) {
            System.out.printf("Max capacity = %d bags, but %d bags requested ", C, R);
            return false;
        }
        this.flour -= F * R;
        this.butter -= B * R;
        this.bags += R;
        System.out.print(this.bags + " ");
        return true;
    }

    boolean addFlour(int q) {
        if (q <= 0) {
            System.out.print("Invalid flour quantity ");
            return false;
        }
        this.flour += q;
        System.out.print(this.flour + " ");
        return true;
    }

    boolean addButter(int q) {
        if (q <= 0) {
            System.out.print("Invalid butter quantity ");
            return false;
        }
        this.butter += q;
        System.out.print(this.butter + " ");
        return true;
    }

    void reportProduction() {
        System.out.println("Cookie bags: " + this.bags);
        System.out.println("Flour left: " + this.flour);
        System.out.println("Butter left: " + this.butter);
    }
}

public class CookieFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int B = sc.nextInt();
        CookiePlanner cp = new CookiePlanner(F, B);
        int N = sc.nextInt();
        for (int i = 0; i < N; ++i) {
            int K = sc.nextInt();
            int A = sc.nextInt();
            boolean res;
            if (K == 1) {
                res = cp.addFlour(A);
            } else if (K == 2) {
                res = cp.addButter(A);
            } else {
                res = cp.produce(A);
            }
            System.out.println(res);
        }
        cp.reportProduction();
        sc.close();
    }
}
