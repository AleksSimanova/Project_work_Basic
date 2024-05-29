package data;

public enum MainMenuItemsData {
    COURSES("Курсы");
    private String name;
    MainMenuItemsData (String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
