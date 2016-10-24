package fr.dopse.billandfriends.model;

import java.io.Serializable;

/** details of an action.
 * Created by dopse.
 */
public class Action implements Serializable {

    private String giver;
    private String recipient;
    private String amount;

    public String getGiver() {
        return giver;
    }

    public void setGiver(String giver) {
        this.giver = giver;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
