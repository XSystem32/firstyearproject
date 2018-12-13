package firstyear.project.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Schedule {

    private int scheduleId;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private LocalDate scheduleDate;
    private List<Shift> shifts;
    private List<Booking> bookings;

    public Schedule() {
    }

    public Schedule(int scheduleId, LocalTime start, LocalTime end, List<Shift> shifts, List<Booking> bookings) {
        this.scheduleId = scheduleId;
        this.openingTime = start;
        this.closingTime = end;
        this.shifts = shifts;
        this.bookings = bookings;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    public void setStart(String start){
        this.openingTime = LocalTime.parse(start);
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    public void setEnd(String end){
        this.closingTime = LocalTime.parse(end);
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
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", shifts=" + shifts +
                ", bookings=" + bookings +
                '}';
    }
}
