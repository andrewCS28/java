import java.util.Optional;

public class Duration {
    private final int TOTAL_SECS;

    /**
     * constructs a duration from hours, minutes, and seconds
     * @param h hours >=0
     * @param m minutes >=0 & <60
     * @param s seconds >=0 & <60
     */
    public Duration(int h, int m, int s) {
        this.TOTAL_SECS = h * 3600 + m * 60 + s;
    }

    /**
     * Computes duration from totol seconds
     * @param s number of seconds
     */
    public Duration(int s) {
        this.TOTAL_SECS = s;
    }

    /**
     * Constructs a duration by parsing a string in "hh:mm:ss" format
     * @param t the string in that format
     */
    public Duration(String t) {
        this.TOTAL_SECS = ((Integer.parseInt(t.substring(0, 2))) * 3600) + (Integer.parseInt((t.substring(3, 5))) * 60) +
                (Integer.parseInt(t.substring(6)));
    }

    /**
     * Gets the toatal numnber of seconds represented by this duration
     * @return total number of seconds
     */
    public int getNumberOfSeconds() {
        return this.TOTAL_SECS;
    }

    /**
     * Total number of whole minutes represented by this duration
     * @return totall number of minutes
     */
    public int getNumberOfMinutes() {
        return this.TOTAL_SECS / 60;
    }

    /**
     * Gets total number of hours represented by this duration
     * @return total number of hours
     */
    public int getNumberOfHours() {
        return this.TOTAL_SECS / 3600;
    }

    /**
     * Returns a string representation of the duration in "hh:mm:ss" format, singles are padded with a leading 0
     * @return formateed string duration
     */
    @Override
    public String toString() {
        int h = this.TOTAL_SECS / 3600;
        int m = (this.TOTAL_SECS % 3600) /60;
        int s = this.TOTAL_SECS % 60;

        String hh;
        String mm;
        String ss;

        if (h<10) {
            hh = "0" + h;
        } else {
            hh = ""+h;
        }
        if (m<10) {
            mm = "0" + m;
        } else {
            mm = ""+m;
        }
        if (s<10) {
            ss = "0" + s;
        } else {
            ss = ""+s;
        }

        return hh + ":" + mm + ":" + ss;
    }

    /**
     * Compares this duration to another object for equality
     * @param o the reference object with which to compare.
     * @return true if both objects represent the same duration, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Duration) {
            Duration other = (Duration) o;
            return this.TOTAL_SECS == other.TOTAL_SECS;
        }
        return false;
    }

    /**
     * Adds a given duration to this duration and returns the result as a new object
     * @param D the duration to add
     * @return a new duration representing the sum
     */
    public Duration addDuration(Duration D){
        return new Duration( D.TOTAL_SECS + this.TOTAL_SECS);
    }

    /**
     * Subtracts the given duration from this duration
     * @param d the duration to subtract
     * @return an Optional containing the new Duration, or empty if the result is negative
     */
    public Optional<Duration> subtractDuration(Duration d) {
        int resultSecs = this.TOTAL_SECS - d.TOTAL_SECS;
        if (resultSecs < 0) {
            return Optional.empty();
        } else {
            return Optional.of(new Duration(resultSecs));
        }
    }


}
