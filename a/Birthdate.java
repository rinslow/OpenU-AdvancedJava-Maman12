package a;

import java.util.Date;

public class Birthdate {
    private final Date date;

    public Birthdate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public boolean isThisMonth() {
        Date today = new Date();
        return today.getMonth() == date.getMonth();
    }
}
