import java.util.Date;


public class CdVideo extends Video {
    private final int penalty = 2;
    private final int limit = 3;

    public CdVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    public int getLateReturnPointPenalty() {
        return penalty;
    }

    public int getDaysRentedLimit() {
        return limit;
    }

}
