package fr.dopse.billandfriends.model;

import java.io.Serializable;

/**
 * Details of a member of a bill.
 * Created by dopse.
 */
public class Member implements Serializable {

    private String name;
    private Float paid;
    private Float balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPaid() {
        return paid;
    }

    public void setPaid(Float paid) {
        this.paid = paid;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
