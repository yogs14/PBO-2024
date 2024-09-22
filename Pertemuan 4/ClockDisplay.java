import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockDisplay extends JFrame {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private JLabel clockLabel;
    private String displayString;

    public ClockDisplay() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
        setupUI();
        startClock();
    }

    public ClockDisplay(int hour, int minute) {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
        setupUI();
        startClock();
    }

    private void setupUI() {
        // Set up the frame (the window)
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create a label to display the time
        clockLabel = new JLabel(displayString, SwingConstants.CENTER);
        clockLabel.setFont(new Font("Monospaced", Font.BOLD, 48));
        clockLabel.setForeground(Color.CYAN);
        add(clockLabel, BorderLayout.CENTER);

        // Add the current date at the top
        JLabel dateLabel = new JLabel("TUE, 24 SEP, 2024", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
        dateLabel.setForeground(Color.CYAN);
        add(dateLabel, BorderLayout.NORTH);

        // Make the window visible
        setVisible(true);
    }

    private void startClock() {
        // Create a timer to update the time every second
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeTick();
                clockLabel.setText(displayString); // Update the label with the new time
            }
        });
        timer.start();
    }

    public void timeTick() {
        minutes.increment();
        if (minutes.getValue() == 0) {
            hours.increment();
        }
        updateDisplay();
    }

    public void setTime(int hour, int minute) {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    public String getTime() {
        return displayString;
    }

    private void updateDisplay() {
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
    }

    public static void main(String[] args) {
        // Initialize the clock with default time (23:59 for example)
        new ClockDisplay(23, 59);
    }
}

class NumberDisplay {
    private int limit;
    private int value;

    public NumberDisplay(int rollOverLimit) {
        limit = rollOverLimit;
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayValue() {
        return value < 10 ? "0" + value : "" + value;
    }

    public void setValue(int replacementValue) {
        if (replacementValue >= 0 && replacementValue < limit) {
            value = replacementValue;
        }
    }

    public void increment() {
        value = (value + 1) % limit;
    }
}

