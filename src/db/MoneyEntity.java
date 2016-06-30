package db;

import java.io.Serializable;

public class MoneyEntity implements Serializable {
    private int id;
    private double money;

    public MoneyEntity(int id, double money) {
        this.id = id;
        this.money = money;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "MoneyEntity{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
