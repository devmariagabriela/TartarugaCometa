package dao;

import java.sql.*;
import java.util.*;
import db.DatabaseUtil;
import model.Cliente;
import model.Endereco;

public class ClienteDAO {

    public void inserir(Cliente c) throws SQLException {
        String sql = "INSERT INTO clientes (tipo_pessoa, cpf_cnpj, nome_razao_social, logradouro, numero, complemento, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getTipoPessoa());
            stmt.setString(2, c.getCpfCnpj());
            stmt.setString(3, c.getNomeRazaoSocial());
            stmt.setString(4, c.getEndereco().getLogradouro());
            stmt.setString(5, c.getEndereco().getNumero());
            stmt.setString(6, c.getEndereco().getComplemento());
            stmt.setString(7, c.getEndereco().getBairro());
            stmt.setString(8, c.getEndereco().getCidade());
            stmt.setString(9, c.getEndereco().getEstado());
            stmt.setString(10, c.getEndereco().getCep());

            stmt.executeUpdate();
        }
    }

    public List<Cliente> listar() throws SQLException {
        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes ORDER BY id";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Endereco e = new Endereco(
                        rs.getString("logradouro"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep")
                );

                Cliente c = new Cliente(
                        rs.getInt("id"),
                        rs.getString("tipo_pessoa"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("nome_razao_social"),
                        e
                );

                lista.add(c);
            }
        }
        return lista;
    }
}
