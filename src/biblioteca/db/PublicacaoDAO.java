package biblioteca.db;

import biblioteca.modelos.Ebook;
import biblioteca.modelos.Livro;
import biblioteca.modelos.Publicacao;
import biblioteca.modelos.Revista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PublicacaoDAO {

    public Publicacao salvar(Publicacao publicacao) throws SQLException {
        String sql = "INSERT INTO PUBLICACAO (TITULO, AUTOR, EDITORA, NUMERO_DE_PAGINAS, TIPO, " +
                "GENERO, VOLUME, ISBN, NUMERO_DE_CAPITULOS, " +
                "EDICAO, ASSUNTO, ISSN, NUMERO_DE_ARTIGOS, " +
                "TAMANHO_EM_MB, FORMATO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, publicacao.getTitulo());
            pstmt.setString(2, publicacao.getAutor());
            pstmt.setString(3, publicacao.getEditora());

            if (publicacao.getNumeroDePaginas() > 0) {
                pstmt.setInt(4, publicacao.getNumeroDePaginas());
            } else {
                pstmt.setNull(4, Types.INTEGER);
            }
            pstmt.setString(5, publicacao.getTipo());

            if (publicacao instanceof Livro livro) {
                pstmt.setString(6, livro.getGenero());
                pstmt.setInt(7, livro.getVolume() > 0 ? livro.getVolume() : Types.NULL ); // Correção para setInt
                if (livro.getVolume() <=0) pstmt.setNull(7, Types.INTEGER); else pstmt.setInt(7, livro.getVolume());
                pstmt.setString(8, livro.getIsbn());
                if (livro.getNumeroDeCapitulos() <=0) pstmt.setNull(9, Types.INTEGER); else pstmt.setInt(9, livro.getNumeroDeCapitulos());

                pstmt.setNull(10, Types.VARCHAR); pstmt.setNull(11, Types.VARCHAR);
                pstmt.setNull(12, Types.VARCHAR); pstmt.setNull(13, Types.INTEGER);
                pstmt.setNull(14, Types.INTEGER); pstmt.setNull(15, Types.VARCHAR);
            } else if (publicacao instanceof Revista revista) {
                pstmt.setNull(6, Types.VARCHAR); pstmt.setNull(7, Types.INTEGER);
                pstmt.setNull(8, Types.VARCHAR); pstmt.setNull(9, Types.INTEGER);

                pstmt.setString(10, revista.getEdicao());
                pstmt.setString(11, revista.getAssunto());
                pstmt.setString(12, revista.getIssn());
                // numeroDeArtigos pode ser 0
                if (revista.getNumeroDeArtigos() < 0) pstmt.setNull(13, Types.INTEGER); else pstmt.setInt(13, revista.getNumeroDeArtigos());


                pstmt.setNull(14, Types.INTEGER); pstmt.setNull(15, Types.VARCHAR);
            } else if (publicacao instanceof Ebook ebook) {
                pstmt.setNull(6, Types.VARCHAR); pstmt.setNull(7, Types.INTEGER);
                pstmt.setNull(8, Types.VARCHAR); pstmt.setNull(9, Types.INTEGER);
                pstmt.setNull(10, Types.VARCHAR); pstmt.setNull(11, Types.VARCHAR);
                pstmt.setNull(12, Types.VARCHAR); pstmt.setNull(13, Types.INTEGER);

                if (ebook.getTamanhoEmMB() <= 0) pstmt.setNull(14, Types.INTEGER); else pstmt.setInt(14, ebook.getTamanhoEmMB());
                pstmt.setString(15, ebook.getFormato());
            } else {
                for (int i = 6; i <= 15; i++) {
                    if (i == 7 || i == 9 || i == 13 || i == 14) {
                        pstmt.setNull(i, Types.INTEGER);
                    } else {
                        pstmt.setNull(i, Types.VARCHAR);
                    }
                }
            }

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        publicacao.setId(generatedKeys.getLong(1));
                    }
                }
            }
            System.out.println("Publicação '" + publicacao.getTitulo() + "' salva com ID: " + publicacao.getId());
            return publicacao;
        }
    }

    public List<Publicacao> buscarTodos() throws SQLException {
        List<Publicacao> publicacoesEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM PUBLICACAO";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String tipo = rs.getString("TIPO");
                Publicacao pub = null;

                long id = rs.getLong("ID");
                String titulo = rs.getString("TITULO");
                String autor = rs.getString("AUTOR");
                String editora = rs.getString("EDITORA");
                int numeroDePaginasDb = rs.getInt("NUMERO_DE_PAGINAS");

                if ("Livro".equals(tipo)) {
                    Livro livro = new Livro();
                    livro.setGenero(rs.getString("GENERO"));
                    int volumeDb = rs.getInt("VOLUME");
                    if (volumeDb > 0) livro.setVolume(volumeDb);
                    livro.setIsbn(rs.getString("ISBN"));
                    int numCapitulosDb = rs.getInt("NUMERO_DE_CAPITULOS");
                    if (numCapitulosDb > 0) livro.setNumeroDeCapitulos(numCapitulosDb);
                    pub = livro;
                } else if ("Revista".equals(tipo)) {
                    Revista revista = new Revista();
                    revista.setEdicao(rs.getString("EDICAO"));
                    revista.setAssunto(rs.getString("ASSUNTO"));
                    revista.setIssn(rs.getString("ISSN"));
                    int numArtigosDb = rs.getInt("NUMERO_DE_ARTIGOS");
                    // Para numeroDeArtigos, 0 é permitido pelo setter (validação é < 0)
                    // rs.getInt() retorna 0 para NULL, então precisamos checar wasNull se 0 e NULL devem ser tratados diferentemente.
                    // Se o DB pode ter NULL e o setter não aceita o resultado de getInt(que seria 0 para NULL),
                    // ou se 0 é um valor válido mas diferente de NULL.
                    // No seu caso, o setter permite 0. Se o campo no DB for NULL, getInt retorna 0, o setter aceita.
                    if (!rs.wasNull() || numArtigosDb >=0) { // Garante que não era null ou que o valor é >=0
                        revista.setNumeroDeArtigos(numArtigosDb);
                    } // Se era null e o setter não aceitasse 0, não chamaria o setter.

                    pub = revista;
                } else if ("Ebook".equals(tipo)) {
                    Ebook ebook = new Ebook();
                    int tamanhoMbDb = rs.getInt("TAMANHO_EM_MB");
                    if (tamanhoMbDb > 0) ebook.setTamanhoEmMB(tamanhoMbDb);
                    ebook.setFormato(rs.getString("FORMATO"));
                    pub = ebook;
                }

                if (pub != null) {
                    pub.setId(id);
                    pub.setTitulo(titulo);
                    pub.setAutor(autor);
                    pub.setEditora(editora);
                    if (numeroDePaginasDb > 0) {
                        pub.setNumeroDePaginas(numeroDePaginasDb);
                    }
                    publicacoesEncontradas.add(pub);
                }
            }
        }
        return publicacoesEncontradas;
    }
}