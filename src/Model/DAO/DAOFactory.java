package Model.DAO;

public class DAOFactory {

    public static ClienteDAO initClienteDAO(){
        return new ClienteDAOImpl();
    }

}
