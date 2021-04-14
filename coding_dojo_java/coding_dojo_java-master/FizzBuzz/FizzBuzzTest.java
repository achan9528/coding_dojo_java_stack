public class FizzBuzzTest{
    public static void main(String[] args){
        FizzBuzz test1 = new FizzBuzz();
        String answer1 = test1.fizzBuzz(3);
        String answer2 = test1.fizzBuzz(5);
        String answer3 = test1.fizzBuzz(15);
        String answer4 = test1.fizzBuzz(1);
        
        System.out.println("Answer: " + answer1);
        System.out.println("Answer: " + answer2);
        System.out.println("Answer: " + answer3);
        System.out.println("Answer: " + answer4);
    }
}