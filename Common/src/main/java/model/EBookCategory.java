package model;

public enum EBookCategory {
    ROMANS("romance"),
    EDUCATIION("education"),
    CRIMINAL("true-crime"),
    SCIENSE("science"),
    BIOGRAPHY("biography-autobiography");

    final private String name;

    EBookCategory(String categoryName) {
        name = categoryName;
    }

    @Override
    public String toString(){
        return name;
    }

}
