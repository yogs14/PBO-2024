// Subclass EconomyTicket
class EconomyTicket extends Ticket {
    public EconomyTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 0.9; // 10% discount
    }
}