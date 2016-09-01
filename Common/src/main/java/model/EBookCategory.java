package model;

public enum EBookCategory {
    ART("art"),
    EDUCATION("education"),
    GAMES("games"),
    LAW("law"),
    PETS("pets"),
    COMPUTERS("computers");

    final private String name;

    EBookCategory(String categoryName) {
        name = categoryName;
    }

    @Override
    public String toString(){
        return name;
    }

}
