public class Mammal{
    private int energyLevel;

    public Mammal(){
        this.energyLevel = 100;
    }

    public Mammal(int energyLevel){
        this.energyLevel = energyLevel;
    }

    public void setEnergyLevel(int energyLevel){
        this.energyLevel = energyLevel;
    }

    public void changeEnergyLevel(int change){
        this.energyLevel += change;
    }

    public int getEnergyLevel(){
        return this.energyLevel;
    }

    public void displayEnergy(){
        System.out.println("Energy Level: " + Integer.toString(energyLevel));
    }
}