public class Gorilla extends Mammal{
    public void throwSomething(){
        this.changeEnergyLevel(-5);
        System.out.println("Gorilla threw something and lost 5 energy!");
    }

    public void eatBananas(){
        this.changeEnergyLevel(10);
        System.out.println("Gorilla ate some bananas and gained 10 energy!");
    }

    public void climb(){
        this.changeEnergyLevel(-10);
        System.out.println("Gorilla climbed and lost 10 energy!");
    }
}