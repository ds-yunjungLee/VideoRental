import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;

public class VRControl {
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Video> videos = new ArrayList<Video>();
    private VideoFactory videoFactory = new VideoFactory();
    public VRControl() {
    }

    public Customer findCustomer(String customerName) {
        Customer foundCustomer = null ;
        for ( Customer customer: customers) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }
        return foundCustomer;
    }

    void init() {
        Customer james = new Customer("James") ;
        Customer brown = new Customer("Brown") ;
        customers.add(james) ;
        customers.add(brown) ;

        Video v1 = videoFactory.createVideo("CD", "v1", Video.REGULAR, new Date());
        Video v2 = videoFactory.createVideo("DVD", "v2", Video.NEW_RELEASE, new Date());
        videos.add(v1) ;
        videos.add(v2) ;

        Rental r1 = new Rental(v1) ;
        Rental r2 = new Rental(v2) ;

        james.addRental(r1) ;
        james.addRental(r2) ;
    }

    public List<Video> getVideos() {
        return Collections.unmodifiableList(this.videos);
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(this.customers);
    }

    public void addVideo(String videoType, String title, int priceCode, Date date) {
        Video video = this.videoFactory.createVideo(videoType, title, priceCode, date);
        this.videos.add(video);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void returnVideo(Customer customer, String videoTitle) {

        List<Rental> customerRentals = customer.getRentals();
        for ( Rental rental: customerRentals ) {
            if (rental.getVideoTitle().equals(videoTitle) == false) continue;
            if (rental.isVideoRented()) {                
                rental.returnVideo();
                customerRentals.remove(rental);
                break ;
            }
        }
    }

    public void rentVideo(Customer foundCustomer, String videoTitle) {
        Video foundVideo = null ;

        for ( Video video: videos) {
            if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
                foundVideo = video ;
                break ;
            }
        }

        if ( foundVideo == null ) return ;

        Rental rental = new Rental(foundVideo) ;
        foundCustomer.addRental(rental);
    }


}