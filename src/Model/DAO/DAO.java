package Model.DAO;

public interface DAO<T extends Object> {

    T save(T t) throws Exception;

    T saveUpdate(T t) throws Exception;

    T delete (T t) throws Exception;

    T update(T t) throws Exception;

}
