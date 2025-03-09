public class Livro {
    
    String nome;
    String autor;
    String editora;
    int numeroDePaginas;
    boolean lido;
    double avaliacao;
    int totalDeAvaliacoes;

    void exibeFichaLiteraria(){
        System.out.println("Nome do livro: " + nome);
        System.out.println("Nome do autor (a): " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("Número de páginas: " + numeroDePaginas);
        System.out.println("Lido? " + lido);
        System.out.println("Avaliação: " + avaliacao);
    }

}
