package Servlet;

import Model.Cliente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente c = new Cliente();
        c.setName(request.getParameter("clienteName"));
        c.setFone(request.getParameter("clienteFone"));
        c.setMail(request.getParameter("clienteMail"));

        //Send info to cliente.jsp
        request.setAttribute("Cliente", c);
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}
