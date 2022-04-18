import java.util.Date;

public class Rental {
	private enum Status {
		RENTED, RETURNED
	}
	private Video video ;
	private Status status ;
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = Status.RENTED ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public boolean isRented() {
		if (status == Status.RENTED)
			return true;
		else
			return false;
	}

	public boolean isReturned() {
		if (status == Status.RETURNED)
			return true;
		else
			return false;
	}

	public void returnVideo() {
		if ( status == Status.RENTED ) {
			status = Status.RETURNED;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented ;
		daysRented = getDaysRented();
		
		if ( daysRented <= 2) return limit ;

		return video.getDaysRentedLimit();
	}

	public int getDaysRented() {
		long targetTime;		
		if (isReturned()) {
			targetTime = returnDate.getTime();
		} else {
			targetTime = new Date().getTime();
		}

		long diff = targetTime - rentDate.getTime();
		int daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;

		return daysRented;
	}

    String getVideoTitle() {
        return video.getTitle();
    }

    boolean isVideoRented() {
        return video.isRented();
    }
}
