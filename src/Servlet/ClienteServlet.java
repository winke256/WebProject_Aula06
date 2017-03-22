package Servlet;

import Model.Cliente;
import Model.DAO.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int id = Integer.parseInt(request.getParameter("clienteID"));
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
                    request.getRequestDispatcher("").forward(request, response);
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
