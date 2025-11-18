package dao;

import db.DatabaseUtil;
import model.Cliente;
import model.Endereco;
import model.Entrega;

import java.sql.*;
import java.util.*;

public class EntregaDAO {

    public void inserir(Entrega e) throws SQLException {

        String sql = "INSERT INTO entregas (cliente_id, remetente_id, status, data_entrega, data_criacao, observacoes, valor_frete) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, e.getCliente().getId());
            stmt.setInt(2, e.getRemetente().getId());
            stmt.setString(3, e.getStatus());
            stmt.setDate(4, new java.sql.Date(e.getDataEntrega().getTime()));
            stmt.setDate(5, new java.sql.Date(e.getDataCriacao().getTime()));
            stmt.setString(6, e.getObservacoes());
            stmt.setDouble(7, e.getValorFrete());

            stmt.executeUpdate();
        }
    }

    public List<Entrega> listar() throws SQLException {
        List<Entrega> lista = new ArrayList<>();

        String sql = "SELECT * FROM entregas ORDER BY id";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Entrega e = new Entrega(
                        rs.getInt("id"),
                        null,  // cliente
                        null,  // remetente
                        rs.getString("status"),
                        rs.getDate("data_entrega"),
                        rs.getDate("data_criacao"),
                        rs.getString("observacoes"),
                        rs.getDouble("valor_frete")
                );

                lista.add(e);
            }
        }
        return lista;
    }
}
