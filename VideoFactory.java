import java.util.Date;

public class VideoFactory {

    public Video createVideo(String type, String title, int priceCode, Date registeredDate) {
        Video video = null;

        switch(type) {
            case "VHS":
                video = new VhsVideo(title, priceCode, registeredDate);
                break;

            case "CD":
                video = new CdVideo(title, priceCode, registeredDate);
                break;

            case "DVD":
                video = new DvdVideo(title, priceCode, registeredDate);
                break;
        }

        return video;
    }

}