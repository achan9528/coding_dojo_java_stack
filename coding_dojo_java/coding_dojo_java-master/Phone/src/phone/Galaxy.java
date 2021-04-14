package phone;

public class Galaxy extends Phone implements Ringable{
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        String message = this.getRingTone();
        return message;
    }
    @Override
    public String unlock() {
    	String message = "Unlocking via fingerprint!";
        return message;
    }
    @Override
    public void displayInfo() {
    	String message = "Galaxy S9 from Verizon";
    	System.out.println(message);        
    }
}
