/* public class ClockDisplay {
    private numberDisplay hours;
    private numberDisplay minutes;
    private String displayString;    // simulates the actual display
}

public ClockDisplay() {
    hours = new NumberDisplay(24);
    minutes = new NumberDisplay(60);
    updateDisplay();
}

public ClockDisplay(int hour, int minute) {
    hours = new NumberDisplay(24);
    minutes = new NumberDisplay(60);
    setTime(hour, minute);
}

public void timeTick() {
    minutes.increment();
    if(minutes.getValue() == 0) {  // it just rolled over!
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
    displayString = hours.getDisplayValue() + ":" + 
                    minutes.getDisplayValue();
}

public class NumberDisplay {
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
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }

    public void setValue(int replacementValue) {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
        else {
            System.out.println("Error: invalid value");
        }

    }

    public void increment() {
        value = (value + 1) % limit;
    }
}

public class TestClock {
    public static void main(String[] args) {
        ClockDisplay clock = new ClockDisplay(23, 59);
    }

    public static void testTimeTick() {
        ClockDisplay clock = new ClockDisplay(23, 59);
        clock.timeTick();
        System.out.println(clock.getTime());
    }

    public static void testSetTime() {
        ClockDisplay clock = new ClockDisplay(23, 59);
        clock.setTime(12, 34);
        System.out.println(clock.getTime());
    }

    public static void testSetTimeInvalid() {
        ClockDisplay clock = new ClockDisplay(23, 59);
        clock.setTime(25, 61);
        System.out.println(clock.getTime());
    }

    public static void testTimeTickRollover() {
        ClockDisplay clock = new ClockDisplay(23, 59);
        for(int i = 0; i < 100; i++) {
            clock.timeTick();
            System.out.println(clock.getTime());
        }
    }

    public static void testTimeTickRollovermidnight() {
        ClockDisplay clock = new ClockDisplay(23, 58);
        for(int i = 0; i < 5; i++) {
            clock.timeTick();
            System.out.println(clock.getTime());
        }
    }
}
*/

public class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;

    public ClockDisplay() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    public ClockDisplay(int hour, int minute) {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    public void timeTick() {
        minutes.increment();
        if(minutes.getValue() == 0) {
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
        TestClock.testTimeTick();
        TestClock.testSetTime();
        TestClock.testSetTimeInvalid();
        TestClock.testTimeTickRollover();
        TestClock.testTimeTickRolloverMidnight();
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
        if(replacementValue >= 0 && replacementValue < limit) {
            value = replacementValue;
        }
    }

    public void increment() {
        value = (value + 1) % limit;
    }
}

class TestClock {
    public static void testTimeTick() {
        ClockDisplay clock = new ClockDisplay(23, 59);
        clock.timeTick();
        System.out.println(clock.getTime());
    }

    public static void testSetTime() {
        ClockDisplay clock = new ClockDisplay(23, 59);
        clock.setTime(12, 34);
        System.out.println(clock.getTime());
    }

    public static void testSetTimeInvalid() {
        ClockDisplay clock = new ClockDisplay(23, 59);
        clock.setTime(25, 61);
        System.out.println(clock.getTime());
    }

    public static void testTimeTickRollover() {
        ClockDisplay clock = new ClockDisplay(23, 59);
        for(int i = 0; i < 100; i++) {
            clock.timeTick();
            System.out.println(clock.getTime());
        }
    }

    public static void testTimeTickRolloverMidnight() {
        ClockDisplay clock = new ClockDisplay(23, 58);
        for(int i = 0; i < 5; i++) {
            clock.timeTick();
            System.out.println(clock.getTime());
        }
    }
}

