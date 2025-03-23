package biblioteca.modelos;
// Criando a classe "Publicacao" com seus devidos atributos
public class Publicacao {
    // Quando um atributo é protected, as subclasses podem acessar diretamente esse atributo, tornando o código mais simples em alguns contextos.
    protected String titulo;
    protected String autor;
    protected String editora;
    protected String tipo;
    protected int numeroDePaginas;
    private double somaAvaliacoes;
    private int totalDeAvaliacoes;
    
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

// Criando o método para trabalhar com as notas dadas para as publicações
    public void avalia(double nota){
        somaAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double retornaMedia() {
        return somaAvaliacoes / totalDeAvaliacoes;
    }

    public void exibeMedia() {
        System.out.println("Avaliações: " + retornaMedia());
    }

    // Criando o médoto para exibir a ficha literária da publicação
    public void exibeFichaLiteraria() {
        System.out.println("\n--- Ficha Literária ---");
        System.out.println("Título: " + titulo);
        System.out.println("Nome do autor (a): " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("Número de páginas: " + numeroDePaginas);

    }
}
