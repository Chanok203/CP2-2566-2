package BasicClass.LectureRoom.LectureRoom2;

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

public class LectureRoom2 {
    
}
