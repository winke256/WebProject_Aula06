package Model.DAO;

import Model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Dictionary;
import Enum.*;

public class ClienteDAOImpl extends DAOImpl<Cliente> implements ClienteDAO{

    public ClienteDAOImpl(){
        super(Database.USJT);
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception{
        try(PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO tblCliente (nome, email) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)){
            st.setString(1, cliente.getName());
            st.setString(2, cliente.getMail());
            st.executeUpdate();
            try(ResultSet rs = st.getGeneratedKeys()){
                while(rs.next()){
                    int id = rs.getInt(1);
                    if(id > 0){
                        cliente.setId(id);
                        return cliente;
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        throw new Exception("Erro ao inserir cliente.");
    }

    @Override
    public Cliente saveUpdate(Cliente cliente) throws Exception{
        if(cliente == null){
            throw new Exception("Cliente não pode ser nulo.");
        }
        return cliente.getId() > 0 ? update(cliente) : save(cliente);
    }

    @Override
    public Cliente delete(Cliente cliente) throws Exception{
        return null;
    }

    @Override
    public Cliente update(Cliente cliente) throws Exception{
        return null;
    }

    @Override
    public Cliente parserToDTO(ResultSet resultSet) throws Exception{
        return null;
    }

    @Override
    public Dictionary<String, Object> parseToParameters(Cliente cliente) throws Exception {
        return null;
    }

    @Override
    public Cliente getClienteByID(int id) {
        return null;
    }
}
