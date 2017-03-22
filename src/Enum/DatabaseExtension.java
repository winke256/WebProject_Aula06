package Enum;

public class DatabaseExtension {

    public static String getName(Database database){
        switch(database){
            case USJT:
                return "USJT";
            default:
                return "";
        }
    }

}
