package BasicClass.AliCarCar.AliCarCar2;

import java.util.Scanner;

class Car {
    int id;
    String name;
    int price;
    int labor;

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

class Factory {
    int N;
    boolean[] produces;
    int cap;

    Factory(int N, boolean[] produces, int cap) {
        this.N = N;
        this.produces = new boolean[produces.length];
        for (int i = 0; i < produces.length; ++i) {
            this.produces[i] = produces[i];
        }
        this.cap = cap;
    }
}

public class AliCarCar2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Car[] cars = new Car[N + 1];

        int id = 0;
        for (int i = 0; i < N; ++i) {
            String name = sc.next();
            int price = sc.nextInt();
            int labor = sc.nextInt();
            if (Car.check(name, price, labor)) {
                id++;
                cars[id] = new Car(id, name, price, labor);
            }
        }
        int numFac = 5;
        Factory[] factories = new Factory[numFac + 1];
        for (int i = 1; i <= numFac; ++i) {
            int cap = sc.nextInt();
            boolean[] produces = new boolean[N + 1];
            for (int j = 1; j <= N; ++j) {
                produces[j] = sc.nextInt() == 1;
            }
            factories[i] = new Factory(id, produces, cap);
        }
        int K = sc.nextInt();
        for (int k = 0; k < K; ++k) {
            int x = sc.nextInt();
            if (id < x) {
                System.out.println("invalid model");
                continue;
            }

            boolean found = false;
            for (int i = 1; i <= numFac; ++i) {
                Factory factory = factories[i];
                Car car = cars[x];
                if (factory.produces[x]
                        && car.labor <= factory.cap) {
                    System.out.println("okay " + i);
                    found = true;
                    factory.cap -= car.labor;
                    break;
                }
            }

            if (!found) {
                System.out.println("unable to build");
            }
        }
        sc.close();
    }
}
