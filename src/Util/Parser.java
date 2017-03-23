package Util;

public class Parser {

    public static <T extends Object>T parse(Object from, T defaultValue){
        if(from == null) {
            return defaultValue;
        }

        try{
            T t = from instanceof Integer ? (T)Integer.valueOf(from.toString()) :
                  from instanceof Double  ? (T)Double.valueOf(from.toString()) :
                  from instanceof String ? (T)String.valueOf(from.toString()) :
                  (T)from;
            return t;
        }
        catch(Exception ex){
            return defaultValue;
        }
    }

}
