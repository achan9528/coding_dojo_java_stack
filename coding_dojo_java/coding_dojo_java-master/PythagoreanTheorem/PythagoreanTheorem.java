import java.lang.Math;
public class PythagoreanTheorem{
    public static void main(String[] args){

    }

    public double calculateHypotenuse(int legA, int legB){
        return Math.sqrt(Math.pow(legA,2) + Math.pow(legB,2));
    }
}