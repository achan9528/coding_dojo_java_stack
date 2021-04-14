public class PythagoreanTheoremTest{
    public static void main(String[] args){
        PythagoreanTheorem test = new PythagoreanTheorem();
        int legA = 3;
        int legB = 4;
        double result = test.calculateHypotenuse(3,4);
        System.out.println(result);
    }
}