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
        try(PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM tblCliente WHERE ID = ?")){
            st.setInt(1, cliente.getId());
            st.executeUpdate();
            return cliente;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        throw new Exception("Erro ao deletar cliente.");
    }

    @Override
    public Cliente update(Cliente cliente) throws Exception{
        try(PreparedStatement st = this.getConnection().prepareStatement("UPDATE tblCliente SET Nome = ?, Email = ? WHERE ID = ?")){
            st.setString(1, cliente.getName());
            st.setString(2, cliente.getMail());
            st.setInt(3, cliente.getId());
            st.executeUpdate();
            return cliente;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        throw new Exception("Erro ao atualizar cliente");
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
    public Cliente getClienteByID(int id) throws Exception{
        try(PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM tblCliente WHERE ID = ?")){
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()){
                while(rs.next()){
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("ID"));
                    c.setName(rs.getString("Nome"));
                    c.setMail(rs.getString("Email"));
                    return c;
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        throw new Exception("Erro ao recuperar cliente");
    }
}
