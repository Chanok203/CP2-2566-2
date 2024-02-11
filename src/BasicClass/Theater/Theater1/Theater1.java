package BasicClass.Theater.Theater1;

import java.util.Scanner;

class Theater {
    String title;
    int basePrice = -1;
    boolean threeD;
    boolean luxury;
    int numSeats;
    boolean[] seats;

    Theater(boolean threeD, boolean luxury, int numSeats) {
        this.threeD = threeD;
        this.luxury = luxury;
        this.numSeats = numSeats;
        this.seats = new boolean[numSeats + 1];
    }

    void setTitle(String title) {
        if (title == null) {
            System.out.println("invalid title");
            return;
        }

        if (title.length() == 0) {
            System.out.println("invalid title");
            return;
        }

        this.title = title;
    }

    void setBasePrice(int basePrice) {
        if (basePrice <= 0) {
            System.out.println("invalid price");
            return;
        }

        this.basePrice = basePrice;
    }

    void printInfo() {
        // line 1
        if (this.threeD) {
            System.out.println("3D");
        } else {
            System.out.println("No 3D");
        }

        // line 2
        if (this.luxury) {
            System.out.println("Luxury");
        } else {
            System.out.println("Standard");
        }

        // line 3
        System.out.println(seats.length - 1);

        // line 4
        if (this.title == null) {
            System.out.println("title is not set");
        } else {
            System.out.println(this.title);
        }

        // line 5
        if (this.basePrice <= 0) {
            System.out.println("price is not set");
        } else {
            System.out.println(this.basePrice);
        }
    }
}

public class Theater1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int threeD1 = scan.nextInt();
        int luxury1 = scan.nextInt();
        int numSeats = scan.nextInt();
        boolean threeD = false;
        boolean luxury = false;
        if (threeD1 == 1)
            threeD = true;
        if (luxury1 == 1)
            luxury = true;
        Theater t = new Theater(threeD, luxury, numSeats);
        scan.nextLine();// throw away a new line character
        String title = scan.nextLine();
        if (title.compareTo("-1") == 0)
            t.setTitle(null);
        else
            t.setTitle(title);
        int basePrice = scan.nextInt();
        t.setBasePrice(basePrice);
        t.printInfo();
        scan.close();
    }
}
