package firstyear.project.models;

import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Schedule {



    private int scheduleId;
    @DateTimeFormat(pattern = "HH:mm:ss")
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
        if (start == null){
            this.openingTime = LocalTime.of(0,0,0);
        } else {
            this.openingTime = LocalTime.parse(start);
        }

    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    public void setEnd(String end){
        if (end == null){
             this.closingTime = LocalTime.of(0,0,0);
        } else {
            this.closingTime = LocalTime.parse(end);
        }

    }
    public void setClosingTime(int hour, int minute){
        this.closingTime = LocalTime.of(hour, minute);
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

    public void addShift(ResultSet result) throws SQLException {
        Shift shift = new Shift();
        shift.setShiftId(result.getInt("shiftId"));
        shift.setStart(result.getString("start"));
        shift.setEnd(result.getString("end"));
        shift.setScheduleId(result.getInt("scheduleId"));
        User user = new User();
        user.setUserId(result.getInt("userId"));
        user.setFullName(result.getString("fullName"));
        user.setPassword(result.getString("userPassword"));
        user.setUsername(result.getString("username"));
        user.setClearance(result.getInt("clearance"));

        shift.setUser(user);
        shifts.add(shift);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", scheduleDate=" + scheduleDate +
                ", shifts=" + shifts +
                ", bookings=" + bookings +
                '}';
    }
}
