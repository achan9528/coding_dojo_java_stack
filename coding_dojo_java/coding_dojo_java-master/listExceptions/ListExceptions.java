import java.util.ArrayList;

public class ListExceptions{
    public void castToInt(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
            } catch(ClassCastException e){
                System.out.println(e.toString());
                System.out.println("Occurred at " + i);
                System.out.println(myList.get(i));
            }
        }
    }
}