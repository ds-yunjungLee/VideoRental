import java.util.Date;
import java.util.Scanner;

public class VRUI {
    private static Scanner scanner = new Scanner(System.in) ;
    private final VRControl vrControl = new VRControl();

    public static void main(String[] args) {
        VRUI ui = new VRUI() ;

        boolean quit = false ;
        while ( ! quit ) {
            int command = ui.showCommand() ;
            switch ( command ) {
                case 0: quit = true ; break ;
                case 1: ui.listCustomers() ; break ;
                case 2: ui.listVideos() ; break ;
                case 3: ui.register("customer") ; break ;
                case 4: ui.register("video") ; break ;
                case 5: ui.rentVideo() ; break ;
                case 6: ui.returnVideo() ; break ;
                case 7: ui.getCustomerReport() ; break;
                case 8: ui.clearRentals() ; break ;
                case -1: ui.init() ; break ;
                default: break ;
            }
        }
        System.out.println("Bye");
    }

    public void init() {
        vrControl.init();
    }

    public void clearRentals() {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;

        Customer foundCustomer = vrControl.findCustomer(customerName);

        if ( foundCustomer == null ) {
            System.out.println("No customer found") ;
            return;
        }
        
        System.out.println("Name: " + foundCustomer.getName() +
                        "\tRentals: " + foundCustomer.getRentals().size()) ;

        foundCustomer.clearRentals();
    }

    public void returnVideo() {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;
        Customer foundCustomer = vrControl.findCustomer(customerName);

        if ( foundCustomer == null ) return ;

        System.out.println("Enter video title to return: ") ;
        String videoTitle = scanner.next() ;
        
        vrControl.returnVideo(foundCustomer, videoTitle);
    }

    public void listVideos() {
        System.out.println("List of videos");

        for (Video video: vrControl.getVideos()) {
            System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        System.out.println("List of customers");
        for ( Customer customer: vrControl.getCustomers()) {
            System.out.println("Name: " + customer.getName() +
                               "\tRentals: " + customer.getRentals().size()) ;
            for ( Rental rental: customer.getRentals() ) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
            }
        }
        System.out.println("End of list");
    }

    public void getCustomerReport() {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;

        Customer foundCustomer = vrControl.findCustomer(customerName);

        if ( foundCustomer == null ) {
            System.out.println("No customer found");
            return;
        }

        String result = foundCustomer.getReport();
        System.out.println(result);
    }

    public void rentVideo() {
        System.out.println("Enter customer name: ") ;
        String customerName = scanner.next() ;

        Customer foundCustomer = vrControl.findCustomer(customerName);

        if ( foundCustomer == null ) return ;

        System.out.println("Enter video title to rent: ") ;
        String videoTitle = scanner.next() ;

        vrControl.rentVideo(foundCustomer, videoTitle);
    }

    public void register(String object) {
        if ( object.equals("customer") ) {
            System.out.println("Enter customer name: ") ;
            String name = scanner.next();
            Customer customer = new Customer(name) ;
            vrControl.addCustomer(customer); ;
        }
        else {
            System.out.println("Enter video title to register: ") ;
            String title = scanner.next();

            System.out.println("Enter video type(VHD, CD, DVD ):") ;
            String videoType = scanner.next();

            System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
            int priceCode = scanner.nextInt();

            Date registeredDate = new Date();

            vrControl.addVideo(videoType, title, priceCode, registeredDate);
        }
    }

    public int showCommand() {
        System.out.println("\nSelect a command !");
        System.out.println("\t 0. Quit");
        System.out.println("\t 1. List customers");
        System.out.println("\t 2. List videos");
        System.out.println("\t 3. Register customer");
        System.out.println("\t 4. Register video");
        System.out.println("\t 5. Rent video");
        System.out.println("\t 6. Return video");
        System.out.println("\t 7. Show customer report");
        System.out.println("\t 8. Show customer and clear rentals");

        int command = scanner.nextInt() ;

        return command ;

    }
}
