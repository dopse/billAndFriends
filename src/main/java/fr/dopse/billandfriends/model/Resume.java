package fr.dopse.billandfriends.model;

import java.io.Serializable;
import java.util.List;

/**
 * Resume of a bill with the different actions.
 * Created by dopse.
 */
public class Resume implements Serializable {

    private List<Action> actions;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
