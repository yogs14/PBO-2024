// Main class to test the implementation
public class TicketReservationSystem {
    public static void main(String[] args) {
        Ticket economyTicket = new EconomyTicket(1000);
        Ticket businessTicket = new BusinessTicket(1000);
        Ticket firstClassTicket = new FirstClassTicket(1000);

        System.out.println("Economy Ticket Fare: " + economyTicket.calculateFare());
        System.out.println("Business Ticket Fare: " + businessTicket.calculateFare());
        System.out.println("First Class Ticket Fare: " + firstClassTicket.calculateFare());
    }
}