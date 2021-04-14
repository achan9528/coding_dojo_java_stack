public class ProjectTest{
    public static void main(String[] args){
        Project test = new Project();
        Project test2 = new Project("Project Test 2");
        Project test3 = new Project("Project Test 3", "This is a Test Project!");
        System.out.println(test.elevatorPitch());
        System.out.println(test2.elevatorPitch());
        System.out.println(test3.elevatorPitch());
    }
}