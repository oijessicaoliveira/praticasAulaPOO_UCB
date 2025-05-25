package biblioteca.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:h2:mem:bibliotecaDB;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver H2 não encontrado! Verifique o classpath.");
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar driver H2.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void initializeDatabase() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS PUBLICACAO (\n" +
                "    ID BIGINT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    TITULO VARCHAR(255) NOT NULL,\n" +
                "    AUTOR VARCHAR(255),\n" +
                "    EDITORA VARCHAR(255),\n" +
                "    NUMERO_DE_PAGINAS INT,\n" +
                "    TIPO VARCHAR(50) NOT NULL,\n" +
                "    GENERO VARCHAR(100),\n" +
                "    VOLUME INT,\n" +
                "    ISBN VARCHAR(50),\n" +
                "    NUMERO_DE_CAPITULOS INT,\n" +
                "    EDICAO VARCHAR(100),\n" +
                "    ASSUNTO VARCHAR(100),\n" +
                "    ISSN VARCHAR(50),\n" +
                "    NUMERO_DE_ARTIGOS INT,\n" +
                "    TAMANHO_EM_MB INT,\n" +
                "    FORMATO VARCHAR(50)\n" +
                ");";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCreateTable);
            System.out.println("Banco de dados H2 inicializado e tabela PUBLICACAO verificada/criada.");
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar o banco de dados ou criar tabela:");
            e.printStackTrace();
        }
    }
}