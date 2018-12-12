package firstyear.project.models;

import java.time.LocalTime;

public class Shift {

    private int shiftId;
    private LocalTime start;
    private LocalTime end;
    private User user;

    public Shift() {
    }

    public Shift(int shiftId, LocalTime start, LocalTime end, User user) {
        this.shiftId = shiftId;
        this.start = start;
        this.end = end;
        this.user = user;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setStart(String start){
        this.start = LocalTime.parse(start);
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public void setEnd(String end){
        this.end = LocalTime.parse(end);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiftId=" + shiftId +
                ", start=" + start +
                ", end=" + end +
                ", user=" + user +
                '}';
    }
}
