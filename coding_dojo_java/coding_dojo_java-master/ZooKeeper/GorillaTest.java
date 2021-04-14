public class GorillaTest{
    public static void main(String[] args){
        Gorilla test = new Gorilla();
        test.throwSomething();
        test.throwSomething();
        test.throwSomething();

        test.eatBananas();
        test.eatBananas();

        test.climb();

        System.out.println(test.getEnergyLevel());
    }
}