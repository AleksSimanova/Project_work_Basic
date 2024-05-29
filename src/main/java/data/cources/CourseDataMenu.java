package data.cources;


public enum CourseDataMenu{

    TESTING("Тестирование"),
    DEV("Програмирование");
    

    private String name;

    CourseDataMenu(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}