public class Project{
    private String name;
    private String desc;

    public Project(){
        this.name = "(No Project Name)";
        this.desc = "(No Project Description)";
    }

    public Project(String name){
        this.name = name;
        this.desc = "No Project Description";
    }

    public Project(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getProjectName(){
        return this.name;
    }

    public String getProjectDescription(){
        return this.desc;
    }

    public String elevatorPitch(){
        return this.name + ":\n" + this.desc;
    }

    public void setProjectName(String name){
        this.name = name;
    }

    public void setProjectDescription(String desc){
        this.desc = desc;
    }
}