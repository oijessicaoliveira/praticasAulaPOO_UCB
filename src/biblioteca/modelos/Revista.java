package biblioteca.modelos;
import biblioteca.interfaces.Digitalizavel;

public class Revista extends Publicacao implements Digitalizavel {
    private String edicao;
    private String assunto;
    private String issn;
    private int numeroDeArtigos; // Primitivo int será 0 por padrão

    public Revista() {
        // Construtor padrão
    }

    public Revista(String titulo, String autor, String editora, int numeroDePaginas,
                   String assunto, String edicao, String issn, int numeroDeArtigos) {
        setTitulo(titulo);
        setAutor(autor);
        setEditora(editora);
        setNumeroDePaginas(numeroDePaginas);
        setAssunto(assunto);
        setEdicao(edicao);
        setIssn(issn);
        setNumeroDeArtigos(numeroDeArtigos);
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getNumeroDeArtigos() {
        return numeroDeArtigos;
    }

    public void setNumeroDeArtigos(int numeroDeArtigos) {
        if (numeroDeArtigos < 0) { // Permite 0 artigos
            throw new IllegalArgumentException("Número de artigos não pode ser negativo.");
        }
        this.numeroDeArtigos = numeroDeArtigos;
    }

    @Override
    protected void exibeFichaEspecifica() {
        System.out.println("Assunto: " + (assunto == null || assunto.isEmpty() ? "N/A" : assunto));
        System.out.println("Edição: " + (edicao == null || edicao.isEmpty() ? "N/A" : edicao));
        System.out.println("ISSN: " + (issn == null || issn.isEmpty() ? "N/A" : issn));
        // Para numeroDeArtigos, 0 é um valor válido e diferente de "não informado"
        System.out.println("Número de artigos: " + numeroDeArtigos);
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public void geraVersaoDigital() {
        System.out.println("Versão digital da revista '" + getTitulo() + "' gerada com sucesso.");
    }
}