// Subclass BusinessTicket
class BusinessTicket extends Ticket {
    public BusinessTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.25; // 25% additional charge
    }
}