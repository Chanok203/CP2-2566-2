package BasicClass.Covid19Wins.Covid19Wins2;

import java.util.ArrayList;
import java.util.Scanner;

class Visitation {
    int id;
    int date;
    int[] hours;

    Visitation(int id, int date) {
        this.id = id;
        this.date = date;
        this.hours = new int[24];
    }

    void visit(int hour) {
        if (hour < 0 || 23 < hour) {
            System.out.println("invalid hour: " + hour);
            return;
        }
        ++this.hours[hour];
    }

    int count() {
        int c = 0;
        for (int i = 0; i < this.hours.length; ++i) {
            c += this.hours[i];
        }
        return c;
    }

    void printVisitHours(String name) {
        System.out.println(name);
        System.out.println(this.date);
        System.out.println(this.count());

        String line = "";
        for (int i = 0; i < this.hours.length; ++i) {
            if (0 < this.hours[i]) {
                line += i + " ";
            }
        }
        if (line.length() == 0) {
            line = "no visit";
        }
        System.out.println(line);
    }
}

class Person {

    String name;
    ArrayList<Visitation> vs;

    Person(String name) {
        this.name = name;
        vs = new ArrayList<>();
    }

    void addVisitation(Visitation v) {
        if (v.count() == 0) {
            return;
        }
        vs.add(v);
    }

    void printAllVisitations(String[] names) {
        int L = this.vs.size();
        System.out.println(L);
        for (int i = 0; i < L; ++i) {
            Visitation v = this.vs.get(i);
            String name = names[v.id];
            v.printVisitHours(name);
        }
    }
}

public class Covid19Wins2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        String[] names = new String[301];
        for (int i = 0; i < P; ++i) {
            int id = sc.nextInt();
            String name = sc.next();
            names[id] = name;
        }
        String personName = sc.next();
        Person p = new Person(personName);
        int N = sc.nextInt();
        for (int i = 0; i < N; ++i) {
            int id = sc.nextInt();
            int date = sc.nextInt();
            int K = sc.nextInt();

            Visitation v = new Visitation(id, date);
            for (int k = 0; k < K; ++k) {
                int hour = sc.nextInt();
                v.visit(hour);
            }
            p.addVisitation(v);
        }
        p.printAllVisitations(names);
        sc.close();
    }
}
