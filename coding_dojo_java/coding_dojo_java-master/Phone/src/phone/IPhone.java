package phone;

public class IPhone extends Phone implements Ringable{
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        String message = this.getRingTone();
        return message;
    }
    @Override
    public String unlock() {
        String message = "Unlocking via facial recognition!";
        return message;
    }
    @Override
    public void displayInfo() {
        String message = "IPhone X from AT&T!";
        System.out.println(message);
    }
}
