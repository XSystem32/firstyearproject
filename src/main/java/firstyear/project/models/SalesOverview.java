package firstyear.project.models;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SalesOverview {
    private int id;
    private LocalDate date;
    private double credit;
    private double cash;
    private double till;
    private double vault;
    private String comment;
    private LocalDateTime localDateTime;

    public SalesOverview() {
        this.date = LocalDate.now();
    }

    public SalesOverview(int id, LocalDate date, double credit, double cash, double till, double vault, String comment) {
        this.id = id;
        this.date = date;
        this.credit = credit;
        this.cash = cash;
        this.till = till;
        this.vault = vault;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", date=" + date +
                ", credit=" + credit +
                ", cash=" + cash +
                ", till=" + till +
                ", vault=" + vault +
                ", comment='" + comment + '\'' +
                '}';
    }
}