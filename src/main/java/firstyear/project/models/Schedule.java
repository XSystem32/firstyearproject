package firstyear.project.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Schedule {

    private int scheduleId;
    private LocalDate start;
    private LocalDate end;
    private List<Shift> shifts;
    private List<Booking> bookings;

    public Schedule() {
    }

    public Schedule(int scheduleId, LocalDate start, LocalDate end, List<Shift> shifts, List<Booking> bookings) {
        this.scheduleId = scheduleId;
        this.start = start;
        this.end = end;
        this.shifts = shifts;
        this.bookings = bookings;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }
    public void setStart(String start){
        this.start = LocalDate.parse(start);
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
    public void setEnd(String end){
        this.end = LocalDate.parse(end);
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
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
                ", shifts=" + shifts +
                ", bookings=" + bookings +
                '}';
    }
}
