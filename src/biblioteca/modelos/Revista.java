package biblioteca.modelos;
import biblioteca.interfaces.Digitalizavel;

public class Revista extends Publicacao implements Digitalizavel {
    private String edicao;
    private String assunto;
    private String issn;
    private int numeroDeArtigos;

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
        this.numeroDeArtigos = numeroDeArtigos;
    }

    @Override
    protected void exibeFichaEspecifica() {
        System.out.println("Tipo: Revista");
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
        System.out.println("Versão digital da revista gerada com sucesso.");
    }
}