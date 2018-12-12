package firstyear.project.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Schedule {

    private int scheduleId;
    private LocalTime start;
    private LocalTime end;
    private List<Booking> bookings;

    public Schedule() {
    }

    public Schedule(int scheduleId, LocalTime start, LocalTime end, List<Booking> bookings) {
        this.scheduleId = scheduleId;
        this.start = start;
        this.end = end;
        this.bookings = bookings;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", start=" + start +
                ", end=" + end +
                ", bookings=" + bookings +
                '}';
    }
}
