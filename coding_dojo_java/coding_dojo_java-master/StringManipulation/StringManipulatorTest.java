public class StringManipulatorTest{
    public static void main(String[] args){
        StringManipulator manipulator = new StringManipulator();
        System.out.println(manipulator.trimAndConcat("   Hello   ", "   World   "));

        System.out.println(manipulator.getIndexOrNull("Coding", 'o'));
        System.out.println(manipulator.getIndexOrNull("Hi", 'o'));

        System.out.println(manipulator.getIndexOrNull("Hello", "llo"));
        System.out.println(manipulator.getIndexOrNull("Hello", "world"));

        System.out.println(manipulator.concatSubstring("Hello", 1, 2, "world"));
    }
}