public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }

    /**
     * Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " + amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " + (price - balance) + " more cents.");
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    public static void main(String[] args) {
        // Create a TicketMachine with a ticket price of 100 cents (1 dollar).
        TicketMachine machine = new TicketMachine(100);

        // Test inserting money and printing a ticket.
        System.out.println("Ticket price: " + machine.getPrice() + " cents");
        machine.insertMoney(50);
        System.out.println("Current balance: " + machine.getBalance() + " cents");
        machine.printTicket(); // Not enough money

        machine.insertMoney(50); // Add more money
        System.out.println("Current balance: " + machine.getBalance() + " cents");
        machine.printTicket(); // Should print the ticket

        // Refund any remaining balance.
        int refund = machine.refundBalance();
        System.out.println("Refunded: " + refund + " cents");
    }
}
