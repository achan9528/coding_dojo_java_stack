public class BatTest{
    public static void main(String[] args){
        Bat test = new Bat();
        test.attackTown();
        test.attackTown();
        test.attackTown();

        test.eatHumans();
        test.eatHumans();

        test.fly();
        test.fly();
        
        System.out.println(test.getEnergyLevel());
    }
}