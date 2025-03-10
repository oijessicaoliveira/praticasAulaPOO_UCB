package biblioteca.modelos;

// Criando a classe "Publicacao" com seus devidos atributos
public class Publicacao {
    
    private String titulo;
    private String autor;
    private String editora;
    private String tipo;
    private int numeroDePaginas;
    //private boolean disponivel;
    private double somaAvaliacoes;
    private int totalDeAvaliacoes;

//Liberando os atributos para serem alterados
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

    /*public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }*/

// Criando o médoto para exibir a ficha literária da publicação
    public void exibeFichaLiteraria(){
        System.out.println("Nome do livro: " + titulo);
        System.out.println("Nome do autor (a): " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("Tipo de publicação: " + tipo);
        System.out.println("Número de páginas: " + numeroDePaginas);
    }

// Criando o método para trabalhar com as notas dadas para as publicações
    public void avalia(double nota){
        somaAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double retornaMedia(){
        return somaAvaliacoes / totalDeAvaliacoes;
    }

//Criando o método para trabalhar a parte do empréstimo da publicação
    /*public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Publicação emprestada.");
        } else {
            System.out.println("Publicação disponível.");
        }
    }*/

}
