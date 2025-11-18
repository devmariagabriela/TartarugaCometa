package dao;

import db.DatabaseUtil;
import model.Produto;

import java.sql.*;
import java.util.*;

public class ProdutoDAO {

    public void inserir(Produto p) throws SQLException {
        String sql = "INSERT INTO produtos (nome, descricao, peso, volume, valor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPeso());
            stmt.setDouble(4, p.getVolume());
            stmt.setDouble(5, p.getValor());
            stmt.executeUpdate();
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM produtos ORDER BY id";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("peso"),
                        rs.getDouble("volume"),
                        rs.getDouble("valor")
                );
                lista.add(p);
            }
        }
        return lista;
    }
}
