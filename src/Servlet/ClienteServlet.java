package Servlet;

import Model.Cliente;
import Model.DAO.DAOFactory;
import Util.Parser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int id      = Parser.parse(request.getParameter("clienteID"), 0);
            String name = request.getParameter("clienteName");
            String mail = request.getParameter("clienteMail");

            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setName(name);
            cliente.setMail(mail);

            switch(request.getParameter("oQueFazer")){
                case "Cadastrar":
                    cliente.setId(0);
                    DAOFactory.initClienteDAO().saveUpdate(cliente);
                    request.setAttribute("Cliente", cliente);
                    request.setAttribute("Acao", "Cadastrar");
                    request.getRequestDispatcher("clienteInformation.jsp").forward(request, response);
                    break;
                case "Deletar":
                    DAOFactory.initClienteDAO().delete(cliente);
                    request.setAttribute("Cliente", cliente);
                    request.setAttribute("Acao", "Deletar");
                    request.getRequestDispatcher("clienteInformation.jsp").forward(request, response);
                    break;
                case "Atualizar":
                    DAOFactory.initClienteDAO().saveUpdate(cliente);
                    request.setAttribute("Cliente", cliente);
                    request.setAttribute("Acao", "Atualizar");
                    request.getRequestDispatcher("clienteInformation.jsp").forward(request, response);
                    break;
                case "Obter":
                    Cliente c = DAOFactory.initClienteDAO().getClienteByID(cliente.getId());
                    request.setAttribute("Cliente", c);
                    request.setAttribute("Acao", "Obter");
                    request.getRequestDispatcher("clienteInformation.jsp").forward(request, response);
                    break;
                default:
                    Exception ex = new Exception("Parametros invalidos.");
                    request.setAttribute("Exception", ex);
                    break;
            }

        }catch(Exception ex){
            request.setAttribute("Exception", ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}
