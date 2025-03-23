package biblioteca.modelos;

public class Revista extends Publicacao {
    private String edicao;
    private String assunto;
    private String issn;
    private int numeroDeArtigos;
    
    public String getEdicao() {
        return edicao;
    }
    public String getAssunto() {
        return assunto;
    }
    public String getIssn() {
        return issn;
    }
    public int getNumeroDeArtigos() {
        return numeroDeArtigos;
    }
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public void setIssn(String issn) {
        this.issn = issn;
    }
    public void setNumeroDeArtigos(int numeroDeArtigos) {
        this.numeroDeArtigos = numeroDeArtigos;
    }

    @Override
    public void exibeFichaLiteraria() {
        super.exibeFichaLiteraria(); // Chama o método da superclasse para exibir atributos comuns
        System.out.println("Assunto: " + assunto);
        System.out.println("Edição: " + edicao);
        System.out.println("ISSN: " + issn);
        System.out.println("Número de artigos: " + numeroDeArtigos);
        System.out.println("Tipo de publicação: Revista");
    }
}
