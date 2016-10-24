package fr.dopse.billandfriends.exception;

/**
 * Manage exceptions of the application.
 * Created by dopse.
 */
public class BillAndFriendsException extends Exception {

    public BillAndFriendsException(String message) {
        super(message);
    }

    public BillAndFriendsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BillAndFriendsException(Throwable cause) {
        super(cause);
    }
}
