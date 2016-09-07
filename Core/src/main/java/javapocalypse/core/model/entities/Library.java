package javapocalypse.core.model.entities;

public enum Library {

    EMPIK_COM {
        @Override
        public String toString() {
            return "empik_com";
        }
    },

    EBOOKS_COM {
        @Override
        public String toString() {
            return "ebooks_com";
        }
    };

    public static Library from(String name) {
        return valueOf(name.toUpperCase());
    }

}
