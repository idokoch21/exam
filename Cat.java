package Exam;

public class Cat extends Animal implements Pet{
    private String name;
    public Cat(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    void eat(){

    };
    public void play(){

    };
}
