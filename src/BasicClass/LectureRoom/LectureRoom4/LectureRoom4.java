package BasicClass.LectureRoom.LectureRoom4;

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

public class LectureRoom4 {
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
        int N = sc.nextInt();
        for (int i = 0; i < N; ++i) {
            int classCode = sc.nextInt();
            int seats = sc.nextInt();
            boolean valid = false;
            for (int k = 0; k < K; ++k) {
                LectRoom lr = lrs[k];
                if (lr.classCode == classCode && lr.reserveSeats(seats)) {
                    System.out.println(lr.name);
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                System.out.println("sorry");
            }
        }
    }
}
