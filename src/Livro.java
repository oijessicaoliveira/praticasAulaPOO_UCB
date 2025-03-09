public class Livro {
    
    String titulo;
    String autor;
    String editora;
    int numeroDePaginas;
    boolean lido;
    double avaliacao;
    int totalDeAvaliacoes;

    void exibeFichaLiteraria(){
        System.out.println("Nome do livro: " + titulo);
        System.out.println("Nome do autor (a): " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("Número de páginas: " + numeroDePaginas);
        System.out.println("Lido? " + lido);
        System.out.println("Avaliação: " + avaliacao);
    }

}
