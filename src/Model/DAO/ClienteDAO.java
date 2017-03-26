package Model.DAO;

import Model.Cliente;

public interface ClienteDAO extends DAO<Cliente> {

    Cliente getClienteByID(int id) throws Exception;

}
