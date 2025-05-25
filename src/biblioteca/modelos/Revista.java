package biblioteca.modelos;
import biblioteca.interfaces.Digitalizavel;

public class Revista extends Publicacao implements Digitalizavel {
    private String edicao;
    private String assunto;
    private String issn;
    private int numeroDeArtigos;

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

    public Revista() {
        // Construtor padrão
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
        if (numeroDeArtigos < 0) {
            throw new IllegalArgumentException("Número de artigos não pode ser negativo.");
        }
        this.numeroDeArtigos = numeroDeArtigos;
    }

    @Override
    protected void exibeFichaEspecifica() {
        System.out.println("Assunto: " + assunto);
        System.out.println("Edição: " + edicao);
        System.out.println("ISSN: " + issn);
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