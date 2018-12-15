package firstyear.project.models;

import java.time.LocalTime;

public class Shift {

    private int shiftId;
    private LocalTime start;
    private LocalTime end;
    private User user;
    private int scheduleId;

    public Shift() {
    }

    public Shift(int shiftId, LocalTime start, LocalTime end, User user, int schedule) {
        this.shiftId = shiftId;
        this.start = start;
        this.end = end;
        this.user = user;
        this.scheduleId = schedule;
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

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setStart(String start){
        this.start = LocalTime.parse(start);
    }

    public void setEnd(String end){
        this.end = LocalTime.parse(end);
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiftId=" + shiftId +
                ", start=" + start +
                ", end=" + end +
                ", user=" + user +
                ", scheduleId=" + scheduleId +
                '}';
    }
}
