package Inheritance.AnimalDomain.AnimalDomain2;

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

    void vaccine() {
        String line = String.format(
                "%s's life expectancy is now %d year(s)",
                this.name,
                this.lifeExpect);
        System.out.println(line);
    }
}

class Dog extends Animal {
    boolean wasVaccinated;

    Dog(String name) {
        super(name, 8);
    }

    @Override
    void vaccine() {
        if (!this.wasVaccinated) {
            int left = this.lifeExpect - this.age;
            this.lifeExpect += left;
            this.wasVaccinated = true;
        }
        super.vaccine();
    }
}

class Turtle extends Animal {
    Turtle(String name) {
        super(name, 50);
    }
}

class Salmon extends Animal {
    Salmon(String name) {
        super(name, 4);
    }
}

public class AnimalDomain2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        ArrayList<Animal> as = new ArrayList<Animal>();
        for (int i = 0; i < N; ++i) {
            int type = scan.nextInt();
            if (type == 1) {
                int animalType = scan.nextInt();
                String name = scan.next();
                Animal a = null;
                if (animalType == 1) {
                    a = new Dog(name);
                } else if (animalType == 2) {
                    a = new Turtle(name);
                } else if (animalType == 3) {
                    a = new Salmon(name);
                }
                as.add(a);
            } else if (type == 2) {
                int id = scan.nextInt() - 1;
                int year = scan.nextInt();
                as.get(id).live(year);
            } else if (type == 3) {
                int id = scan.nextInt() - 1;
                as.get(id).isAlive();
            } else if (type == 4) {
                int id = scan.nextInt() - 1;
                as.get(id).vaccine();
            }
        }
        scan.close();
    }
}
