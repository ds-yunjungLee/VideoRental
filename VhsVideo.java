import java.util.Date;

public class VhsVideo extends Video {
    private final int penalty = 1; // 2, 3
    private final int limit = 5; // 3, 2

    public VhsVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    public int getLateReturnPointPenalty() {
        return penalty;
    }

    public int getDaysRentedLimit() {
        return limit;
    }
}
