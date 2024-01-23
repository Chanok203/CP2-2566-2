package BasicClass.LectureRoom3;

import java.util.Scanner;

class LectRoom {
    int classCode, capacity;
    String name;
    int currentSeats = 0;

    LectRoom(int classCode, String name, int capacity) {
        this.classCode = classCode;
        this.name = name;
        this.capacity = capacity;
    }

    boolean reserveSeats(int seats) {
        if (this.capacity < this.currentSeats + seats) {
            return false;
        }
        this.currentSeats += seats;
        return true;
    }
}

public class LectureRoom3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        LectRoom[] lrs = new LectRoom[K];
        for (int i = 0; i < K; ++i) {
            int classCode = sc.nextInt();
            String name = sc.next();
            int capacity = sc.nextInt();
            LectRoom lr = new LectRoom(classCode, name, capacity);
            lrs[i] = lr;
            // lrs[i] = new LectRoom(classCode, name, capacity);
        }
        int N = 3;
        for (int i = 0; i < N; ++i) {
            int idx = sc.nextInt() - 1;
            LectRoom lr = lrs[idx];
            String line = String.format("%d %s %d", lr.classCode, lr.name, lr.capacity);
            System.out.println(line);
        }
    }
}
