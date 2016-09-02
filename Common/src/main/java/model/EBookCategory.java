package model;

public enum EBookCategory {
    art("art"),
    education("education"),
    games("games"),
    law("law"),
    pets("pets"),
    computers("computers");

    final private String name;

    EBookCategory(String categoryName) {
        name = categoryName;
    }

    @Override
    public String toString(){
        return name;
    }

}
