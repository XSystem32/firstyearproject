package firstyear.project.models;


import java.util.Date;

public class SalesOverview {
    private int id;
    private Date date;
    private double credit;
    private double cash;
    private double till;
    private double vault;


    public SalesOverview() {
    }

    public SalesOverview(int id, Date date, double credit, double cash, double till, double vault) {
        this.id = id;
        this.date = date;
        this.credit = credit;
        this.cash = cash;
        this.till = till;
        this.vault = vault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCredit() {
        return credit;
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

    @Override
    public String toString() {
        return "SalesOverview{" +
                "id=" + id +
                ", date=" + date +
                ", credit=" + credit +
                ", cash=" + cash +
                ", till=" + till +
                ", vault=" + vault +
                '}';
    }
}
