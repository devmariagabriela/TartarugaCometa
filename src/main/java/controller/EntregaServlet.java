package controller;

import dao.EntregaDAO;
import model.Entrega;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;

@WebServlet("/entregas")
public class EntregaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            EntregaDAO dao = new EntregaDAO();
            List<Entrega> lista = dao.listar();

            req.setAttribute("entregas", lista);
            req.getRequestDispatcher("entregas/listar.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Entrega e = new Entrega(
                0,
                null,
                null,
                req.getParameter("status"),
                new Date(),
                new Date(),
                req.getParameter("observacoes"),
                Double.parseDouble(req.getParameter("valorFrete"))
        );

        try {
            EntregaDAO dao = new EntregaDAO();
            dao.inserir(e);

        } catch (SQLException er) {
            throw new RuntimeException(er);
        }

        resp.sendRedirect("entregas");
    }
}
