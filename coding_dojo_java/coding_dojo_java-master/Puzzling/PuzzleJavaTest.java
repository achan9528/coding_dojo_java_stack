import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class PuzzleJavaTest{
    public static void main(String[] args){
        PuzzleJava test = new PuzzleJava();
        System.out.println(Arrays.toString(test.greaterThan10()));
        System.out.println(Arrays.toString(test.nameShuffle()));
        test.alphabetShuffle();
        test.randomInts();
        test.randomString();
        test.tenRandomStrings();
    }
}