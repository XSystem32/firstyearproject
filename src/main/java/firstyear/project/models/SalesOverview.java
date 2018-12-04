package firstyear.project.models;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class SalesOverview {
    private int salesOverviewId;

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate date;

    private double credit;
    private double cash;
    private double till;
    private double vault;
    private String comment;

    public SalesOverview() {
        this.date = LocalDate.now();
    }

    public SalesOverview(int salesOverviewId, LocalDate date, double credit, double cash, double till, double vault, String comment) {
        this.salesOverviewId = salesOverviewId;
        this.date = date;
        this.credit = credit;
        this.cash = cash;
        this.till = till;
        this.vault = vault;
        this.comment = comment;
    }

    public int getSalesOverviewId() {
        return salesOverviewId;
    }

    public void setSalesOverviewId(int salesOverviewId) {
        this.salesOverviewId = salesOverviewId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCredit() {
        return credit;
    }

    public void setDate(Date date){
        this.date = date.toLocalDate();
    }

    public void setDate(String date){
        this.date = LocalDate.parse(date);
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getTill() {
        return till;
    }

    public void setTill(double till) {
        this.till = till;
    }

    public double getVault() {
        return vault;
    }

    public void setVault(double vault) {
        this.vault = vault;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getDateString(){
        return date.toString();
    }


    @Override
    public String toString() {
        return "SalesOverview{" +
                "salesOverviewId=" + salesOverviewId +
                ", date=" + date +
                ", credit=" + credit +
                ", cash=" + cash +
                ", till=" + till +
                ", vault=" + vault +
                ", comment='" + comment + '\'' +
                '}';
    }
}