package firstyear.project.models;

import java.time.LocalTime;

public class Shift {

    private LocalTime start;
    private LocalTime end;
    private User user;

    public Shift() {
    }

    public Shift(LocalTime start, LocalTime end, User user) {
        this.start = start;
        this.end = end;
        this.user = user;
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

    @Override
    public String toString() {
        return "Shift{" +
                "start=" + start +
                ", end=" + end +
                ", user=" + user +
                '}';
    }
}
