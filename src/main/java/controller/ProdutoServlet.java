package controller;

import dao.ProdutoDAO;
import model.Produto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> lista = dao.listar();

            req.setAttribute("produtos", lista);
            req.getRequestDispatcher("produtos/listar.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Produto p = new Produto(
                0,
                req.getParameter("nome"),
                req.getParameter("descricao"),
                Double.parseDouble(req.getParameter("peso")),
                Double.parseDouble(req.getParameter("volume")),
                Double.parseDouble(req.getParameter("valor"))
        );

        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.inserir(p);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("produtos");
    }
}
