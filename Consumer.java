package DataCalculator;

/**
 *
 * @author logan
 */
public class Consumer {

    //instance
    private double gbUsed;
    private String firstName;
    private double amtOwed;

    //ctor
    public Consumer(String name) {
        firstName = name;
        gbUsed = 0.0;
        amtOwed = 0.0;
    }

    //accessor
    public double getData() {
        return gbUsed;
    }

    public void setData(double data) {
        gbUsed = data;
    }

    public String getName() {
        return firstName;
    }

    public double getOwed() {
        return amtOwed;
    }

    //setter
    public void setOwed(double amt) {
        amtOwed = amt;
    }
}
