package Exam;

public class Fish extends Animal implements Pet{
    private String name;
    public Fish(String name){
        super();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    void eat(){

    };
    public void play(){

    };
    void walk(){

    };
}
