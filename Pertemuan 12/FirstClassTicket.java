// Subclass FirstClassTicket
class FirstClassTicket extends Ticket {
    public FirstClassTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.5; // 50% additional charge
    }
}