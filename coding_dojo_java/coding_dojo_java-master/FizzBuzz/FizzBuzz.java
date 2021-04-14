public class FizzBuzz{
    public static void main(String[] args){
    }    

    public String fizzBuzz(int number){
        String answer;
        if (number % 3 == 0 && number % 5 == 0){
            answer = "FizzBuzz";
        } else if (number % 3 == 0){
            answer = "Fizz";
        } else if (number % 5 == 0){
            answer="Buzz";
        } else{
            answer = "None";
        }
        return answer;
    }
}