package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import Enum.*;

public abstract class DAOImpl<T> implements DAO<T> {

    private final String CONECTION_IP   = "127.0.0.1";
    private final String CONECTION_USER = "root";
    private final String CONECTION_PASS = "123456";

    private String database;

    public String getDatabase() {
        return this.database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public DAOImpl(Database database){
        setDatabase(DatabaseExtension.getName(database));
    }

    public abstract T save(T t) throws Exception;

    public abstract T saveUpdate(T t) throws Exception;

    public abstract T delete (T t) throws Exception;

    public abstract T update(T t) throws Exception;

    public abstract T parserToDTO(ResultSet resultSet) throws Exception;

    public abstract Dictionary<String, Object> parseToParameters(T t) throws Exception;

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://"+CONECTION_IP+"/"+getDatabase()+"", CONECTION_USER, CONECTION_PASS);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

}
