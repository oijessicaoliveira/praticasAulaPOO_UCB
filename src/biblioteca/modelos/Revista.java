package biblioteca.modelos;
public class Revista extends Publicacao implements Digitalizavel {
    // Atributos específicos de Revista
    private String edicao;
    private String assunto;
    private String issn;
    private int numeroDeArtigos;

    // GETTERS
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

    // SETTERS
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

    /*
     Exemplo de sobrescrita (Override):
     Sobrescrevemos o método "exibeFichaLiteraria()" para revista.
     */
    @Override
    public void exibeFichaLiteraria() {
        // Mostra atributos genéricos da superclasse
        super.exibeFichaLiteraria();

        // Mostra atributos específicos de "Revista"
        System.out.println("Assunto: " + assunto);
        System.out.println("Edição: " + edicao);
        System.out.println("ISSN: " + issn);
        System.out.println("Número de artigos: " + numeroDeArtigos);
        System.out.println("Tipo de publicação: Revista");
    }

    @Override
    public void geraVersaoDigital() {
        System.out.println("Gerando versão digital da revista: " + getTitulo());
    }
}