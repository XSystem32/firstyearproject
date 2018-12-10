package firstyear.project.models;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Booking {

    private int bookingId;
    private String BandName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bandDate;

    private double bandCost;
    private String bandEmail;
    private int bandPhone;
    private String contactName;
    private String webside;


    public Booking() {
    }

    public Booking(int bookingId, String bandName, LocalDate bandDate, double bandCost, String bandEmail, int bandPhone, String contactName, String webside) {
        this.bookingId = bookingId;
        BandName = bandName;
        this.bandDate = bandDate;
        this.bandCost = bandCost;
        this.bandEmail = bandEmail;
        this.bandPhone = bandPhone;
        this.contactName = contactName;
        this.webside = webside;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBandName() {
        return BandName;
    }

    public void setBandName(String bandName) {
        BandName = bandName;
    }

    public LocalDate getBandDate() {
        return bandDate;
    }

    public void setBandDate(LocalDate bandDate) {
        this.bandDate = bandDate;
    }

    public double getBandCost() {
        return bandCost;
    }

    public void setBandCost(double bandCost) {
        this.bandCost = bandCost;
    }

    public String getBandEmail() {
        return bandEmail;
    }

    public void setBandEmail(String bandEmail) {
        this.bandEmail = bandEmail;
    }

    public int getBandPhone() {
        return bandPhone;
    }

    public void setBandPhone(int bandPhone) {
        this.bandPhone = bandPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getWebside() {
        return webside;
    }

    public void setWebside(String webside) {
        this.webside = webside;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", BandName='" + BandName + '\'' +
                ", bandDate=" + bandDate +
                ", bandCost=" + bandCost +
                ", bandEmail='" + bandEmail + '\'' +
                ", bandPhone=" + bandPhone +
                ", contactName='" + contactName + '\'' +
                ", webside='" + webside + '\'' +
                '}';
    }
}
