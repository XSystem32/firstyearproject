package firstyear.project.models;

import java.time.LocalTime;
import java.util.List;

public class Schedule {

    private String schedule;
    private LocalTime start;
    private LocalTime end;
    private List<Shift> shifts;
    private List<Booking> bookings;

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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "schedule{" +
                "schedule='" + schedule + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", shifts=" + shifts +
                ", bookings=" + bookings +
                '}';
    }

    public Schedule(String schedule, LocalTime start, LocalTime end, List<firstyear.project.models.Shift> shifts, List<Booking> bookings) {
        this.schedule = schedule;
        this.start = start;
        this.end = end;
        this.shifts = shifts;
        this.bookings = bookings;
    }
}
