package BasicClass.ZooTicket.ZooTicket2;

import java.util.Scanner;

class ZooTicket {
    private final String name;
    private boolean ride, seal, tiger;

    ZooTicket(String name) {
        this.name = name;
    }

    void bookRide() {
        this.ride = true;
    }

    void bookSealShow() {
        this.seal = true;
    }

    void bookTigerShow() {
        this.tiger = true;
    }

    void summarize() {
        System.out.println(this.name);
        int cost = 100;
        if (this.ride) {
            System.out.println("Ride");
            cost += 40;
        }
        if (this.seal) {
            System.out.println("Seal");
            cost += 50;
        }
        if (this.tiger) {
            System.out.println("Tiger");
            cost += 65;
        }
        System.out.println(cost);
    }

    boolean useRide() {
        if (this.ride) {
            this.ride = false;
            System.out.println("okay");
            return true;
        }
        System.out.println("no");
        return false;
    }
    boolean enterSealShow() {
        if (this.seal) {
            this.seal = false;
            System.out.println("okay");
            return true;
        }
        System.out.println("no");
        return false;
    }
    boolean enterTigerShow() {
        if (this.tiger) {
            this.tiger = false;
            System.out.println("okay");
            return true;
        }
        System.out.println("no");
        return false;
    }
}

public class ZooTicket2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        ZooTicket zt = new ZooTicket(name);
        int x = sc.nextInt();
        while (x != 0) {
            if (x == 1) {
                zt.bookRide();
            } else if (x == 2) {
                zt.bookSealShow();
            } else if (x == 3) {
                zt.bookTigerShow();
            }
            x = sc.nextInt();
        }
        zt.summarize();
        int Q = sc.nextInt();
        for (int q = 0; q < Q; ++q) {
            int action = sc.nextInt();
            if (action == 1) {
                System.out.println(zt.useRide());
            } else if (action == 2) {
                System.out.println(zt.enterSealShow());
            } else if (action == 3) {
                System.out.println(zt.enterTigerShow());
            }
        }
        sc.close();
    }
}
