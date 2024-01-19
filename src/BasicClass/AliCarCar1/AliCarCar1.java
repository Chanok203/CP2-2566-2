package BasicClass.AliCarCar1;

import java.util.Scanner;

class Car {
    final int id;
    final String name;
    final int price;
    final int labor;

    Car(int id, String name, int price, int labor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.labor = labor;
    }

    static boolean check(String name, int price, int labor) {
        if (name == null || name.length() == 0) {
            return false;
        }
        if (price <= 0 || labor <= 0) {
            return false;
        }
        return true;
    }
}

public class AliCarCar1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Car[] cars = new Car[N+1];

        int id = 0;
        for (int i = 0; i < N; ++i) {
            String name = sc.next();
            int price = sc.nextInt();
            int labor = sc.nextInt();
            if (Car.check(name, price, labor)) {
                id++;
                cars[id] = new Car(id, name, price, labor);
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
        for (int i = 1; i <= id; ++i) {
            System.out.println(i + " " + cars[i].name);
        }
        sc.close();
    }
}