package firstyear.project.models;

import java.time.LocalDate;
import java.util.List;

public class Schedule {

    private int scheduleId;
    private LocalDate openingTime;
    private LocalDate closingTime;
    private LocalDate scheduleDate;
    private List<Shift> shifts;
    private List<Booking> bookings;

    public Schedule() {
    }

    public Schedule(int scheduleId, LocalDate start, LocalDate end, List<Shift> shifts, List<Booking> bookings) {
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

    public LocalDate getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDate openingTime) {
        this.openingTime = openingTime;
    }
    public void setStart(String start){
        this.openingTime = LocalDate.parse(start);
    }

    public LocalDate getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDate closingTime) {
        this.closingTime = closingTime;
    }
    public void setEnd(String end){
        this.closingTime = LocalDate.parse(end);
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
