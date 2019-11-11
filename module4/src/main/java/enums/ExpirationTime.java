package enums;

import java.util.NoSuchElementException;

public enum ExpirationTime {
    DAY("A day", 1),
    WEEK("A week", 7),
    MONTH("A month", 31),
    YEAR("A year", 366);

    private String name;
    private int days;

    ExpirationTime(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public static int getDays(String name) {
        for (ExpirationTime exp : ExpirationTime.values()) {
            if (exp.name.equalsIgnoreCase(name)) {
                return exp.geDayCount();
            }
        }
        throw new NoSuchElementException("Can't find expire period called " + name);
    }

    private int geDayCount() {
        return days;
    }
}
