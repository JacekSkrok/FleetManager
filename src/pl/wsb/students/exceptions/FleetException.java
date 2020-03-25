package pl.wsb.students.exceptions;

public class FleetException extends Exception {

    public FleetException() {
        super("Fleet management unspecified error...");
    }

    public FleetException(String message) {
        super(message);
    }

}
