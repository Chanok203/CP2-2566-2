package Inheritance.AnimalDomain.AnimalDomain1;

import java.util.ArrayList;
import java.util.Scanner;

class Animal {
    String name;
    int lifeExpect, age;

    Animal(String name, int lifeExpect) {
        this.name = name;
        this.lifeExpect = lifeExpect;
        this.age = 0;
        String line = String.format(
                "%s was born with life expectancy %d year(s)",
                this.name, this.lifeExpect);
        System.out.println(line);
    }

    boolean isAlive() {
        boolean live = this.age < this.lifeExpect;
        if (live) {
            System.out.println(this.name + " is alive");
        } else {
            System.out.println(this.name + " is dead");
        }
        return live;
    }

    void live(int year) {
        // 1. อยู่ไปอีก year ปีและยังไม่ตาย พิมพ์ว่าอยู่ต่อมาปีกี่ (year)
        // 2. ตายก่อนครบ year ปี พิมพ์ว่าอยู่มาอีกกี่ปีถึงตาย (lifeExpect - age)
        // 3. ตายอยู่ก่อนแล้ว พิมพ์ว่า died earlier
        // 4. ตายตอนครบ year ปีพอดี พิมพ์เหมือนข้อ 2
        if (this.age >= this.lifeExpect) {
            System.out.println(this.name + " died earlier");
            return;
        }

        if (this.age + year < this.lifeExpect) {
            String line;
            if (year > 1) {
                line = String.format(
                        "%s lived %d more years",
                        this.name, year);
            } else {
                line = String.format(
                        "%s lived %d more year",
                        this.name, year);
            }
            System.out.println(line);
            this.age += year;
        }

        else {
            int left = this.lifeExpect - this.age;
            String line;
            if (left > 1) {
                line = String.format(
                        "%s lived %d more years and died",
                        this.name, left);
            } else {
                line = String.format(
                        "%s lived %d more year and died",
                        this.name, left);
            }
            System.out.println(line);
            this.age = this.lifeExpect;
        }
    }

}

public class AnimalDomain1 {

    static void testConstructor() {
        new Animal("Toto", 15);
        new Animal("Pika", 50);
        new Animal("Momo", 8);
        new Animal("Mana", 4);
        new Animal("Luna", 1);
    }

    static void testIsAlive() {
        Animal a = new Animal("Toto", 0);
        boolean alive = a.isAlive();
        System.out.println(alive);

        Animal a2 = new Animal("Toto", 15);
        boolean alive2 = a2.isAlive();
        System.out.println(alive2);
    }

    static void testLive() {
        Animal a = new Animal("Toto", 15);
        a.live(3);
        a.live(1);
        a.live(11);

        Animal b = new Animal("Momo", 8);
        b.live(6);
        b.live(7);
    }

    static void testSum() {
        Animal b = new Animal("Momo", 8);
        b.isAlive();
        b.live(6);
        b.isAlive();
        b.live(7);
        b.isAlive();
    }

    public static void main(String[] args) {
        // testConstructor();
        // testIsAlive();
        // testLive();
        // testSum();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        ArrayList<Animal> as = new ArrayList<Animal>();
        for (int i = 0; i < N; ++i) {
            int type = scan.nextInt();
            if (type == 1) {
                String name = scan.next();
                int lifeExpect = scan.nextInt();
                as.add(new Animal(name, lifeExpect));
            } else if (type == 2) {
                int id = scan.nextInt() - 1;
                int year = scan.nextInt();
                as.get(id).live(year);
            } else if (type == 3) {
                int id = scan.nextInt() - 1;
                as.get(id).isAlive();
            }
        }
        scan.close();
    }
}
