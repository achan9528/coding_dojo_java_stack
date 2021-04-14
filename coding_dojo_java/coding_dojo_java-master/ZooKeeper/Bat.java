public class Bat extends Mammal{
    public Bat(){
        this.setEnergyLevel(300);
    }

    public void fly(){
        this.changeEnergyLevel(-50);
        System.out.println("Whooosh! Up, up, and away! (-50 energy)");
    }

    public void eatHumans(){
        this.changeEnergyLevel(25);
        System.out.println("Yum.....(+25 energy)");
    }

    public void attackTown(){
        this.changeEnergyLevel(-100);
        System.out.println("So many bats!!!! (-100 energy)");
    }
}