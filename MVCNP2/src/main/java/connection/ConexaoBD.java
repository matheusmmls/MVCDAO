package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mathe
 */
public class ConexaoBD {

    private static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=crud_java;encrypt=true;trustServerCertificate=true;";
    private static final String User = "sa";
    private static final String Senha = "1234";

    public static Connection getConexao() {
        try {
            Connection conexao = DriverManager.getConnection(URL, User, Senha);
            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

}