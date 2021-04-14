import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class BasicJavaTest{
    public static void main(String[] args){
        BasicJava test = new BasicJava();
        test.print255();
        test.print255Odd();
        test.print255RunningTotal();

        int[] arr = {1,3,5,7,9,13};
        int[] arr2 =  {-3, -5, -7};
        double[] arr3 = {1,3,5,7,9,13};
        test.printArray(arr);
        test.printMax(arr2);
        test.printAverage(arr);
        test.printAverage(arr2);
        ArrayList<Integer> y = test.get255Odd();
        System.out.println(y);
        test.greaterThanY(arr,3);
        System.out.println(Arrays.toString(test.squareValues(arr)));
        System.out.println(Arrays.toString(test.noNegatives(arr2)));
        System.out.println(Arrays.toString(test.maxMinAvg(arr3)));
        System.out.println(Arrays.toString(test.shiftValues(arr)));
    }
}