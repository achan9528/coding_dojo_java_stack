import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava{
    public int[] greaterThan10(){
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 10){
                arrList.add(arr[i]);
            }
            sum+=arr[i];
        }

        int[] returnArr = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++){
            returnArr[i] = arrList.get(i);
        }

        System.out.println(sum);
        return returnArr;
    }

    public String[] nameShuffle(){
        ArrayList<String> names = new ArrayList<String>(Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));
        Collections.shuffle(names);
        System.out.println(Arrays.toString(names.toArray()));

        ArrayList<String> longNames = new ArrayList<String>();
        for (int i = 0; i < names.size(); i++){
            if (names.get(i).length() > 5){
                longNames.add(names.get(i));
            };
        }
        String[] returnArr = new String[longNames.size()];
        for (int i = 0; i < longNames.size(); i++){
            returnArr[i] = longNames.get(i);
        }

        return returnArr;
    }

    public void alphabetShuffle(){
        String abcString = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
        String[] abcArr = abcString.split(",");
        ArrayList<String> abcList = new ArrayList<String>(Arrays.asList(abcArr));
        Collections.shuffle(abcList);

        System.out.println("Last letter is: " + abcList.get(abcList.size()-1));
        String first = abcList.get(0);
        System.out.println("First letter is: " + first); 
        if (first.equals("a") || first.equals("e") || first.equals("i") || first.equals("o") || first.equals("u")){
            System.out.println("First letter is a vowel!");
        }
    }

    public void randomInts(){
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Random r = new Random();
        int num = 55;
        for (int i = 0; i < 10; i++){
                num += r.nextInt(45);
                arrList.add(num);
                num = 55;
        }
        Collections.sort(arrList);
        System.out.println(Arrays.toString(arrList.toArray()));
        System.out.println(arrList.get(0));
        System.out.println(arrList.get(arrList.size()-1));
    }

    public void randomString(){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String returnString = "";
        Random r = new Random();
        for (int i = 0; i < 5; i++){
            int randomIndex = r.nextInt(25);
            returnString += abc.substring(randomIndex, randomIndex + 1);
        }
        System.out.println(returnString);
    }

    public void tenRandomStrings(){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String returnString = "";
        int randomIndex;
        String[] randomStrings = new String[10];
        Random r = new Random();
        for (int n = 0; n < 10; n++){
            for (int i = 0; i < 5; i++){
                randomIndex = r.nextInt(25);
                returnString += abc.substring(randomIndex, randomIndex + 1);
            }
            randomStrings[n] = returnString;
            returnString = "";
        }
        
        System.out.println(Arrays.toString(randomStrings));
    }
}