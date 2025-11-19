package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static  final String URL = "jdbc:postresql://localhost:5432/tartaruga_cometa";
    private static final  String USER = "postgres";
    private static final  String PASSWORD = "SUA_SENHA";

    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (Exception e){
            throw new RuntimeException("Erro ao conectar ao banco" + e.getMessage());
        }
    }
}
