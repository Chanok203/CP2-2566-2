package BasicClass.Covid19Wins.Covid19Wins1;

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

    void printVisitHours() {
        System.out.println(this.id);
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

public class Covid19Wins1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int date = sc.nextInt();
        int K = sc.nextInt();
        Visitation v = new Visitation(id, date);
        for (int i = 0; i < K; ++i) {
            int hour = sc.nextInt();
            v.visit(hour);
        }
        v.printVisitHours();
        sc.close();
    }
}
