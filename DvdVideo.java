import java.util.Date;

public class DvdVideo  extends Video {
    private final int penalty = 3;
    private final int limit = 2;

    public DvdVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    public int getLateReturnPointPenalty() {
        return penalty;
    }

    public int getDaysRentedLimit() {
        return limit;
    }

}
