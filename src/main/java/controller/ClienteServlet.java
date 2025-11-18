package controller;

import dao.ClienteDAO;
import model.Cliente;
import model.Endereco;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> lista = dao.listar();

            req.setAttribute("clientes", lista);
            req.getRequestDispatcher("clientes/listar.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Endereco end = new Endereco(
                req.getParameter("logradouro"),
                req.getParameter("numero"),
                req.getParameter("complemento"),
                req.getParameter("bairro"),
                req.getParameter("cidade"),
                req.getParameter("estado"),
                req.getParameter("cep")
        );

        Cliente c = new Cliente(
                0,
                req.getParameter("tipoPessoa"),
                req.getParameter("cpfCnpj"),
                req.getParameter("nomeRazaoSocial"),
                end
        );

        try {
            ClienteDAO dao = new ClienteDAO();
            dao.inserir(c);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("clientes");
    }
}
