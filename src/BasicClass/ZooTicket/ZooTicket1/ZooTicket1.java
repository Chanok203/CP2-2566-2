package BasicClass.ZooTicket.ZooTicket1;

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
}

public class ZooTicket1 {
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
        sc.close();
    }
}
